package com.dim.job_offers_service.adapters.out.database.repositories;

import com.dim.job_offers_service.adapters.out.database.entities.JobOfferData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobOfferRepository extends PagingAndSortingRepository<JobOfferData, Long>, CrudRepository<JobOfferData, Long> {
    @Query("select count(j) from JobOfferData j")
    long count();
}
