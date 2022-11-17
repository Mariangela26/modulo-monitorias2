package com.pragma.store.chapter.application.dto;

import com.pragma.store.chapter.domain.model.DocumentType;
import com.pragma.store.chapter.domain.model.PersonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispatcherResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String enterpriseEmail;
    private String country;
    private String city;
    private String address;
    private DocumentType documentType;
    private String documentNumber;
    private PersonType personType;
    private String securityId;
}
