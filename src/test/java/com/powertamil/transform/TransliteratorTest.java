package com.powertamil.transform;

import java.util.List;

import com.powertamil.transform.tokenizer.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransliteratorTest {

    static String tStr1 = "காணி! நிலம் வேண்டுமா?";
    static String tStr2 = "இது ருத்ராக்ஷம் மணி மாலை...!";
    static String tStr3 = "இன்றுா ஸ்ரீராம நவமி!";
    static String tStr4 = "சிற்றூர்";

    //kaaNin-ilamveeNdumaa
    TokenizerFactory tf = new TamilTokenizerFactory();

    @BeforeEach
    void setUp() {
        tf = new TamilTokenizerFactory();
    }

    @Test
    void transliterate() {
        Tokenizer t = tf.createTokenizer(tStr2);
        List<String> tokens = t.getTokens();

        System.out.println("NUM TOKENS:: " + tokens.size());


        //System.out.println("\n\n" + Transliterator.transliterate(tStr1));
        System.out.println(Transliterator.transliterate(tStr3));
        //System.out.println(Transliterator.transliterate(tStr3));
        //System.out.println(Transliterator.transliterate(tStr4));

    }
}