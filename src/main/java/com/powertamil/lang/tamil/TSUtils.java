/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   29-05-2018
 */
package com.powertamil.lang.tamil;

import java.util.ArrayList;
import java.util.List;

public class TSUtils {

    /**
     * Parse the input String in a TSring containing TCharacter objects. Invalid
     * Code Points are skipped and logged in the process of parsing. Code Points in
     * the Unicode Tamil and Code Points less than 0xFF are allowed to pass through
     * the screening.
     *
     * @param inputstr Input String to be parsed in to TString.
     * @return TString.
     */
    public static TString parse(String inputstr) {

        char[] dst = new char[inputstr.length()];
        inputstr.getChars(0, inputstr.length(), dst, 0);

        List<TCharacter> resList = new ArrayList<TCharacter>();
        long strlen = dst.length;

        // iterate on code points one by one
        for (int i = 0; i < strlen; i++) {
            int cp1 = 0, cp2 = 0, cp3 = 0, cp4 = 0; // ASCII Null character

            // System.out.println(cp1 +" " + cp2 + " " + cp3 + " " + cp4);
            // load code points.
            if ((strlen - i) > 3) {// can load four CPs
                // System.out.println("inside 4CPs");
                cp1 = dst[i];
                cp2 = dst[i + 1];
                cp3 = dst[i + 2];
                cp4 = dst[i + 3];
                // System.out.println(cp1 +" " + cp2 + " " + cp3 + " " + cp4);
                TCharacter tc = TCUtils.getTCharacter(cp1, cp2, cp3, cp4);
                if (tc != null) {
                    resList.add(tc);
                    i = i + 3;
                } else if ((tc = TCUtils.getTCharacter(cp1, cp2, cp3)) != null) {
                    resList.add(tc);
                    i = i + 2;
                } else if ((tc = TCUtils.getTCharacter(cp1, cp2)) != null) {
                    // System.out.println("inside UyirMei branch :: " + tc.toString());
                    resList.add(tc);
                    i = i + 1;
                } else if ((tc = TCUtils.getTCharacter(cp1)) != null) {
                    resList.add(tc);
                }
            } else if ((strlen - i) > 2) {// can load 3 CPs
                // System.out.println("inside 3CPs");
                cp1 = dst[i];
                cp2 = dst[i + 1];
                cp3 = dst[i + 2];
                TCharacter tc = TCUtils.getTCharacter(cp1, cp2, cp3);
                if ((tc = TCUtils.getTCharacter(cp1, cp2, cp3)) != null) {
                    resList.add(tc);
                    i = i + 2;
                } else if ((tc = TCUtils.getTCharacter(cp1, cp2)) != null) {
                    resList.add(tc);
                    i = i + 1;
                } else if ((tc = TCUtils.getTCharacter(cp1)) != null) {
                    resList.add(tc);
                }

            } else if ((strlen - i) > 1) { // can load remaining 2 or 1 CPs
                // System.out.println("inside 2CPs");
                cp1 = dst[i];
                cp2 = dst[i + 1];
                TCharacter tc = TCUtils.getTCharacter(cp1, cp2);
                if ((tc = TCUtils.getTCharacter(cp1, cp2)) != null) {
                    resList.add(tc);
                    i = i + 1;
                } else if ((tc = TCUtils.getTCharacter(cp1)) != null) {
                    resList.add(tc);
                }
            } else if ((strlen - i) == 1) {
                // System.out.println("inside 1CPs");
                cp1 = dst[i];
                TCharacter tc = TCUtils.getTCharacter(cp1);
                if ((tc = TCUtils.getTCharacter(cp1)) != null) {
                    resList.add(tc);
                }
            }

        }
        return new TString(resList);
    }


    /**
     * parse and reverse the input String
     *
     * @param inputstr input String.
     * @return Parsed and Reversed inputstr pushed in to TString.
     */
    public static TString reverse(String inputstr) {
        TString parsed = TSUtils.parse(inputstr);
        TString reversed = null;
        ArrayList<TCharacter> tmList = new ArrayList<TCharacter>();
        for (int i = (parsed.length() - 1); i >= 0; i--) {
            TCharacter tc = parsed.tcharAt(i);
            tmList.add(tc);
        }
        reversed = new TString(tmList);
        return reversed;
    }


}
