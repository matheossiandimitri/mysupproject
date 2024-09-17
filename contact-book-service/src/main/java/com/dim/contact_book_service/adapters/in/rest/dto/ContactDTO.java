package com.dim.contact_book_service.adapters.in.rest.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactDTO {
    private String firstname;
    private String lastname;
    private String company;
    private String phone;
    private String mail;
    private LocalDateTime lastContactDate;
}
