package com.example.desafioSpring.entities;

import java.time.LocalDate;
import com.example.desafioSpring.Enums.OwnershipStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHouse;
    
    @Enumerated(EnumType.STRING)
    private OwnershipStatus ownershipStatus;
    
    private String houseLocation;
    private String zipCode;
    
    private LocalDate houseCreateInfo;
    private LocalDate houseUpdateInfo;
    
    @ManyToOne
    private Client client_idClient;
    
}
