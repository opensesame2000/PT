/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since   26-05-2018
 */

package com.powertamil.lang.tamil;

import java.util.*;

public class UTF8 {

    public final static ArrayList<String> allTamilLetters = new ArrayList<String>();
    public static TCharacter[] AllTC = null;
    public static ArrayList<String> AllUTFList = new ArrayList<String>();

    public final static String[] AllUTF = new String[]{
            "௳", "௴", "௵", "௶", "௷", "௸", "௹", "௺", "ௐ",
            "௦", "௧", "௨", "௩", "௪", "௫", "௬", "௭", "௮", "௯", "௰", "௱", "௲",
            "்", "ா", "ி", "ீ", "ு", "ூ", "ெ", "ே", "ை", "ொ", "ோ", "ௌ",
            "அ", "ஆ", "இ", "ஈ", "உ", "ஊ", "எ", "ஏ", "ஐ", "ஒ", "ஓ", "ஔ", "ஃ",
            "க்", "க", "கா", "கி", "கீ", "கு", "கூ", "கெ", "கே", "கை", "கொ", "கோ", "கௌ",
            "ங்", "ங", "ஙா", "ஙி", "ஙீ", "ஙு", "ஙூ", "ஙெ", "ஙே", "ஙை", "ஙொ", "ஙோ", "ஙௌ",
            "ச்", "ச", "சா", "சி", "சீ", "சு", "சூ", "செ", "சே", "சை", "சொ", "சோ", "சௌ",
            "ஞ்", "ஞ", "ஞா", "ஞி", "ஞீ", "ஞு", "ஞூ", "ஞெ", "ஞே", "ஞை", "ஞொ", "ஞோ", "ஞௌ",
            "ட்", "ட", "டா", "டி", "டீ", "டு", "டூ", "டெ", "டே", "டை", "டொ", "டோ", "டௌ",
            "ண்", "ண", "ணா", "ணி", "ணீ", "ணு", "ணூ", "ணெ", "ணே", "ணை", "ணொ", "ணோ", "ணௌ",
            "த்", "த", "தா", "தி", "தீ", "து", "தூ", "தெ", "தே", "தை", "தொ", "தோ", "தௌ",
            "ந்", "ந", "நா", "நி", "நீ", "நு", "நூ", "நெ", "நே", "நை", "நொ", "நோ", "நௌ",
            "ப்", "ப", "பா", "பி", "பீ", "பு", "பூ", "பெ", "பே", "பை", "பொ", "போ", "பௌ",
            "ம்", "ம", "மா", "மி", "மீ", "மு", "மூ", "மெ", "மே", "மை", "மொ", "மோ", "மௌ",
            "ய்", "ய", "யா", "யி", "யீ", "யு", "யூ", "யெ", "யே", "யை", "யொ", "யோ", "யௌ",
            "ர்", "ர", "ரா", "ரி", "ரீ", "ரு", "ரூ", "ரெ", "ரே", "ரை", "ரொ", "ரோ", "ரௌ",
            "ல்", "ல", "லா", "லி", "லீ", "லு", "லூ", "லெ", "லே", "லை", "லொ", "லோ", "லௌ",
            "வ்", "வ", "வா", "வி", "வீ", "வு", "வூ", "வெ", "வே", "வை", "வொ", "வோ", "வௌ",
            "ழ்", "ழ", "ழா", "ழி", "ழீ", "ழு", "ழூ", "ழெ", "ழே", "ழை", "ழொ", "ழோ", "ழௌ",
            "ள்", "ள", "ளா", "ளி", "ளீ", "ளு", "ளூ", "ளெ", "ளே", "ளை", "ளொ", "ளோ", "ளௌ",
            "ற்", "ற", "றா", "றி", "றீ", "று", "றூ", "றெ", "றே", "றை", "றொ", "றோ", "றௌ",
            "ன்", "ன", "னா", "னி", "னீ", "னு", "னூ", "னெ", "னே", "னை", "னொ", "னோ", "னௌ",
            "ஜ்", "ஜ", "ஜா", "ஜி", "ஜீ", "ஜு", "ஜூ", "ஜெ", "ஜே", "ஜை", "ஜொ", "ஜோ", "ஜௌ",
            "ஶ்", "ஶ", "ஶா", "ஶி", "ஶீ", "ஶு", "ஶூ", "ஶெ", "ஶே", "ஶை", "ஶொ", "ஶோ", "ஶௌ",
            "ஷ்", "ஷ", "ஷா", "ஷி", "ஷீ", "ஷு", "ஷூ", "ஷெ", "ஷே", "ஷை", "ஷொ", "ஷோ", "ஷௌ",
            "ஸ்", "ஸ", "ஸா", "ஸி", "ஸீ", "ஸு", "ஸூ", "ஸெ", "ஸே", "ஸை", "ஸொ", "ஸோ", "ஸௌ",
            "ஹ்", "ஹ", "ஹா", "ஹி", "ஹீ", "ஹு", "ஹூ", "ஹெ", "ஹே", "ஹை", "ஹொ", "ஹோ", "ஹௌ",
            "க்ஷ்", "க்ஷ", "க்ஷா", "க்ஷி", "க்ஷீ", "க்ஷு", "க்ஷூ", "க்ஷெ", "க்ஷே", "க்ஷை", "க்ஷொ", "க்ஷோ", "க்ஷௌ",
            "ஸ்ரீ"
    };


