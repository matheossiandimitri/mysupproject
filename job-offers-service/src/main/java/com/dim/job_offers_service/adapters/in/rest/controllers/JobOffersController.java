package com.dim.job_offers_service.adapters.in.rest.controllers;

import com.dim.job_offers_service.adapters.in.rest.dto.JobOfferDTO;
import com.dim.job_offers_service.adapters.in.rest.dto.JobOffersFindWithCriteriaResponseDTO;
import com.dim.job_offers_service.adapters.in.rest.mappers.JobOffersRestMapper;
import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import com.dim.job_offers_service.domain.usecases.JobOfferUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * This controller is an adapter
 * Input adapters or driving adapters call the input ports to perform specific tasks
 */
@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("job-offers")
public class JobOffersController {

    final JobOfferUseCase jobOfferUseCase;
    final JobOffersRestMapper jobOffersRestMapper;

    @GetMapping
    public JobOffersFindWithCriteriaResponseDTO findWithCriteria(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                 @RequestParam(name = "size", defaultValue = "10") int size) {
        log.info("Endpoint called !!");
        JobOffers jobOffers = jobOfferUseCase.findWithCriteria(new CriteriaForFinder(size, page));
        return jobOffersRestMapper.fromDomain(jobOffers);
    }

    @PostMapping
    public JobOfferDTO create(@RequestBody JobOfferDTO jobOfferDTO) {
        JobOffer jobOffer = jobOffersRestMapper.toDomain(jobOfferDTO);
        jobOffer = jobOfferUseCase.create(jobOffer);
        return jobOffersRestMapper.fromDomain(jobOffer);
    }
}