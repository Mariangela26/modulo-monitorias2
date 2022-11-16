package com.pragma.store.chapter.application.dto;

import com.pragma.store.chapter.domain.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderDto {
    private String city;
    private String country;
    private String addressMain;
    //private Person person;
}
