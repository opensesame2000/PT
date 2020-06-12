/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   30-05-2018
 */
package com.powertamil.lang.tamil;

import java.util.regex.Pattern;
import java.util.logging.Logger;

public class TCUtils implements TamilLetter {

    protected static final Logger LOG = Logger.getLogger(TCUtils.class.getName());

    // Tamil Char Patterns to be matched against.
    private static final String AllVowelMarkers = "\u0BCD|\u0BBE|\u0BBF|\u0BC0|\u0BC1|\u0BC2|\u0BC6|\u0BC7|\u0BC8|"
            + "\u0BCA|\u0BCB|\u0BCC";
    private static final String UMVowelMarkers = "\u0BBE|\u0BBF|\u0BC0|\u0BC1|\u0BC2|\u0BC6|\u0BC7|\u0BC8|"
            + "\u0BCA|\u0BCB|\u0BCC";
    private static final Pattern SriChar = Pattern.compile("[\u0BB8][\u0BCD][\u0BB0][\u0BC0]");
    private static final Pattern KshaUyirMeiChar = Pattern.compile("[\u0B95][\u0BCD][\u0BB7][" + UMVowelMarkers + "]");
    private static final Pattern KshaChar = Pattern.compile("[\u0B95][\u0BCD][\u0BB7]");
    private static final Pattern GranthaAgaramChar = Pattern.compile("[\u0B9C|\u0BB7|\u0BB8|\u0BB9|\u0BB6]");
    private static final Pattern GranthaMeiChar = Pattern.compile("[\u0B9C|\u0BB7|\u0BB8|\u0BB9|\u0BB6][\u0BCD]");
    private static final Pattern GranthaUyirMeiChar = Pattern
            .compile("[\u0B9C|\u0BB7|\u0BB8|\u0BB9|\u0BB6][" + AllVowelMarkers + "]");
    private static final String Agaram = "\u0B95|\u0B9A|\u0B9F|\u0BA4|\u0BAA|\u0BB1|\u0B9E|\u0B99|\u0BA3|"
            + "\u0BA8|\u0BAE|\u0BA9|\u0BAF|\u0BB0|\u0BB2|\u0BB5|\u0BB4|\u0BB3";
    private static final String VowelMarkers = "\u0BBE|\u0BBF|\u0BC0|\u0BC1|\u0BC2|\u0BC6|\u0BC7|\u0BC8|"
            + "\u0BCA|\u0BCB|\u0BCC";
    private static final Pattern UyirMei2Char = Pattern.compile("[" + Agaram + "][" + VowelMarkers + "]");
    private static final Pattern MeiChar = Pattern.compile("[" + Agaram + "][" + "\u0BCD" + "]");
    private static final Pattern AgaramChar = Pattern.compile("[" + Agaram + "]");
    private static final Pattern UyirChar = Pattern
            .compile("[\u0B85|\u0B86|\u0B87|\u0B88|\u0B89|\u0B8A|\u0B8E|\u0B8F|\u0B90|\u0B92|\u0B93|\u0B94]");
    private static final Pattern AythamChar = Pattern.compile("\u0B83");
    private static final String Numerals = "\u0BE6|\u0BE7|\u0BE8|\u0BE9|\u0BEA|\u0BEB|\u0BEC|\u0BED|\u0BEE|\u0BEF|\u0BF0|\u0BF1|\u0BF2";
    private static final Pattern NumeralChar = Pattern.compile("[" + Numerals + "]");

    /**
     * Identify a Tamil Character with 4 Code Points
     *
     * @param c1 Code Point
     * @param c2 Code Point
     * @param c3 Code Point
     * @param c4 Code Point
     * @return TCharacter
     */
    public static TCharacter getTCharacter(int c1, int c2, int c3, int c4) {
        char[] carr = {(char) c1, (char) c2, (char) c3, (char) c4};
        TCharacter tc1 = null;
        if (isKshaUyirMei(c1, c2, c3, c4)) {
            tc1 = new TCharacter(carr);
            return tc1;
        } else if (isSriChar(c1, c2, c3, c4)) {
            tc1 = new TCharacter(carr);
            return tc1;
        }
        return tc1;
    }

