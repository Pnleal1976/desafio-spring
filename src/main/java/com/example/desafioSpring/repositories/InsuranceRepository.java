package com.example.desafioSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafioSpring.entities.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    
}
