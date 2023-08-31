package com.example.desafioSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafioSpring.entities.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, Long> {
    
}
