package com.dim.job_offers_service.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CriteriaForFinderDTO {
    int pageSize;
    int pageNumber;
}
