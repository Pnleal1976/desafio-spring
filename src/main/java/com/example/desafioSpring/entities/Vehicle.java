package com.example.desafioSpring.entities;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    
    private String brand;
    private String model;
    private int year;
    
    private LocalDate vehicleCreateInfo;
    private LocalDate vehicleUpdateInfo;

    @ManyToOne
    private Client client_idClient;


}