    /* Tamil marks */
    final static String[] Tamil_Symbols = new String[]{
            "E0AFB3", "E0AFB4", "E0AFB5", "E0AFB6", "E0AFB7", "E0AFB8", "E0AFB9", "E0AFBA",
            "E0AEAAE0AF8CE0AEB0E0AF8DE0AEA3E0AEAEE0AEBF", "E0AE85E0AEAEE0AEBEE0AEB5E0AEBEE0AE9AE0AF88",
            "E0AE95E0AEBEE0AEB0E0AF8DE0AEA4E0AF8DE0AEA4E0AEBFE0AE95E0AF88", "E0AEB0E0AEBEE0AE9C", "E0AF90"
    };
    final static String[] Tamil_Numerals = new String[]{
            "E0AFA6", "E0AFA7", "E0AFA8", "E0AFA9", "E0AFAA", "E0AFAB", "E0AFAC", "E0AFAD", "E0AFAE", "E0AFAF", "E0AFB0", "E0AFB1", "E0AFB2"
    };
    final static String[] Tamil_Fractions = new String[]{
            "E0AE85E0AEB0E0AF88E0AE95E0AF8DE0AE95E0AEBEE0AEB2E0AF8D",
            "E0AE95E0AEBEE0AEB2E0AF8D",
            "E0AE85E0AEB0E0AF88",
            "E0AEAEE0AF81E0AE95E0AF8DE0AE95E0AEBEE0AEB2E0AF8D",
            "E0AE85E0AEB0E0AF88E0AEB5E0AF80E0AE9AE0AEAEE0AF8D",
            "E0AEB5E0AF80E0AE9AE0AEAEE0AF8D",
            "E0AEAEE0AF82E0AEB5E0AF80E0AE9AE0AEAEE0AF8D",
            "E0AE85E0AEB0E0AF88E0AEAEE0AEBE",
            "E0AE92E0AEB0E0AF81E0AEAEE0AEBE",
            "E0AE87E0AEB0E0AEA3E0AF8DE0AE9FE0AF81E0AEAEE0AEBE",
            "E0AEAEE0AF81E0AEAEE0AF8DE0AEAEE0AEBE",
            "E0AEA8E0AEBEE0AEB2E0AF81E0AEAEE0AEBE",
            "E0AEAEE0AF81E0AEA8E0AF8DE0AEA4E0AEBFE0AEB0E0AEBF",
            "E0AE85E0AEB0E0AF88E0AE95E0AF8DE0AE95E0AEBEE0AEA3E0AEBF",
            "E0AE95E0AEBEE0AEA3E0AEBF",
            "E0AEAEE0AF81E0AE95E0AF8DE0AE95E0AEBEE0AEA3E0AEBF"
    };
    final static String[] Vowel_Markers = new String[]{
            "E0AF8D", "E0AEBE", "E0AEBF", "E0AF80", "E0AF81", "E0AF82", "E0AF86", "E0AF87", "E0AF88", "E0AF8A", "E0AF8B", "E0AF8C"
    };

    /* Tamil Letters*/
    final static String[] Aytham_Letter = new String[]{
            "E0AE83"
    };


