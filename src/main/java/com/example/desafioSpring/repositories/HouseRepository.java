package com.example.desafioSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafioSpring.entities.House;

public interface HouseRepository extends JpaRepository<House, Long>{
    
}
