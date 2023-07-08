package com.example.demo.service;

import com.example.demo.entity.Theater;

import com.example.demo.repository.TheaterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository repository;

    public Theater saveTheater(Theater theater){
        return repository.save(theater);
    }

    public List<Theater> saveTheaters(List<Theater> theaters){
        return repository.saveAll(theaters);
    }

    public List<Theater> getTheaters(){
        return repository.findAll();
    }

    public Theater getTheaterById(int id){
        return repository.findById(id).orElse(null);
    }

    public Theater getTheaterByName(String name){
        return repository.findByName(name);
    }

    public String deleteTheater(int id){
        repository.deleteById(id);
        return  "Theater removed "+id;
    }

    public Theater updateTheater(Theater theater){
        Theater existingTheater=repository.findById(theater.getId()).orElse( null);
        existingTheater.setName(theater.getName());
        existingTheater.setLocation(theater.getLocation());
        return repository.save(existingTheater);
    }
}