    // Letter :: அ
    // UTF-8 (hex) 	0xE0 0xAE 0x85 (e0ae85)
    // UTF-8 (binary) 	11100000:10101110:10000101
    // UTF-16 (hex) 	0x0B85 (0b85)
    // UTF-16 (decimal) 	2,949
    final static String[] Uyir_Letters = new String[]{
            "********", "E0AE86", "E0AE87", "E0AE88", "E0AE89", "E0AE8A",
            "E0AE8E", "E0AE8F", "E0AE90", "E0AE92", "E0AE93", "E0AE94"
    };
    final static String[] Mei_Letters = new String[]{
            "E0AE95E0AF8D", "E0AE99E0AF8D", "E0AE9AE0AF8D", "E0AE9EE0AF8D", "E0AE9FE0AF8D", "E0AEA3E0AF8D",
            "E0AEA4E0AF8D", "E0AEA8E0AF8D", "E0AEAAE0AF8D", "E0AEAEE0AF8D", "E0AEAFE0AF8D", "E0AEB0E0AF8D",
            "E0AEB2E0AF8D", "E0AEB5E0AF8D", "E0AEB4E0AF8D", "E0AEB3E0AF8D", "E0AEB1E0AF8D", "E0AEA9E0AF8D"
    };
    final static String[] Grantha_Mei_Letters = new String[]{
            "E0AE9CE0AF8D", "E0AEB6E0AF8D", "E0AEB7E0AF8D",
            "E0AEB8E0AF8D", "E0AEB9E0AF8D", "E0AE95E0AF8DE0AEB7E0AF8D"
    };