    /**
     * Identify a Tamil Character with 3 Code Points
     *
     * @param c1 Code Point
     * @param c2 Code Point
     * @param c3 Code Point
     * @return TCharacter
     */
    public static TCharacter getTCharacter(int c1, int c2, int c3) {
        char[] carr = {(char) c1, (char) c2, (char) c3};
        TCharacter tc1 = null;
        if (isKshaChar(c1, c2, c3)) {
            tc1 = new TCharacter(carr);
            return tc1;
        }
        return null;
    }

    /**
     * Identify a Tamil Character with 2 Code Points
     *
     * @param c1 Code Point
     * @param c2 Code Point
     * @return TCharacter
     */
    public static TCharacter getTCharacter(int c1, int c2) {// Add Grantha UyirMei
        char[] carr = {(char) c1, (char) c2};
        TCharacter tc1 = null;
        if (isUyirMei(c1, c2) | isGranthaUyirMei(c1, c2)) {
            tc1 = new TCharacter(carr);
            return tc1;
        }
        return null;
    }

    /**
     * Identify a Tamil Character with 1 Code Point or Basic Latin and
     * Latin1Supplement character
     *
     * @param c1 Code Point
     * @return TCharacter
     */
    public static TCharacter getTCharacter(int c1) { // Add Grantha Agaram
        char[] carr = {(char) c1};
        TCharacter tc1 = null;
        if (isUyir(c1) | isAgaram(c1) | isGranthaAgaram(c1) | isTNumber(c1) | isTSymbol(c1) | (c1 < 0xFF)) {
            tc1 = new TCharacter(carr);
            return tc1;
        } else {
            System.out.println("Char ::" + (char) c1 + " Could not be identified as a Canonical Tamil Char....!");
        }
        return null;
    }

    /**
     * Checks for the presence of Uyir Letter (Tamil Vowel).
     *
     * @param ch Code Point.
     * @return true if Uyir is found.
     */
    public static boolean isUyir(int ch) {//All Inclusive :: 2949 - 2954, 2958 - 2960, 2962 - 2964, 2947
        return (ch > 2948 && ch < 2955) | (ch > 2957 && ch < 2961) | (ch > 2961 && ch < 2965) | (ch == 2947);
    }

    /**
     * Checks for the presence of UyirMei Letter (Tamil Vowel-Consonant).
     *
     * @param ch  Code Point.
     * @param ch1 Code Point.
     * @return true if UyirMei is found.
     */
    public static boolean isUyirMei(int ch, int ch1) {
        return (isAgaram(ch)) && isVowelMarker(ch1);
    }

    /**
     * Checks for presence of Agaram Letters (Tamil Agaram).
     * Chars and their Code Points are:
     * க-2965; ங-2969; ச-2970; ஞ-2974; ட-2975; ண-2979; த-2980; ந-2984; ப-2986;
     * ம-2990; ய-2991; ர-2992; ல-2994; வ-2997; ழ-2996; ள-2995; ற-2993; ன-2985;
     *
     * @param ch Code Point.
     * @return true if Agaram letter is found.
     */
    public static boolean isAgaram(int ch) {
        return ch == 2965 | ch == 2969 | ch == 2970 | ch == 2974 | ch == 2975 | ch == 2979 | ch == 2980 | ch == 2984
                | ch == 2986 | ch == 2990 | ch == 2991 | ch == 2992 | ch == 2994 | ch == 2997 | ch == 2996 | ch == 2995
                | ch == 2993 | ch == 2985;
    }

    /**
     * Checks if the given Code Point is a Tamil Vowel Marker.
     * Chars and their Code Points are:
     * ்-3021; ா-3006; ி-3007; ீ- 3008; ு- 3009; ூ-3010;
     * ெ- 3014; ே- 3015; ை-3016;ொ- 3018; ோ -3019; ௌ-3020;
     *
     * @param ch Code Point.
     * @return true if Vowel Marker is identified.
     */
    public static boolean isVowelMarker(int ch) {
        return (ch > 3005 && ch < 3011) | (ch > 3013 && ch < 3017) | (ch > 3017 && ch < 3022);
    }

