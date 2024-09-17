package com.dim.job_offers_service.domain.ports.in;

import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import com.dim.job_offers_service.domain.ports.out.JobOfferOutPort;
import com.dim.job_offers_service.domain.usecases.JobOfferUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Input port is called by driving adapter
 */
@Component
@AllArgsConstructor
@Slf4j
public class JobOfferInPort implements JobOfferUseCase {

    private JobOfferOutPort jobOfferOutPort;

    @Override
    public JobOffers findWithCriteria(CriteriaForFinder criteriaForFinder) {
        log.info("GET Endpoint called !!");
        return jobOfferOutPort.findWithCriteria(criteriaForFinder);
    }

    @Override
    public JobOffer create(JobOffer jobOffer) {
        log.info("POST Endpoint called !!");
        return jobOfferOutPort.create(jobOffer);
    }
}



