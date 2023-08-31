package com.example.desafioSpring.entities;

import com.example.desafioSpring.Enums.TypeInsurance;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Insurance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInsurance;

    @Enumerated(EnumType.STRING)
    private TypeInsurance typeInsurance;
    
    private int riskInsurance;

    @Enumerated(EnumType.STRING)
    private AnalysisInsurance analysisInsurance;
    
    private String observationInsurance;
}
