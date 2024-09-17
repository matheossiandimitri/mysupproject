package com.dim.contact_book_service.adapters.in.rest.controllers;

import com.dim.contact_book_service.adapters.in.rest.dto.ContactBookFindWithCriteriaResponseDTO;
import com.dim.contact_book_service.adapters.in.rest.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller is an adapter
 * Input adapters or driving adapters call the input ports to perform specific tasks
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("contact-book")
public class ContactBookController {

    @GetMapping
    public ContactBookFindWithCriteriaResponseDTO findWithCriteria(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                   @RequestParam(name = "size", defaultValue = "10") int size) {

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFirstname("John");
        contactDTO.setLastname("Doe");

        // Just a simple return, no database
        return ContactBookFindWithCriteriaResponseDTO.builder().contacts(List.of(contactDTO)).total(1).build();
    }
}