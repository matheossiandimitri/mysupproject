package com.dim.job_offers_service.domain.ports.out;

import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;

/**
 * Simple interface that can be called by use cases when they need something from outside the system
 */
public interface JobOfferOutPort {
    JobOffers findWithCriteria(CriteriaForFinder criteriaForFinder);

    JobOffer create(JobOffer jobOffer);
}
