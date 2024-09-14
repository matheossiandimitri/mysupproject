package com.dim.job_offers_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CriteriaForFinder {
    int pageSize;
    int pageNumber;
}
