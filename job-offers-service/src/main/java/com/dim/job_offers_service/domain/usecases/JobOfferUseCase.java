package com.dim.job_offers_service.domain.usecases;

import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;

/**
 * Use case class has no dependencies on external components.
 * If data or functions outside the hexagon are required then an output port is created
 */
public interface JobOfferUseCase {

    JobOffers findWithCriteria(CriteriaForFinder criteriaForFinder);

    JobOffer create(JobOffer jobOffer);
}
