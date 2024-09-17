package com.dim.contact_book_service.adapters.in.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ContactBookFindWithCriteriaResponseDTO {
    private List<ContactDTO> contacts;
    private int total;
}
