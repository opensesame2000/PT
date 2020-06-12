package com.powertamil.lang;

import com.powertamil.lang.tamil.TCharacter;
import com.powertamil.lang.tamil.TSUtils;
import com.powertamil.lang.tamil.TString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TSUtilsTest {

    static String tStr1 = "காணி நிலம் வேண்டுமா";
    static String tStr2 = "இது ருத்ராக்ஷம் மணி மாலை";
    static String tStr3 = "இன்றுா ஸ்ரீராம நவமி!";
    static String tStr4 = "890 ";
    static String tStr5 = "சகல சௌபாக்கியம் வேண்டுமா?";
    static String tStr6 = "இது Applé வேண்டுமா?";
    static String tStr7 = "இது ฮ வேண்டுமா?";
    static String tStr8 = "சாக்ஷி நட்பின் மயிலியற்";
    static String tStr9 = "பௌர்ணமி";


    @BeforeEach
    void setUp() {

    }

    @Test
    void parse() {
        System.out.println("Input:: ");
        TString ts1 = TSUtils.parse(tStr9);
        for (int i = 0; i < ts1.length(); i++) {
            TCharacter tc = ts1.tcharAt(i);
            System.out.print(tc.toString());
        }
        assertEquals("பௌர்ணமி", ts1.toString());
    }

    @Test
    void reverse() {
        TString ts1 = TSUtils.reverse(tStr9);
        System.out.println("\nreversed:: ");

        for (int i = 0; i < ts1.length(); i++) {
            TCharacter tc = ts1.tcharAt(i);
            System.out.print(tc.toString());
        }
    }
}