package com.pragma.store.databuilder.chapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UsersChapterTestDataBuilder {

    public static final String NAME = "nombre de prueba";
    public static final String LAST_NAME = "apellido de prueba";
    public static final String LEVEL = "seniority de prueba";
    public static final String PROJECT = "proyecto de prueba";
    public static final LocalDate NEXT_VALIDATION_DATE = LocalDate.now();

    private String name;
    private String lastName;
    private String level;
    private String project;
    private LocalDate nextValidationDate;

    public UsersChapterTestDataBuilder(){
        this.name = NAME;
        this.lastName = LAST_NAME;
        this.level = LEVEL;
        this.project = PROJECT;
        this.nextValidationDate = NEXT_VALIDATION_DATE;
    }

    public UsersChapter buildUsersChapter(){
        return new UsersChapter(this.name, this.lastName, this.level, this.nextValidationDate);
    }

}
