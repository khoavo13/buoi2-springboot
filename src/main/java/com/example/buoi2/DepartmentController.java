package com.example.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/create")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        try{
            if (department.getUsers().size() > 0){
                department.getUsers().forEach(user -> {
                    if (user.getId() == null) {
                        user.setId(UUID.randomUUID().toString());
                    }
                });
            }
            Department _department = departmentRepository.save(department);

            return new ResponseEntity<>(_department, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAll(){
        try {
            List<Department> departments = new ArrayList<>();
            departmentRepository.findAll().forEach(departments::add);

            if (departments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departments, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id){
        try {
            Optional<Department> department = departmentRepository.findById(id);

            if (department.isPresent()) {
                return new ResponseEntity<>(department.get(), HttpStatus.OK);

            }
            else return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getDepartmentById(@PathVariable("id") String id){
        try {
            Optional<Department> department = departmentRepository.findById(id);

            if (department.isPresent()) {
                return new ResponseEntity<>(department.get(), HttpStatus.OK);

            }
            else return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
