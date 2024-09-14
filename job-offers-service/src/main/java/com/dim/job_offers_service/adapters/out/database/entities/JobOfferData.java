package com.dim.job_offers_service.adapters.out.database.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job_offers")
@NoArgsConstructor
@Data
public class JobOfferData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String status;
    private String jobOfferProvider;
    private String endCustomer;
    private String title;
    private String description;
    private LocalDateTime lastUpdateDate;
}
