package com.example.desafioSpring.entities;

import java.time.LocalDate;
import java.util.List;

import com.example.desafioSpring.Enums.MaritalStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;

    private String nameClient;
    private String cpfClient;
    private int age;
    private int dependents;
    private double incomeClient;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private LocalDate createInfoClient;
    private LocalDate udateInfoClient;

    @OneToMany(mappedBy = "client_idClient")
    private List<Vehicle> listVehicles;

    @OneToMany(mappedBy = "client_idClient")
    private List<House> listHouses;

    

}
