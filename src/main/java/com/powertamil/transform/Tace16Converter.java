/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since 26-05-2018
 */
package com.powertamil.transform;

import com.powertamil.lang.tamil.TACE16;
import com.powertamil.lang.tamil.TCharacter;
import com.powertamil.lang.tamil.TSUtils;
import com.powertamil.lang.tamil.TString;
import com.powertamil.lang.tamil.UTF8;

public class Tace16Converter {

    public static String toTace16(String utf8tamilstr) {
        TString ts = TSUtils.parse(utf8tamilstr);
        StringBuffer sb = new StringBuffer();
        try {
            for (int i = 0; i < ts.length(); i++) {
                TCharacter tc = ts.tcharAt(i);
                if (tc.SAME_AS_ASCII) {
                    sb.append(tc);
                } else {
                    sb.append(TACE16.AllTACE[tc.LEX_ORDER]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String toUnicodeTamil(String tacestr) {
        StringBuffer sb = new StringBuffer();
        char[] carray = tacestr.toCharArray();
        try {
            for (int i = 0; i < carray.length; i++) {
                if (carray[i] < 0xFF) {
                    sb.append(carray[i]);
                } else if (carray[i] > 0xE100 && carray[i] < 0xE3FF) {
                    int TACE_LEX_NUM = (TACE16.AllTACEList.indexOf(carray[i]));
                    sb.append(UTF8.AllUTF[TACE_LEX_NUM]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    // getCodePoint(i) on a string input

    // Convert CodePoint to HexBinary String

    // Lookup the index of HexBinary String in UTF8.java

    // Lookup the same index in TACE16.java and get the HexBinary String

    // Write the String to ByteBuffer or StringBuffer

    // Convert to String and return.

    // add util methods

    // may be implement Hex.java for CodePoint HexBinary

    // Lastly Test Harness and profiling classes.

}