    /**
     * Checks if the given Code Point is an Aytham.
     * Chars and their Code Points are:
     * ஃ-2947;
     *
     * @param ch Code Point.
     * @return true if Aytham is identified.
     */
    public static boolean isAytham(int ch) {
        return (ch == 2947);
    }


    /**
     * Checks for a Tamil Number.
     * Code Points are : 3047 - 3054.
     *
     * @param ch Code Point.
     * @return true if Tamil Number is found.
     */
    public static boolean isTNumber(int ch) {
        return ch > 3046 && ch < 3055;
    }

    /**
     * Checks for Tamil Symbol.
     * from ௰-3056; to ௺-3066;
     * Numerals for 10,100, 1000 are also clubbed with Symbols.
     *
     * @param ch Code Point.
     * @return true if Tamil Sysmbol is found.
     */
    public static boolean isTSymbol(int ch) {
        return ch > 3055 && ch < 3067;
    }

    /**
     * Checks for the presence of Grantha Agaram.
     * Chars and their Code Points are:
     * ஜ-2972; ஶ-2998; ஷ-2999;ஸ-3000; ஹ-3001;
     *
     * @param ch Code Point.
     * @return true if Grantha Agaram is present
     */
    public static boolean isGranthaAgaram(int ch) {
        return (ch == 2972) | (ch == 2998) | (ch == 2999) | (ch == 3000) | (ch == 3001);
    }

    /**
     * Checks for the presence of Grantha Uyir Mei (excluding kshaUyirMei since it is of 4 CPs).
     * Grantha Chars and their Code Points are:
     * ஜ-2972; ஶ-2998; ஷ-2999;ஸ-3000; ஹ-3001;
     * <p>
     * Vowel Markers are:
     * ்-3021; ா-3006; ி-3007; ீ- 3008; ு- 3009; ூ-3010;
     * ெ- 3014; ே- 3015; ை-3016;ொ- 3018; ோ -3019; ௌ-3020;
     *
     * @param cp1 Code Point.
     * @param cp2 Code Point.
     * @return true if Grantha Uyir Mei is present
     */
    public static boolean isGranthaUyirMei(int cp1, int cp2) {
        return isGranthaAgaram(cp1) && isVowelMarker(cp2);
    }


    /**
     * Checks for KshaUyirMei Tamil letters.
     *
     * @param cp1 Code Point.
     * @param cp2 Code Point.
     * @param cp3 Code Point.
     * @param cp4 Code Point.
     * @return true if KshaUyirMei is found.
     */
    public static boolean isKshaUyirMei(int cp1, int cp2, int cp3, int cp4) { // 2965 3021 2999 3021
        if ((cp1 == 2965) && (cp2 == 3021) && (cp3 == 2999)) {
            return isVowelMarker(cp4);
        }
        return false;
    }

    /**
     * Checks for presence of Sri Character.
     *
     * @param cp1 Code Point.
     * @param cp2 Code Point.
     * @param cp3 Code Point.
     * @param cp4 Code Point.
     * @return true if Sri character is found.
     */
    public static boolean isSriChar(int cp1, int cp2, int cp3, int cp4) {// 3000 3021 2992 3008
        return (cp1 == 3000) && (cp2 == 3021) && (cp3 == 2992) && (cp4 == 3008);
    }

    /**
     * Checks for Ksha Agaram letter.
     *
     * @param cp1 Code Point.
     * @param cp2 Code Point.
     * @param cp3 Code Point.
     * @return true if Ksha agaram is found.
     */
    public static boolean isKshaChar(int cp1, int cp2, int cp3) {// 2965 3021 2999
        return (cp1 == 2965) && (cp2 == 3021) && (cp3 == 2999);
    }


    /**
     * getTamilCharCodePoints - Converts a Tamil character to its constituent Code
     * Points
     *
     * @param TamilChar String with one valid Tamil Character
     * @return A char array with Code Points of a Tamil Character. Note: One Tamil
     * Character can have 1-4 Code Points. Each Code point has many Code
     * Units.
     */
    public static char[] getCodePoints(TCharacter TamilChar) {

        String monoCharStr = TamilChar.toString();
        int charSpan = monoCharStr.length();
        char[] codepointsarray = new char[charSpan];
        monoCharStr.getChars(0, charSpan, codepointsarray, 0);

        return codepointsarray;
    }

