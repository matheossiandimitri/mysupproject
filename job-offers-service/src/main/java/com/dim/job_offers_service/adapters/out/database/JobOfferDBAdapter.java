package com.dim.job_offers_service.adapters.out.database;

import com.dim.job_offers_service.adapters.out.database.entities.JobOfferData;
import com.dim.job_offers_service.adapters.out.database.mappers.JobOffersDataMapper;
import com.dim.job_offers_service.adapters.out.database.repositories.JobOfferRepository;
import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import com.dim.job_offers_service.domain.ports.out.JobOfferOutPort;
import com.dim.job_offers_service.domain.usecases.JobOfferUseCase;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Output adapters or driven adapters are called by use cases (e.g. it could provide data from a database).
 * An output adapter implements a set of output port interfaces.
 * It's important to note that the interfaces are determined by the use cases, not the other way around.
 */
@Service
@AllArgsConstructor
public class JobOfferDBAdapter implements JobOfferOutPort {

    final JobOfferRepository jobOfferRepository;
    final JobOffersDataMapper jobOffersDataMapper;

    public JobOffers findWithCriteria(CriteriaForFinder criteriaForFinder) {
        Pageable pageable = PageRequest.of(criteriaForFinder.getPageNumber(), criteriaForFinder.getPageSize());
        List<JobOfferData> jobOfferData = jobOfferRepository.findAll(pageable).toList();
        JobOffers jobOffers = new JobOffers();
        jobOffers.setJobOffers(jobOffersDataMapper.toDomain(jobOfferData));
        jobOffers.setTotal(jobOfferRepository.count());
        return jobOffers;
    }

    @Transactional
    @Override
    public JobOffer create(JobOffer jobOffer) {
        JobOfferData jobOfferDataToSave = jobOffersDataMapper.fromDomain(jobOffer);
        JobOfferData jobOfferDataSaved = jobOfferRepository.save(jobOfferDataToSave);
        return jobOffersDataMapper.toDomain(jobOfferDataSaved);
    }

}
