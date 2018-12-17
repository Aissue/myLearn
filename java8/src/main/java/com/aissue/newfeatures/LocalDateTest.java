package com.aissue.newfeatures;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTest {
    @Test
    public void test1(){
        LocalDate date = LocalDate.now();
        LocalDate old = LocalDate.of(2018,12,1);
        LocalDateTime time = LocalDateTime.now();
    }
}
