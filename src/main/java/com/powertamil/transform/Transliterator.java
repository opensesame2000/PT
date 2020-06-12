/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since   26-05-2018
 */
package com.powertamil.transform;


import com.powertamil.collections.ArrayMap;
import com.powertamil.lang.latin.LChars;
import com.powertamil.lang.tamil.TCharacter;
import com.powertamil.lang.tamil.TSUtils;
import com.powertamil.lang.tamil.TString;

import com.powertamil.transform.tokenizer.*;

public class Transliterator {

    private static final String DEFAULT_TRANSLITERATION_CODE = "Any-Latin";
    // TO BE DONE.
    private static final String ISO_15919_TRANSLITERATION_CODE = "ISO_15919";

    /**
     * TODO Handle Special chars of Latin
     */
    public static String transliterate(String input) {
        StringBuffer appendBuf = new StringBuffer();
        input = stripNewlines(input);

        if (input.length() >= 0) {
            Tokenizer tokenizer = new TamilTokenizerFactory().createTokenizer(input);
            while(tokenizer.hasMoreTokens()) {
                TString ts1 = TSUtils.parse(tokenizer.nextToken());
                for(int i=0; i<ts1.length(); i++) {
                    TCharacter tc = ts1.tcharAt(i);
                    //System.out.print(tc.toString());
                    ArrayMap<String, String> trMap = Tamil2Latin.getTamil2LatinMap();
                    appendBuf.append(trMap.get(tc.toString()));
                }
                appendBuf.append(LChars.SPACE);
            }
        } else {
            //throw exception.
        }
        return appendBuf.toString();
    }



    public static String stripNewlines(String text) {
        text = text.trim();
        text = text.replace(LChars.NEWLINE_R, LChars.EMPTY_STRING);
        return text.replace(LChars.NEWLINE_N, LChars.EMPTY_STRING);
    }
}
