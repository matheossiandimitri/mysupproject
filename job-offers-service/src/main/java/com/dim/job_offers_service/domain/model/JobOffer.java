package com.dim.job_offers_service.domain.model;

import com.dim.job_offers_service.domain.model.enums.JobOfferStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobOffer {
    private JobOfferStatus status;
    private String jobOfferProvider;
    private String endCustomer;
    private String title;
    private String description;
    private LocalDateTime lastUpdateDate;
}
