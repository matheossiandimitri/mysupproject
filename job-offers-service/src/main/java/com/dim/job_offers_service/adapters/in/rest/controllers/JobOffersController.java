package com.dim.job_offers_service.adapters.in.rest.controllers;

import com.dim.job_offers_service.adapters.in.rest.dto.JobOfferDTO;
import com.dim.job_offers_service.adapters.in.rest.dto.JobOffersFindWithCriteriaResponseDTO;
import com.dim.job_offers_service.adapters.in.rest.mappers.JobOffersRestMapper;
import com.dim.job_offers_service.domain.model.CriteriaForFinder;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import com.dim.job_offers_service.domain.usecases.JobOfferUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.net.URI;

/**
 * This controller is an adapter
 * Input adapters or driving adapters call the input ports to perform specific tasks
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("job-offers")
public class JobOffersController {

    private final JobOfferUseCase jobOfferUseCase;
    private final JobOffersRestMapper jobOffersRestMapper;

    private final RestClient.Builder restClientBuilder;

    @GetMapping
    public JobOffersFindWithCriteriaResponseDTO findWithCriteria(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                 @RequestParam(name = "size", defaultValue = "10") int size) {
        // TODO : test trace, remove this call
        restClientBuilder.build().get().uri(URI.create("http://contact-book-service/contact-book")).retrieve().body(String.class);
        JobOffers jobOffers = jobOfferUseCase.findWithCriteria(new CriteriaForFinder(size, page));
        return jobOffersRestMapper.fromDomain(jobOffers);
    }

    @PostMapping
    public JobOfferDTO create(@RequestBody JobOfferDTO jobOfferDTO) {
        // TODO : test trace, remove this call
        restClientBuilder.build().get().uri(URI.create("http://contact-book-service/contact-book")).retrieve().body(String.class);
        JobOffer jobOfferFromDTO = jobOffersRestMapper.toDomain(jobOfferDTO);
        JobOffer jobOfferCreated = jobOfferUseCase.create(jobOfferFromDTO);
        return jobOffersRestMapper.fromDomain(jobOfferCreated);
    }
}