package com.dim.job_offers_service.adapters.out.database.mappers;

import com.dim.job_offers_service.adapters.out.database.entities.JobOfferData;
import com.dim.job_offers_service.domain.model.JobOffer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobOffersDataMapper {
    List<JobOffer> toDomain(List<JobOfferData> jobOffersData);

    JobOffer toDomain(JobOfferData jobOfferData);

    JobOfferData fromDomain(JobOffer jobOffer);
}
