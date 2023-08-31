package com.example.desafioSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafioSpring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