    /* Uyir Mei*/
    final static String[] KA_Uyir_Mei = new String[]{
            "E0AE95", "E0AE95E0AEBE", "E0AE95E0AEBF", "E0AE95E0AF80", "E0AE95E0AF81", "E0AE95E0AF82",
            "E0AE95E0AF86", "E0AE95E0AF87", "E0AE95E0AF88", "E0AE95E0AF8A", "E0AE95E0AF8B", "E0AE95E0AF8C"
    };
    final static String[] NGA_Uyir_Mei = new String[]{
            "E0AE99", "E0AE99E0AEBE", "E0AE99E0AEBF", "E0AE99E0AF80", "E0AE99E0AF81", "E0AE99E0AF82",
            "E0AE99E0AF86", "E0AE99E0AF87", "E0AE99E0AF88", "E0AE99E0AF8A", "E0AE99E0AF8B", "E0AE99E0AF8C"
    };
    final static String[] CA_Uyir_Mei = new String[]{
            "E0AE9A", "E0AE9AE0AEBE", "E0AE9AE0AEBF", "E0AE9AE0AF80", "E0AE9AE0AF81", "E0AE9AE0AF82",
            "E0AE9AE0AF86", "E0AE9AE0AF87", "E0AE9AE0AF88", "E0AE9AE0AF8A", "E0AE9AE0AF8B", "E0AE9AE0AF8C"
    };
    final static String[] NYA_Uyir_Mei = new String[]{
            "E0AE9E", "E0AE9EE0AEBE", "E0AE9EE0AEBF", "E0AE9EE0AF80", "E0AE9EE0AF81", "E0AE9EE0AF82",
            "E0AE9EE0AF86", "E0AE9EE0AF87", "E0AE9EE0AF88", "E0AE9EE0AF8A", "E0AE9EE0AF8B", "E0AE9EE0AF8C"
    };
    final static String[] TTA_Uyir_Mei = new String[]{
            "E0AE9F", "E0AE9FE0AEBE", "E0AE9FE0AEBF", "E0AE9FE0AF80", "E0AE9FE0AF81", "E0AE9FE0AF82",
            "E0AE9FE0AF86", "E0AE9FE0AF87", "E0AE9FE0AF88", "E0AE9FE0AF8A", "E0AE9FE0AF8B", "E0AE9FE0AF8C"
    };
    final static String[] NNA_Uyir_Mei = new String[]{
            "E0AEA3", "E0AEA3E0AEBE", "E0AEA3E0AEBF", "E0AEA3E0AF80", "E0AEA3E0AF81", "E0AEA3E0AF82",
            "E0AEA3E0AF86", "E0AEA3E0AF87", "E0AEA3E0AF88", "E0AEA3E0AF8A", "E0AEA3E0AF8B", "E0AEA3E0AF8C"
    };
    final static String[] TA_Uyir_Mei = new String[]{
            "E0AEA4", "E0AEA4E0AEBE", "E0AEA4E0AEBF", "E0AEA4E0AF80", "E0AEA4E0AF81", "E0AEA4E0AF82",
            "E0AEA4E0AF86", "E0AEA4E0AF87", "E0AEA4E0AF88", "E0AEA4E0AF8A", "E0AEA4E0AF8B", "E0AEA4E0AF8C"
    };
    final static String[] NA_Uyir_Mei = new String[]{
            "E0AEA8", "E0AEA8E0AEBE", "E0AEA8E0AEBF", "E0AEA8E0AF80", "E0AEA8E0AF81", "E0AEA8E0AF82",
            "E0AEA8E0AF86", "E0AEA8E0AF87", "E0AEA8E0AF88", "E0AEA8E0AF8A", "E0AEA8E0AF8B", "E0AEA8E0AF8C"
    };
    final static String[] PA_Uyir_Mei = new String[]{
            "E0AEAA", "E0AEAAE0AEBE", "E0AEAAE0AEBE", "E0AEAAE0AF80", "E0AEAAE0AF81", "E0AEAAE0AF82",
            "E0AEAAE0AF86", "E0AEAAE0AF87", "E0AEAAE0AF88", "E0AEAAE0AF8A", "E0AEAAE0AF8B", "E0AEAAE0AF8C"
    };
    final static String[] MA_Uyir_Mei = new String[]{
            "E0AEAE", "E0AEAEE0AEBE", "E0AEAEE0AEBF", "E0AEAEE0AF80", "E0AEAEE0AF81", "E0AEAEE0AF82",
            "E0AEAEE0AF86", "E0AEAEE0AF87", "E0AEAEE0AF88", "E0AEAEE0AF8A", "E0AEAEE0AF8B", "E0AEAEE0AF8C"
    };
    final static String[] YA_Uyir_Mei = new String[]{
            "E0AEAF", "E0AEAFE0AEBE", "E0AEAFE0AEBF", "E0AEAFE0AF80", "E0AEAFE0AF81", "E0AEAFE0AF82",
            "E0AEAFE0AF86", "E0AEAFE0AF87", "E0AEAFE0AF88", "E0AEAFE0AF8A", "E0AEAFE0AF8B", "E0AEAFE0AF8C"
    };
    final static String[] RA_Uyir_Mei = new String[]{
            "E0AEB0", "E0AEB0E0AEBE", "E0AEB0E0AEBF", "E0AEB0E0AF80", "E0AEB0E0AF81", "E0AEB0E0AF82",
            "E0AEB0E0AF86", "E0AEB0E0AF87", "E0AEB0E0AF88", "E0AEB0E0AF8A", "E0AEB0E0AF8B", "E0AEB0E0AF8C"
    };
    final static String[] LA_Uyir_Mei = new String[]{
            "E0AEB2", "E0AEB2E0AEBE", "E0AEB2E0AEBF", "E0AEB2E0AF80", "E0AEB2E0AF81", "E0AEB2E0AF82",
            "E0AEB2E0AF86", "E0AEB2E0AF87", "E0AEB2E0AF88", "E0AEB2E0AF8A", "E0AEB2E0AF8B", "E0AEB2E0AF8C"
    };
    final static String[] VA_Uyir_Mei = new String[]{
            "E0AEB5", "E0AEB5E0AEBE", "E0AEB5E0AEBF", "E0AEB5E0AF80", "E0AEB5E0AF81", "E0AEB5E0AF82",
            "E0AEB5E0AF86", "E0AEB5E0AF87", "E0AEB5E0AF88", "E0AEB5E0AF8A", "E0AEB5E0AF8B", "E0AEB5E0AF8C"
    };
    final static String[] LLLA_Uyir_Mei = new String[]{
            "E0AEB4", "E0AEB4E0AEBE", "E0AEB4E0AEBF", "E0AEB4E0AF80", "E0AEB4E0AF81", "E0AEB4E0AF82",
            "E0AEB4E0AF86", "E0AEB4E0AF87", "E0AEB4E0AF88", "E0AEB4E0AF8A", "E0AEB4E0AF8B", "E0AEB4E0AF8C"
    };
    final static String[] LLA_Uyir_Mei = new String[]{
            "E0AEB3", "E0AEB3E0AEBE", "E0AEB3E0AEBF", "E0AEB3E0AF80", "E0AEB3E0AF81", "E0AEB3E0AF82",
            "E0AEB3E0AF86", "E0AEB3E0AF87", "E0AEB3E0AF88", "E0AEB3E0AF8A", "E0AEB3E0AF8B", "E0AEB3E0AF8C"
    };
    final static String[] RRA_Uyir_Mei = new String[]{
            "E0AEB1", "E0AEB1E0AEBE", "E0AEB1E0AEBF", "E0AEB1E0AF80", "E0AEB1E0AF81", "E0AEB1E0AF82",
            "E0AEB1E0AF86", "E0AEB1E0AF87", "E0AEB1E0AF88", "E0AEB1E0AF8A", "E0AEB1E0AF8B", "E0AEB1E0AF8C"
    };
    final static String[] NNNA_Uyir_Mei = new String[]{
            "E0AEA9", "E0AEA9E0AEBE", "E0AEA9E0AEBF", "E0AEA9E0AF80", "E0AEA9E0AF81", "E0AEA9E0AF82",
            "E0AEA9E0AF86", "E0AEA9E0AF87", "E0AEA9E0AF88", "E0AEA9E0AF8A", "E0AEA9E0AF8B", "E0AEA9E0AF8C"
    };

