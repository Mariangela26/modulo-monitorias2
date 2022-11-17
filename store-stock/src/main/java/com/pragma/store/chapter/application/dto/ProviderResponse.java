package com.pragma.store.chapter.application.dto;

import com.pragma.store.chapter.domain.model.DocumentType;
import com.pragma.store.chapter.domain.model.PersonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String telephone;
    private String address;
    private String country;
    private String city;
    private String addressMain;
    private DocumentType documentType;
    private String documentNumber;
    private PersonType personType;
    private String securityId;
}
