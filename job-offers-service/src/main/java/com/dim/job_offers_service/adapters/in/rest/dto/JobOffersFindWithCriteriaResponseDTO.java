package com.dim.job_offers_service.adapters.in.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class JobOffersFindWithCriteriaResponseDTO {
    private List<JobOfferDTO> jobOffers;
    private int total;
}