    /**
     * Identifies character Type from an array of CodePoints of a TamilCharacter
     *
     * @param TamilChar A char array with CodePoint(s) of a Tamil character
     * @return A String with Type of the Tamil Character
     */
    public static String getTamilCharType(TCharacter TamilChar) {

        Boolean KshaUyirMeiMatch, SriMatch, KshaCharMatch = null;
        Boolean GranthaMeiMatch, GranthaUyirMeiMatch, GranthaAgaramMatch = null;
        Boolean UyirMeiMatch, MeiMatch, AgaramMatch, UyirMatch, AythamMatch = null;
        Boolean NumeralMatch = null;

        // char[] tChar = getTamilCharCodePoints(TamilChar);
        String CHAR_TYPE = TamilChar.toString() + "\nTYPE = ";

        int cpcount = TamilChar.length();
        String inputdata = null;
        StringBuffer sgbuf = new StringBuffer();

        for (int i = 0; i < cpcount; i++) {
            sgbuf.append(TamilChar.charAt(i));
        }
        inputdata = sgbuf.toString();

        // Following a whittle down approach.
        if (cpcount == 4) {
            KshaUyirMeiMatch = KshaUyirMeiChar.matcher(inputdata).matches();
            if (KshaUyirMeiMatch) {
                String VM_NAME = getVowelMarkerName(String.valueOf(TamilChar.charAt(3)));
                return CHAR_TYPE + "KSHA UYIR MEI with " + VM_NAME + " Marker";
            }
            SriMatch = SriChar.matcher(inputdata).matches();
            if (SriMatch) {
                return CHAR_TYPE + "SRI LETTER";
            }
        } else if (cpcount == 3) {
            KshaCharMatch = KshaChar.matcher(inputdata).matches();
            if (KshaCharMatch) {
                return CHAR_TYPE + "KSHA LETTER";
            }
        } else if (cpcount == 2) {
            GranthaMeiMatch = GranthaMeiChar.matcher(inputdata).matches();
            if (GranthaMeiMatch) {
                return CHAR_TYPE + "GRANTHA MEI LETTER";
            }
            GranthaUyirMeiMatch = GranthaUyirMeiChar.matcher(inputdata).matches();
            if (GranthaUyirMeiMatch) {
                return CHAR_TYPE + "GRANTHA UYIR MEI LETTER";
            }
            UyirMeiMatch = UyirMei2Char.matcher(inputdata).matches();
            if (UyirMeiMatch) {
                String VM_NAME = getVowelMarkerName(String.valueOf(TamilChar.charAt(1)));
                return CHAR_TYPE + "UYIRMEI with " + VM_NAME + " Marker";
            }
            MeiMatch = MeiChar.matcher(inputdata).matches();
            if (MeiMatch) {
                String VM_NAME = getVowelMarkerName("" + TamilChar.charAt(1));
                return CHAR_TYPE + " MEI with " + VM_NAME;
            }
        } else if (cpcount == 1) {
            GranthaAgaramMatch = GranthaAgaramChar.matcher(inputdata).matches();
            if (GranthaAgaramMatch) {
                return CHAR_TYPE + "GRANTHA AGARAM LETTER";
            }
            AgaramMatch = AgaramChar.matcher(inputdata).matches();
            if (AgaramMatch) {
                return CHAR_TYPE + "AGARAM LETTER";
            }
            UyirMatch = UyirChar.matcher(inputdata).matches();
            if (UyirMatch) {
                return CHAR_TYPE + "UYIR LETTER";
            }
            AythamMatch = AythamChar.matcher(inputdata).matches();
            if (AythamMatch) {
                return CHAR_TYPE + "AYTHAM LETTER";
            }
            NumeralMatch = NumeralChar.matcher(inputdata).matches();
            if (NumeralMatch) {
                return CHAR_TYPE + "NUMERAL";
            }
        }
        return CHAR_TYPE + " NOT FOUND...!";
    }

