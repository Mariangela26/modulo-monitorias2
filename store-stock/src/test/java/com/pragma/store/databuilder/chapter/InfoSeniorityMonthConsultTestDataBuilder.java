package com.pragma.store.databuilder.chapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InfoSeniorityMonthConsultTestDataBuilder {

    public static final int MONTH = 1;
    public static final Levels CHAPTER_TRAINEE = new Levels();
    public static final Levels CHAPTER_JUNIOR = new Levels();
    public static final Levels CHAPTER_SENIOR = new Levels();
    public static final Levels CHAPTER_ADVANCED = new Levels();
    public static final Levels CHAPTER_MASTER = new Levels();

    private int month;
    private Levels chapterTrainee;
    private Levels chapterJunior;
    private Levels chapterSenior;
    private Levels chapterAdvanced;
    private Levels chapterMaster;

    public InfoSeniorityMonthConsultTestDataBuilder(){
        this.month = MONTH;
        this.chapterTrainee = CHAPTER_TRAINEE;
        this.chapterJunior = CHAPTER_JUNIOR;
        this.chapterAdvanced = CHAPTER_ADVANCED;
        this.chapterSenior =  CHAPTER_SENIOR;
        this.chapterMaster = CHAPTER_MASTER;
    }

    public InfoSeniorityMonthConsult buildInfoSeniorityMonthConsult(){
        return new InfoSeniorityMonthConsult(this.month, this.chapterTrainee, this.chapterJunior, this.chapterSenior,
                this.chapterAdvanced, this.chapterMaster);
    }
}