    /* Grantha Uyir Mei */
    final static String[] JHA_Uyir_Mei = new String[]{
            "E0AE9C", "E0AE9CE0AEBE", "E0AE9CE0AEBF", "E0AE9CE0AF80", "E0AE9CE0AF81", "E0AE9CE0AF82",
            "E0AE9CE0AF86", "E0AE9CE0AF87", "E0AE9CE0AF88", "E0AE9CE0AF8A", "E0AE9CE0AF8B", "E0AE9CE0AF8C"
    };
    final static String[] SA_Uyir_Mei = new String[]{
            "E0AEB6", "E0AEB6E0AEBE", "E0AEB6E0AEBF", "E0AEB6E0AF80", "E0AEB6E0AF81", "E0AEB6E0AF82",
            "E0AEB6E0AF86", "E0AEB6E0AF87", "E0AEB6E0AF88", "E0AEB6E0AF8A", "E0AEB6E0AF8B", "E0AEB6E0AF8C"
    };
    final static String[] SHA_Uyir_Mei = new String[]{
            "E0AEB7", "E0AEB7E0AEBE", "E0AEB7E0AEBF", "E0AEB7E0AF80", "E0AEB7E0AF81", "E0AEB7E0AF82",
            "E0AEB7E0AF86", "E0AEB7E0AF87", "E0AEB7E0AF88", "E0AEB7E0AF8A", "E0AEB7E0AF8B", "E0AEB7E0AF8C"
    };
    final static String[] SSA_Uyir_Mei = new String[]{
            "E0AEB8", "E0AEB8E0AEBE", "E0AEB8E0AEBF", "E0AEB8E0AF80", "E0AEB8E0AF81", "E0AEB8E0AF82",
            "E0AEB8E0AF86", "E0AEB8E0AF87", "E0AEB8E0AF88", "E0AEB8E0AF8A", "E0AEB8E0AF8B", "E0AEB8E0AF8C"
    };
    final static String[] HA_Uyir_Mei = new String[]{
            "E0AEB9", "E0AEB9E0AEBE", "E0AEB9E0AEBF", "E0AEB9E0AF80", "E0AEB9E0AF81", "E0AEB9E0AF82",
            "E0AEB9E0AF86", "E0AEB9E0AF87", "E0AEB9E0AF88", "E0AEB9E0AF8A", "E0AEB9E0AF8B", "E0AEB9E0AF8C"
    };
    final static String[] KSHA_Uyir_Mei = new String[]{
            "E0AE95E0AF8DE0AEB7", "E0AE95E0AF8DE0AEB7E0AEBE", "E0AE95E0AF8DE0AEB7E0AEBF", "E0AE95E0AF8DE0AEB7E0AF80",
            "E0AE95E0AF8DE0AEB7E0AF81", "E0AE95E0AF8DE0AEB7E0AF82", "E0AE95E0AF8DE0AEB7E0AF86", "E0AE95E0AF8DE0AEB7E0AF87",
            "E0AE95E0AF8DE0AEB7E0AF88", "E0AE95E0AF8DE0AEB7E0AF8A", "E0AE95E0AF8DE0AEB7E0AF8B", "E0AE95E0AF8DE0AEB7E0AF8C"
    };
    final static String[] SRI_Uyir_Mei = new String[]{
            "E0AEB8E0AF8DE0AEB0E0AF80"
    };

