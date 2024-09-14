package com.dim.job_offers_service.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class JobOffers {
    private List<JobOffer> jobOffers;
    /**
     * Total records in DB
     */
    private Long total;
}
