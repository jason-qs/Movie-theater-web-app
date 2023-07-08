package com.example.demo.controller;

import com.example.demo.entity.Theater;
import com.example.demo.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterController {
    @Autowired
    private TheaterService service;


    @PostMapping("/addTheater")
    public Theater addTheater(@RequestBody Theater theater){
        return service.saveTheater(theater);
    }

    @PostMapping("/addTheaters")
    public List<Theater> addTheaters(@RequestBody List<Theater> theaters){
        return service.saveTheaters(theaters);
    }
    @GetMapping("/theaters")
    public List<Theater> findAllTheaters() {
        return service.getTheaters();
    }


    @GetMapping("/theaterById/{id}")
    public Theater findTheaterById(@PathVariable int id){
        return service.getTheaterById(id);
    }
    @GetMapping("/theaterByName/{name}")
    public Theater findTheaterByName(@PathVariable String name){
        return service.getTheaterByName(name);
    }

    @PutMapping("/updateTheater")
    public Theater updateTheater(@RequestBody Theater theater){
        return service.updateTheater(theater);
    }
    @DeleteMapping("/deleteTheater/{id}")
    public String deleteTheater(@PathVariable int id){
        return service.deleteTheater(id);
    }

}
