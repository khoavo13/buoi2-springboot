package com.example.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    HomeRepository homeRepo;


    @GetMapping("/home")
    public ResponseEntity<List<Home>> getAll(@RequestParam(required = false) String title){
        try {
            List<Home> homes = new ArrayList<>();


            homeRepo.findAll().forEach(homes::add);

            System.out.println(homes);
            // if (title == null)
            //     homeRepo.findAll().forEach(homes::add);
            // else
            //     homeRepo.findByPublished(true);
            if (homes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(homes, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

