/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since   26-05-2018
 */
package com.powertamil.lang.tamil;

public interface TamilLetter {

    /**
     * A FEW POINTS:
     * Unicode Sign ANUSVARA use is discouraged. So omitted from this interface.
     * TAMIL SIGN VIRAMA is named as PULLI as the word VIRAMA is not in use.
     * <a href="https://unicode.org/charts/PDF/U0B80.pdf">Character names-Version 10.0</a> This file contains an excerpt
     * from the character code tables and list of character names for
     * The Unicode Standard, Version 10.0
     */

    /* Standard Unicode Aytham (Visarga) */
    String AYTHAM = "TAMIL LETTER AYTHAM";

    /* Standard Unicode 12 Vowel Sign Names */
    String VOWEL_MARKER_PULLI = "PULLI";
    String VOWEL_MARKER_AA = "AA";
    String VOWEL_MARKER_I = "I";
    String VOWEL_MARKER_II = "II";
    String VOWEL_MARKER_U = "U";
    String VOWEL_MARKER_UU = "UU";
    String VOWEL_MARKER_E = "E";
    String VOWEL_MARKER_EE = "EE";
    String VOWEL_MARKER_AI = "AI";

    /* Standard Unicode Two Part Dependent Vowel Sign Names */
    String VOWEL_MARKER_O = "O";
    String VOWEL_MARKER_OO = "OO";
    String VOWEL_MARKER_AU = "AU";

    /* Standard Unicode Uyir Names (Vowels - Independent) */
    String UYIR_A = "TAMIL LETTER A";
    String UYIR_AA = "TAMIL LETTER AA";
    String UYIR_I = "TAMIL LETTER I";
    String UYIR_II = "TAMIL LETTER II";
    String UYIR_U = "TAMIL LETTER U";
    String UYIR_UU = "TAMIL LETTER UU";
    String UYIR_E = "TAMIL LETTER E";
    String UYIR_EE = "TAMIL LETTER EE";
    String UYIR_AI = "TAMIL LETTER AI";
    String UYIR_O = "TAMIL LETTER O";
    String UYIR_OO = "TAMIL LETTER OO";
    String UYIR_AU = "TAMIL LETTER AU";

    /* Standard Unicode Agaram Names (Consonants) */
    String AGARAM_KA = "TAMIL LETTER KA";
    String AGARAM_NGA = "TAMIL LETTER NGA";
    String AGARAM_CA = "TAMIL LETTER CA";
    String AGARAM_NYA = "TAMIL LETTER NYA";
    String AGARAM_TTA = "TAMIL LETTER TTA";
    String AGARAM_NNA = "TAMIL LETTER NNA";
    String AGARAM_TA = "TAMIL LETTER TA";
    String AGARAM_NA = "TAMIL LETTER NA";
    String AGARAM_PA = "TAMIL LETTER PA";
    String AGARAM_MA = "TAMIL LETTER MA";
    String AGARAM_YA = "TAMIL LETTER YA";
    String AGARAM_RA = "TAMIL LETTER RA";
    String AGARAM_LA = "TAMIL LETTER LA";
    String AGARAM_VA = "TAMIL LETTER VA";
    String AGARAM_LLLA = "TAMIL LETTER LLLA";
    String AGARAM_LLA = "TAMIL LETTER LLA";
    String AGARAM_RRA = "TAMIL LETTER RRA";
    String AGARAM_NNNA = "TAMIL LETTER NNNA";

    /* Standard Unicode Tamil Digits */
    String DIGIT_0 = "TAMIL DIGIT ZERO";
    String DIGIT_1 = "TAMIL DIGIT ONE";
    String DIGIT_2 = "TAMIL DIGIT TWO";
    String DIGIT_3 = "TAMIL DIGIT THREE";
    String DIGIT_4 = "TAMIL DIGIT FOUR";
    String DIGIT_5 = "TAMIL DIGIT FIVE";
    String DIGIT_6 = "TAMIL DIGIT SIX";
    String DIGIT_7 = "TAMIL DIGIT SEVEN";
    String DIGIT_8 = "TAMIL DIGIT EIGHT";
    String DIGIT_9 = "TAMIL DIGIT NINE";

    /* Standard Unicode Tamil Numbers */
    String NUMBER_10 = "TAMIL NUMBER TEN";
    String NUMBER_100 = "TAMIL NUMBER HUNDRED";
    String NUMBER_1000 = "TAMIL NUMBER THOUSAND";

    /* Standard Unicode Tamil Symbol Names */
    String SYMBOL_OM = "TAMIL OM";
    String SYMBOL_DAY = "TAMIL DAY SIGN";
    String SYMBOL_MONTH = "TAMIL MONTH SIGN";
    String SYMBOL_YEAR = "TAMIL YEAR SIGN";
    String SYMBOL_DEBIT = "TAMIL DEBIT SIGN";
    String SYMBOL_CREDIT = "TAMIL CREDIT SIGN";
    String SYMBOL_AS_ABOVE = "TAMIL AS ABOVE SIGN";
    String SYMBOL_RUPEE = "TAMIL RUPEE SIGN";
    String SYMBOL_NUMBER = "TAMIL NUMBER SIGN";

}
