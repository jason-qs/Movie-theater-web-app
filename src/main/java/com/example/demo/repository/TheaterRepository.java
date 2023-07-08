package com.example.demo.repository;

import com.example.demo.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository <Theater,Integer> {
    Theater findByName(String name);
}
