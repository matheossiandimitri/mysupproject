package com.dim.job_offers_service.adapters.in.rest.mappers;

import com.dim.job_offers_service.adapters.in.rest.dto.JobOfferDTO;
import com.dim.job_offers_service.adapters.in.rest.dto.JobOffersFindWithCriteriaResponseDTO;
import com.dim.job_offers_service.domain.model.JobOffer;
import com.dim.job_offers_service.domain.model.JobOffers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobOffersRestMapper {
    JobOffersFindWithCriteriaResponseDTO fromDomain(JobOffers jobOffers);

    List<JobOfferDTO> fromDomain(List<JobOffer> jobOffers);

    JobOffer toDomain(JobOfferDTO jobOfferDTO);

    JobOfferDTO fromDomain(JobOffer jobOffer);
}
