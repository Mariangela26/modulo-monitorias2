package com.pragma.store.databuilder.chapter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InfoSeniorityTestDataBuilder {

    public static final Long CHAPTERID = 1L;
    public static final String CHAPTER_NAME = "prueba";
    public static final int CHAPTER_TOTAL = 10;
    public static final Levels CHAPTER_TRAINEE = new Levels();
    public static final Levels CHAPTER_JUNIOR = new Levels();
    public static final Levels CHAPTER_SENIOR = new Levels();
    public static final Levels CHAPTER_ADVANCED = new Levels();
    public static final Levels CHAPTER_MASTER = new Levels();

    private Long id;
    private String chapterName;
    private int chapterTotal;
    private Levels chapterTrainee;
    private Levels chapterJunior;
    private Levels chapterSenior;
    private Levels chapterAdvanced;
    private Levels chapterMaster;

    public InfoSeniorityTestDataBuilder(){
        this.id = CHAPTERID;
        this.chapterName = CHAPTER_NAME;
        this.chapterTotal = CHAPTER_TOTAL;
        this.chapterTrainee = CHAPTER_TRAINEE;
        this.chapterJunior = CHAPTER_JUNIOR;
        this.chapterSenior = CHAPTER_SENIOR;
        this.chapterAdvanced = CHAPTER_ADVANCED;
        this.chapterMaster = CHAPTER_MASTER;
    }

    public InfoSenioritys buildInfoSenioritys(){
        return new InfoSenioritys(this.id, this.chapterName, this.chapterTotal, this.chapterTrainee, this.chapterJunior,
                this.chapterSenior, this.chapterAdvanced, this.chapterMaster);
    }
}
