package com.pragma.store.chapter.domain;

import com.pragma.store.databuilder.chapter.UsersChapterTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsersChapterTest {

    public static final String NAME = "nombre de prueba";
    public static final String LAST_NAME = "apellido de prueba";
    public static final String LEVEL = "seniority de prueba";
    public static final String PROJECT = "proyecto de prueba";
    public static final LocalDate NEXT_VALIDATION_DATE = LocalDate.now();

    @Test
    void testCreateUsersChapterModel(){
        /*UsersChapter usersChapter = new UsersChapterTestDataBuilder().buildUsersChapter();
        Assertions.assertEquals(NAME, usersChapter.getName());
        Assertions.assertEquals(LAST_NAME, usersChapter.getLastName());
        Assertions.assertEquals(LEVEL, usersChapter.getLevel());
        Assertions.assertEquals(PROJECT, usersChapter.getProject());
        Assertions.assertEquals(NEXT_VALIDATION_DATE, usersChapter.getNextValidationDate());
    */}
}
