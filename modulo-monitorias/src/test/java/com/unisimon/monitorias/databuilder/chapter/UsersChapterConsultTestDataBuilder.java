package com.unisimon.monitorias.databuilder.chapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UsersChapterConsultTestDataBuilder {

    public static final String PROFILE_PICTURE = "foto de prueba";
    public static final String NAME = "nombre de prueba";
    public static final String LAST_NAME = "apellido de prueba";
    public static final String EMAIL = "correo.prueba@pragma.com.co";
    public static final String ROLE = "rol de prueba";
    public static final String LEVEL = "nivel de prueba";
    public static final String PROJECT = "proyecto de prueba";
    public static final LocalDate NEXT_VALIDATION_DATE = LocalDate.now();
    public static final Boolean IS_TODAY = true;
    public static final Boolean IS_TOMORROW = false;
    public static final Boolean IS_EXPIRED = false;

    private String profilePicture;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private String level;
    private String project;
    private LocalDate nextValidationDate;
    private Boolean isToday;
    private Boolean isTomorrow;
    private Boolean isExpired;

    public UsersChapterConsultTestDataBuilder(){
        this.profilePicture = PROFILE_PICTURE;
        this.name = NAME;
        this.lastName = LAST_NAME;
        this.email = EMAIL;
        this.role = ROLE;
        this.level = LEVEL;
        this.project = PROJECT;
        this.nextValidationDate = NEXT_VALIDATION_DATE;
        this.isToday = IS_TODAY;
        this.isTomorrow = IS_TOMORROW;
        this.isExpired = IS_EXPIRED;
    }

    /*public UsersChapterConsult buildUserChapterConsult(){
        return new UsersChapterConsult(this.profilePicture, this.name, this.lastName, this.email, this.role, this.level,
                this.project, this.nextValidationDate, this.isToday, this.isTomorrow, this.isExpired);
    }*/
}
