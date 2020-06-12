package com.powertamil.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilsTest {

    long timenow = TimeUtils.now();

    @BeforeEach
    void setUp() {
    }

    @Test
    void now() {
        System.out.println(timenow);
    }

    @Test
    void formatTime() {
        System.out.println(TimeUtils.formatTime(timenow, true));
    }

    @Test
    void formatTimeNoMillisecond() {
        System.out.println(TimeUtils.formatTimeNoMillisecond(timenow));
    }

    @Test
    void intForString() {
        System.out.println(TimeUtils.intForString("2019-03-26"));
    }

    @Test
    void dayForWeek() {
    }

    @Test
    void getDate2() {
    }

    @Test
    void getDateTamil() {
    }

    @Test
    void getDate() {
    }

    @Test
    void getMinDate() {
    }

    @Test
    void timeStamp2Date() {
    }

    @Test
    void getMonthDate() {
    }

    @Test
    void getWeek() {
    }

    @Test
    void getMonthFirstDay() {
    }

    @Test
    void getLongDate() {
    }

    @Test
    void getLongTrueDate() {
    }

    @Test
    void getCurrentDay() {
    }

    @Test
    void getCurrentHour() {
    }

    @Test
    void getCurrentMin() {
    }

    @Test
    void getCurrentMonth() {
    }

    @Test
    void getCurrentYear() {
    }

    @Test
    void getDays() {
    }
}