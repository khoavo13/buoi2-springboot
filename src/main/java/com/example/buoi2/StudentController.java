package com.example.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll(@RequestParam(required = false) String title){
        try {
            List<Student> students = new ArrayList<>();


            studentRepository.findAll().forEach(students::add);

            System.out.println(students.toString());
            // if (title == null)
            //     homeRepo.findAll().forEach(homes::add);
            // else
            //     homeRepo.findByPublished(true);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try{
            Student _student = studentRepository.save(student);
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
