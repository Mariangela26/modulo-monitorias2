package com.pragma.store.databuilder.chapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsersChapterFilterCommandTestDataBuilder {

    public final static Integer PAGE_NUMBER = 1;
    public final static Integer TOTAL_ELEMENTS = 5;
    public final static Boolean ASSESSMENT_DATE_ASC = true;
    public final static  Long CHAPTER_ID = 1L;


    private Integer pageNumber;
    private Integer totalElements;
    private Boolean assessmentDateAsc;
    private Long chapterId;

    public UsersChapterFilterCommandTestDataBuilder(){
        this.pageNumber = PAGE_NUMBER;
        this.totalElements = TOTAL_ELEMENTS;
        this.assessmentDateAsc = ASSESSMENT_DATE_ASC;
        this.chapterId = CHAPTER_ID;
    }

    /*public UsersChapterFilterCommand buildUsersChapterFilterCommand(){
        return new UsersChapterFilterCommand(this.pageNumber, this.totalElements,
                this.assessmentDateAsc, this.chapterId);
    }*/
}
