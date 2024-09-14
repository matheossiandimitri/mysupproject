package com.dim.job_offers_service.adapters.out.database.aggregators;

import com.dim.job_offers_service.domain.model.JobOffer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class JobOffersSearchAggregate {
    private List<JobOffer> jobOffers;
    private int total;
}
