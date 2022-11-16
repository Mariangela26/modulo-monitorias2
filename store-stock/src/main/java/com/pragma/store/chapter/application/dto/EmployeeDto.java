package com.pragma.store.chapter.application.dto;

import com.pragma.store.chapter.domain.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private String enterpriseEmail;
    private String country;
    private String city;
    //private Person person;
}
