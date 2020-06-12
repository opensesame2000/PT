package com.powertamil.transform.tokenizer;

import java.util.regex.Pattern;

public class PunctuationPreProcessor implements TokenPreProcess {

    private static final Pattern puncts = Pattern.compile("[\\d\\.:,\"\'\\(\\)\\[\\]|/?!;]+");

    @Override
    public String preProcess(String token) {

        return stripPunct(token);
    }

    /**
     * Make sure the punct character {dot} should be removed or not.
     * Removes ASCII punctuation marks, which are: 0123456789.:,"'()[]|/?!;
     *
     * @param base the base string
     * @return the cleaned string
     */
    private static String stripPunct(String base) {
        //System.out.println("base is:: " + base);
        return puncts.matcher(base).replaceAll("");
    }
}