    /**
     * Gets the name of the vowelMarker.
     *
     * @param vmarker VowelMarker string
     * @return A Standard Unicode Tamil Letter Name
     * @throws IllegalArgumentException an illegal or inappropriate argument
     */
    public static String getVowelMarkerName(String vmarker) throws IllegalArgumentException {
        // Check for size of the String to be containing only one Code Point.
        int vmcpcount = vmarker.codePointCount(0, vmarker.length());

        if (vmarker == null || vmcpcount == 0) {
            //throw new NullPointerException("Argument:: agaram has more than one CodePoint or CodePoint is zero!");
        }
        // Check for size of the String to be containing only one Code Point.
        if (vmcpcount > 1) {
            throw new IllegalArgumentException(
                    "Argument::" + vmarker + " has muliple CodePoints! Not a Valid Vowel Marker!");
        }

        if (vmarker.charAt(0) == '\u0BCD') {
            return VOWEL_MARKER_PULLI;
        } else if (vmarker.charAt(0) == '\u0BBE') {
            return VOWEL_MARKER_AA;
        } else if (vmarker.charAt(0) == '\u0BBF') {
            return VOWEL_MARKER_I;
        } else if (vmarker.charAt(0) == '\u0BC0') {
            return VOWEL_MARKER_II;
        } else if (vmarker.charAt(0) == '\u0BC1') {
            return VOWEL_MARKER_U;
        } else if (vmarker.charAt(0) == '\u0BC2') {
            return VOWEL_MARKER_UU;
        } else if (vmarker.charAt(0) == '\u0BC6') {
            return VOWEL_MARKER_E;
        } else if (vmarker.charAt(0) == '\u0BC7') {
            return VOWEL_MARKER_EE;
        } else if (vmarker.charAt(0) == '\u0BC8') {
            return VOWEL_MARKER_AI;
        } else if (vmarker.charAt(0) == '\u0BCA') {
            return VOWEL_MARKER_O;
        } else if (vmarker.charAt(0) == '\u0BCB') {
            return VOWEL_MARKER_OO;
        } else if (vmarker.charAt(0) == '\u0BCC') {
            return VOWEL_MARKER_AU;
        }
        return "";
    }


    /**
     * Returns {@code true} if, and only if, input is Vowel Marker Character.
     *
     * @param vmarker String containing one Vowel Marker Character.
     * @return {@code true} if, and only if, input is Vowel Marker Character.
     * {@code false} otherwise.
     */
    public static boolean isVMarker(String vmarker) {
        try {
            if ((getVowelMarkerName(vmarker)).length() != 0 && (getVowelMarkerName(vmarker) != null)) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception Caught in getVMarker...! " + vmarker + "  exception::" + e);
        }
        return false;
    }


    /**
     * Gets the name of the vowelMarker.
     *
     * @param agaram VowelMarker String
     * @return A Standard Unicode Tamil Agaram Name.
     * @throws IllegalArgumentException an illegal or inappropriate argument.
     */
    public static String getAgaramName(String agaram) throws IllegalArgumentException {
        String VM_result = null;
        int agaramcpcount = agaram.codePointCount(0, agaram.length());
        if (agaram == null || agaramcpcount == 0) {
            throw new NullPointerException("Argument:: agaram has more than one CodePoint or CodePoint is zero!");
        }
        // Check for size of the String to be containing only one Code Point.
        if (agaramcpcount > 1) {
            throw new IllegalArgumentException(
                    "Argument::" + agaram + " has muliple CodePoints! Not a valid Tamil Agaram!");
        }

        if (agaram.charAt(0) == '\u0B95') {
            return AGARAM_KA;
        } else if (agaram.charAt(0) == '\u0B99') {
            return AGARAM_NGA;
        } else if (agaram.charAt(0) == '\u0B9A') {
            return AGARAM_CA;
        } else if (agaram.charAt(0) == '\u0B9E') {
            return AGARAM_NYA;
        } else if (agaram.charAt(0) == '\u0B9F') {
            return AGARAM_TTA;
        } else if (agaram.charAt(0) == '\u0BA3') {
            return AGARAM_NNA;
        } else if (agaram.charAt(0) == '\u0BA4') {
            return AGARAM_TA;
        } else if (agaram.charAt(0) == '\u0BA8') {
            return AGARAM_NA;
        } else if (agaram.charAt(0) == '\u0BAA') {
            return AGARAM_PA;
        } else if (agaram.charAt(0) == '\u0BAE') {
            return AGARAM_MA;
        } else if (agaram.charAt(0) == '\u0BAF') {
            return AGARAM_YA;
        } else if (agaram.charAt(0) == '\u0BB0') {
            return AGARAM_RA;
        } else if (agaram.charAt(0) == '\u0BB2') {
            return AGARAM_LA;
        } else if (agaram.charAt(0) == '\u0BB5') {
            return AGARAM_VA;
        } else if (agaram.charAt(0) == '\u0BB4') {
            return AGARAM_LLLA;
        } else if (agaram.charAt(0) == '\u0BB3') {
            return AGARAM_LLA;
        } else if (agaram.charAt(0) == '\u0BB1') {
            return AGARAM_RRA;
        } else if (agaram.charAt(0) == '\u0BA9') {
            return AGARAM_NNNA;
        }
        return VM_result;
    }

