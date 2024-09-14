package com.dim.job_offers_service.domain.ports.in;

import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import com.dim.job_offers_service.domain.ports.out.JobOfferOutPort;
import com.dim.job_offers_service.domain.usecases.JobOfferUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Input port is called by driving adapter
 */
@Component
@AllArgsConstructor
public class JobOfferInPort implements JobOfferUseCase {

    private JobOfferOutPort jobOfferOutPort;

    @Override
    public JobOffers findWithCriteria(CriteriaForFinder criteriaForFinder) {
        return jobOfferOutPort.findWithCriteria(criteriaForFinder);
    }

    @Override
    public JobOffer create(JobOffer jobOffer) {
        return jobOfferOutPort.create(jobOffer);
    }
}
