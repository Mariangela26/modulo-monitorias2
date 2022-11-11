package com.pragma.store.chapter.domain;

import com.pragma.store.databuilder.chapter.InfoSeniorityMonthTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InfoSeniorityMonthTest {

    public static final int MONTH = 1;

    @Test
    void TestCreateInfoSeniorityMonthModel(){
        InfoSeniorityMonth infoSeniorityMonth = new InfoSeniorityMonthTestDataBuilder().buildInfoSeniorityMonth();
        Assertions.assertEquals(MONTH, infoSeniorityMonth.getMonth());
    }
}