    /**
     * Gets the name of the UyirEluthu
     *
     * @param uyireluthu String with a UyirEluthu(Tamil Vowel)
     * @return Name of the Vowel
     * @throws IllegalArgumentException AN Illegal or Inappropriate Argument
     */
    public static String getUyirName(String uyireluthu) throws IllegalArgumentException {
        // Check if has only one Code Point else raise an Exception.
        int uyircpcount = uyireluthu.codePointCount(0, uyireluthu.length());
        if (uyireluthu == null || uyircpcount == 0) {
            throw new NullPointerException("Argument:: agaram has more than one CodePoint or CodePoint is zero!");
        }
        // Check for size of the String to be containing only one Code Point.
        if (uyircpcount > 1) {
            throw new IllegalArgumentException(
                    "Argument::" + uyireluthu + " has muliple CodePoints! Not a valid Tamil Uyir eluthu!");
        }
        // Series of Checks
        if (uyireluthu.charAt(0) == '\u0B85') {
            return UYIR_A;
        } else if (uyireluthu.charAt(0) == '\u0B86') {
            return UYIR_AA;
        } else if (uyireluthu.charAt(0) == '\u0B87') {
            return UYIR_I;
        } else if (uyireluthu.charAt(0) == '\u0B88') {
            return UYIR_II;
        } else if (uyireluthu.charAt(0) == '\u0B89') {
            return UYIR_U;
        } else if (uyireluthu.charAt(0) == '\u0B8A') {
            return UYIR_UU;
        } else if (uyireluthu.charAt(0) == '\u0B8E') {
            return UYIR_E;
        } else if (uyireluthu.charAt(0) == '\u0B8F') {
            return UYIR_EE;
        } else if (uyireluthu.charAt(0) == '\u0B90') {
            return UYIR_AI;
        } else if (uyireluthu.charAt(0) == '\u0B92') {
            return UYIR_O;
        } else if (uyireluthu.charAt(0) == '\u0B93') {
            return UYIR_OO;
        } else if (uyireluthu.charAt(0) == '\u0B94') {
            return UYIR_AU;
        }
        return null;
    }

    /**
     * Check for Control char
     *
     * @param controlChar inputCharacter to be checked
     * @return true if input Character is Control Code
     */
    public static boolean isControlCode(Character controlChar) {
        final int intVal = Character.getNumericValue(controlChar);
        return (0 < intVal && intVal < 32) || (127 < intVal && intVal < 159);
    }

    /**
     * Check for Basic Latin char
     *
     * @param BasicLChar Character
     * @return true if input Character is Basic Latin Character
     */
    public static boolean isBasicLatin(Character BasicLChar) {
        final int intVal = Character.getNumericValue(BasicLChar);
        return (32 < intVal && intVal < 126);
    }

    /**
     * Check for Latin1Supplement char
     *
     * @param L1SupChar Character
     * @return true if input Character is Latin1Supplement Character
     */
    public static boolean isLatin1Supplement(Character L1SupChar) {
        final int intVal = Character.getNumericValue(L1SupChar);
        return (160 < intVal && intVal < 255);
    }

}
