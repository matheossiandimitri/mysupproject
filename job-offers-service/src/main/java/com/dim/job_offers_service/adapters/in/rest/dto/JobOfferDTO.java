package com.dim.job_offers_service.adapters.in.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobOfferDTO {
    private String status;
    private String jobOfferProvider;
    private String endCustomer;
    private String title;
    private String description;
    private LocalDateTime lastUpdateDate;
}