    public final static ArrayList<String> Symbols_List = new ArrayList<>();

    public final static ArrayList<String> Markers_List = new ArrayList<>();
    public final static ArrayList<String> Fractions_List = new ArrayList<>();
    public final static ArrayList<String> Numerics_List = new ArrayList<>();

    public final static ArrayList<String> Aytham_List = new ArrayList<>();
    public final static ArrayList<String> Uyir_List = new ArrayList<>();
    public final static ArrayList<String> Mei_List = new ArrayList<>();
    public final static ArrayList<String> GranthaMei_List = new ArrayList<>();
    public final static ArrayList<String> UyirMei_List = new ArrayList<>();
    public final static ArrayList<String> GranthaUyirMei_List = new ArrayList<>();
    public final static ArrayList<String> Shri_List = new ArrayList<>();

    public final static ArrayList<String> allTamilLetterList = new ArrayList<>();

    static {
        for (int g = 0; g < AllUTF.length; g++) {
            AllUTFList.add(AllUTF[g]);
        }

        Symbols_List.addAll(Arrays.asList(UTF8.Tamil_Symbols));
        Markers_List.addAll(Arrays.asList(UTF8.Vowel_Markers));
        Fractions_List.addAll(Arrays.asList(UTF8.Tamil_Fractions));
        Numerics_List.addAll(Arrays.asList(UTF8.Tamil_Numerals));

        //Primary Letters Set
        Aytham_List.addAll(Arrays.asList(UTF8.Aytham_Letter));
        Uyir_List.addAll(Arrays.asList(UTF8.Uyir_Letters));
        Mei_List.addAll(Arrays.asList(UTF8.Mei_Letters));
        GranthaMei_List.addAll(Arrays.asList(UTF8.Grantha_Mei_Letters));

        //Derived letters Set
        UyirMei_List.addAll(Arrays.asList(UTF8.KA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.NGA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.CA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.NYA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.TTA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.NNA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.TA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.NA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.PA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.MA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.YA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.RA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.LA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.VA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.LLLA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.LLA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.RRA_Uyir_Mei));
        UyirMei_List.addAll(Arrays.asList(UTF8.NNNA_Uyir_Mei));

        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.JHA_Uyir_Mei));
        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.SA_Uyir_Mei));
        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.SHA_Uyir_Mei));
        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.SSA_Uyir_Mei));
        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.HA_Uyir_Mei));
        GranthaUyirMei_List.addAll(Arrays.asList(UTF8.KSHA_Uyir_Mei));

        Shri_List.addAll(Arrays.asList(UTF8.SRI_Uyir_Mei));

        //Form a Union of all Tamil characters except fractions.
        allTamilLetterList.addAll(Markers_List);
        allTamilLetterList.addAll(Numerics_List);
        allTamilLetterList.addAll(Aytham_List);
        allTamilLetterList.addAll(Uyir_List);
        allTamilLetterList.addAll(Mei_List);
        allTamilLetterList.addAll(GranthaMei_List);
        allTamilLetterList.addAll(UyirMei_List);
        allTamilLetterList.addAll(GranthaUyirMei_List);
        allTamilLetterList.addAll(Shri_List);

        AllTC = new TCharacter[UTF8.AllUTF.length];
    }

    public UTF8() {
        super();
        AllTC = getAllUTFTC();
    }

    public static int tamilLettersCount() {
        //At the moment we are not considering Tamil Fractions and a few symbols as Letters.
        //Update:: do we ??
        return (allTamilLetterList.size());
    }

    public static List<String> getAllTamilList() {

        return AllUTFList;
    }

    public static TCharacter[] getAllUTFTC() {
        for (int c = 0; c < UTF8.AllUTF.length; c++) {
            TCharacter eachTC = new TCharacter(UTF8.AllUTF[c].toCharArray());
            AllTC[c] = eachTC;
        }
        return AllTC;
    }
}






