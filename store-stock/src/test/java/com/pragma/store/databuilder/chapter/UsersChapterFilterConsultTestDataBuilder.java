package com.pragma.store.databuilder.chapter;

import com.pragma.store.common.response.ObjectResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class UsersChapterFilterConsultTestDataBuilder {

    public static final long NUMBER_PAGES = 5;
    public static final boolean LAST_PAGE = false;
    public static final Long ACTUAL_PAGE = 1L;
    /*public static final ObjectResponse<List<UsersChapterConsult>> DATA = new ObjectResponse<>(
            new ArrayList<UsersChapterConsult>());

    private long numberPages;
    private boolean lastPage;
    private Long actualPage;
    private ObjectResponse<List<UsersChapterConsult>> data;

    public UsersChapterFilterConsultTestDataBuilder(){
        this.numberPages = NUMBER_PAGES;
        this.lastPage = LAST_PAGE;
        this.actualPage = ACTUAL_PAGE;
        this.data = DATA;
    }

    public UsersChapterFilterConsult buildUsersChapterFilterConsult(){
        return new UsersChapterFilterConsult(this.numberPages, this.lastPage, this.actualPage, this.data);
    }*/
}
