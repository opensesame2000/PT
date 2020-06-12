package com.powertamil.transform;

import com.powertamil.collections.ArrayMap;

import java.util.List;


public class Tamil2Latin {

    /**
     *
     * Tamil2Latin ::
     * Future work:: Plan is to make it compliant with {@Link https://en.wikipedia.org/wiki/ISO_15919}
     * "Transliteration of Devanagari and related Indic scripts into Latin characters" - 2001 International
     * Romanization standards.
     *
     */
    private final static ArrayMap<String, String> translitMap = new ArrayMap<String, String>();;

    static {


        translitMap.put("அ", "a");
        translitMap.put("ஆ", "aa");
        translitMap.put("இ", "i");
        translitMap.put("ஈ", "ii");
        translitMap.put("உ", "u");
        translitMap.put("ஊ", "uu");
        translitMap.put("எ", "e");
        translitMap.put("ஏ", "ee");
        translitMap.put("ஐ", "ai");
        translitMap.put("ஒ", "o");
        translitMap.put("ஓ", "oo");
        translitMap.put("ஔ", "au");
        translitMap.put("ஃ", "_k");

        translitMap.put("க்", "k");
        translitMap.put("க", "ka");
        translitMap.put("கா", "kaa");
        translitMap.put("கி", "ki");
        translitMap.put("கீ", "kii");
        translitMap.put("கு", "ku");
        translitMap.put("கூ", "kuu");
        translitMap.put("கெ", "ke");
        translitMap.put("கே", "kee");
        translitMap.put("கை", "kai");
        translitMap.put("கொ", "ko");
        translitMap.put("கோ", "koo");
        translitMap.put("கௌ", "kau");

        translitMap.put("ங்", "ng");
        translitMap.put("ங", "nga");
        translitMap.put("ஙா", "ngaa");
        translitMap.put("ஙி", "ngi");
        translitMap.put("ஙீ", "ngii");
        translitMap.put("ஙு", "ngu");
        translitMap.put("ஙூ", "nguu");
        translitMap.put("ஙெ", "nge");
        translitMap.put("ஙே", "ngee");
        translitMap.put("ஙை", "ngai");
        translitMap.put("ஙொ", "ngo");
        translitMap.put("ஙோ", "ngoo");
        translitMap.put("ஙௌ", "ngau");

        translitMap.put("ச்", "s");
        translitMap.put("ச", "sa");
        translitMap.put("சா", "saa");
        translitMap.put("சி", "si");
        translitMap.put("சீ", "sii");
        translitMap.put("சு", "su");
        translitMap.put("சூ", "suu");
        translitMap.put("செ", "se");
        translitMap.put("சே", "see");
        translitMap.put("சை", "sai");
        translitMap.put("சொ", "so");
        translitMap.put("சோ", "soo");
        translitMap.put("சௌ", "sau");

        translitMap.put("ஞ்", "nj");
        translitMap.put("ஞ", "nja");
        translitMap.put("ஞா", "njaa");
        translitMap.put("ஞி", "nji");
        translitMap.put("ஞீ", "njii");
        translitMap.put("ஞு", "nju");
        translitMap.put("ஞூ", "njuu");
        translitMap.put("ஞெ", "nje");
        translitMap.put("ஞே", "njee");
        translitMap.put("ஞை", "njai");
        translitMap.put("ஞொ", "njo");
        translitMap.put("ஞோ", "njoo");
        translitMap.put("ஞௌ", "njau");

        translitMap.put("ட்", "d");
        translitMap.put("ட", "da");
        translitMap.put("டா", "daa");
        translitMap.put("டி", "di");
        translitMap.put("டீ", "dii");
        translitMap.put("டு", "du");
        translitMap.put("டூ", "duu");
        translitMap.put("டெ", "de");
        translitMap.put("டே", "dee");
        translitMap.put("டை", "dai");
        translitMap.put("டொ", "do");
        translitMap.put("டோ", "doo");
        translitMap.put("டௌ", "dau");

        translitMap.put("ண்", "N");
        translitMap.put("ண", "Na");
        translitMap.put("ணா", "Naa");
        translitMap.put("ணி", "Ni");
        translitMap.put("ணீ", "Nii");
        translitMap.put("ணு", "Nu");
        translitMap.put("ணூ", "Nuu");
        translitMap.put("ணெ", "Ne");
        translitMap.put("ணே", "Nee");
        translitMap.put("ணை", "Nai");
        translitMap.put("ணொ", "No");
        translitMap.put("ணோ", "Noo");
        translitMap.put("ணௌ", "Nau");

        translitMap.put("த்", "th");
        translitMap.put("த", "tha");
        translitMap.put("தா", "thaa");
        translitMap.put("தி", "thi");
        translitMap.put("தீ", "thii");
        translitMap.put("து", "thu");
        translitMap.put("தூ", "thuu");
        translitMap.put("தெ", "the");
        translitMap.put("தே", "thee");
        translitMap.put("தை", "thai");
        translitMap.put("தொ", "tho");
        translitMap.put("தோ", "thoo");
        translitMap.put("தௌ", "thau");

        translitMap.put("ந்", "n-");
        translitMap.put("ந", "n-a");
        translitMap.put("நா", "n-aa");
        translitMap.put("நி", "n-i");
        translitMap.put("நீ", "n-ii");
        translitMap.put("நு", "n-u");
        translitMap.put("நூ", "n-uu");
        translitMap.put("நெ", "n-e");
        translitMap.put("நே", "n-ee");
        translitMap.put("நை", "n-ai");
        translitMap.put("நொ", "n-o");
        translitMap.put("நோ", "n-oo");
        translitMap.put("நௌ", "n-au");

        translitMap.put("ப்", "p");
        translitMap.put("ப", "pa");
        translitMap.put("பா", "paa");
        translitMap.put("பி", "pi");
        translitMap.put("பீ", "pii");
        translitMap.put("பு", "pu");
        translitMap.put("பூ", "puu");
        translitMap.put("பெ", "pe");
        translitMap.put("பே", "pee");
        translitMap.put("பை", "pai");
        translitMap.put("பொ", "po");
        translitMap.put("போ", "poo");
        translitMap.put("பௌ", "pau");

        translitMap.put("ம்", "m");
        translitMap.put("ம", "ma");
        translitMap.put("மா", "maa");
        translitMap.put("மி", "mi");
        translitMap.put("மீ", "mii");
        translitMap.put("மு", "mu");
        translitMap.put("மூ", "muu");
        translitMap.put("மெ", "me");
        translitMap.put("மே", "mee");
        translitMap.put("மை", "mai");
        translitMap.put("மொ", "mo");
        translitMap.put("மோ", "moo");
        translitMap.put("மௌ", "mau");

        translitMap.put("ய்", "y");
        translitMap.put("ய", "ya");
        translitMap.put("யா", "yaa");
        translitMap.put("யி", "yi");
        translitMap.put("யீ", "yii");
        translitMap.put("யு", "yu");
        translitMap.put("யூ", "yuu");
        translitMap.put("யெ", "ye");
        translitMap.put("யே", "ye");
        translitMap.put("யை", "yai");
        translitMap.put("யொ", "yo");
        translitMap.put("யோ", "yoo");
        translitMap.put("யௌ", "yau");

        translitMap.put("ர்", "r");
        translitMap.put("ர", "ra");
        translitMap.put("ரா", "raa");
        translitMap.put("ரி", "ri");
        translitMap.put("ரீ", "rii");
        translitMap.put("ரு", "ru");
        translitMap.put("ரூ", "ruu");
        translitMap.put("ரெ", "re");
        translitMap.put("ரே", "ree");
        translitMap.put("ரை", "rai");
        translitMap.put("ரொ", "ro");
        translitMap.put("ரோ", "roo");
        translitMap.put("ரௌ", "rau");

        translitMap.put("ல்", "l");
        translitMap.put("ல", "la");
        translitMap.put("லா", "la");
        translitMap.put("லி", "li");
        translitMap.put("லீ", "lii");
        translitMap.put("லு", "lu");
        translitMap.put("லூ", "luu");
        translitMap.put("லெ", "le");
        translitMap.put("லே", "lee");
        translitMap.put("லை", "lai");
        translitMap.put("லொ", "lo");
        translitMap.put("லோ", "loo");
        translitMap.put("லௌ", "lau");

        translitMap.put("வ்", "v");
        translitMap.put("வ", "va");
        translitMap.put("வா", "vaa");
        translitMap.put("வி", "vi");
        translitMap.put("வீ", "vii");
        translitMap.put("வு", "vu");
        translitMap.put("வூ", "vuu");
        translitMap.put("வெ", "ve");
        translitMap.put("வே", "vee");
        translitMap.put("வை", "vai");
        translitMap.put("வொ", "vo");
        translitMap.put("வோ", "voo");
        translitMap.put("வௌ", "vau");

        translitMap.put("ழ்", "zh");
        translitMap.put("ழ", "zha");
        translitMap.put("ழா", "zhaa");
        translitMap.put("ழி", "zhi");
        translitMap.put("ழீ", "zhii");
        translitMap.put("ழு", "zhu");
        translitMap.put("ழூ", "zhuu");
        translitMap.put("ழெ", "zhe");
        translitMap.put("ழே", "zhee");
        translitMap.put("ழை", "zhai");
        translitMap.put("ழொ", "zho");
        translitMap.put("ழோ", "zhoo");
        translitMap.put("ழௌ", "zhau");

        translitMap.put("ள்", "L");
        translitMap.put("ள", "La");
        translitMap.put("ளா", "Laa");
        translitMap.put("ளி", "Li");
        translitMap.put("ளீ", "Lii");
        translitMap.put("ளு", "Lu");
        translitMap.put("ளூ", "Luu");
        translitMap.put("ளெ", "Le");
        translitMap.put("ளே", "Lee");
        translitMap.put("ளை", "Lai");
        translitMap.put("ளொ", "Lo");
        translitMap.put("ளோ", "Loo");
        translitMap.put("ளௌ", "Lau");

        translitMap.put("ற்", "R");
        translitMap.put("ற", "Ra");
        translitMap.put("றா", "Raa");
        translitMap.put("றி", "Ri");
        translitMap.put("றீ", "Rii");
        translitMap.put("று", "Ru");
        translitMap.put("றூ", "Ruu");
        translitMap.put("றெ", "Re");
        translitMap.put("றே", "Ree");
        translitMap.put("றை", "Rai");
        translitMap.put("றொ", "Ro");
        translitMap.put("றோ", "Roo");
        translitMap.put("றௌ", "Rau");

        translitMap.put("ன்", "n");
        translitMap.put("ன", "na");
        translitMap.put("னா", "naa");
        translitMap.put("னி", "ni");
        translitMap.put("னீ", "nii");
        translitMap.put("னு", "nu");
        translitMap.put("னூ", "nuu");
        translitMap.put("னெ", "ne");
        translitMap.put("னே", "nee");
        translitMap.put("னை", "nai");
        translitMap.put("னொ", "no");
        translitMap.put("னோ", "noo");
        translitMap.put("னௌ", "nau");

        translitMap.put("ஜ்", "j");
        translitMap.put("ஜ", "ja");
        translitMap.put("ஜா", "jaa");
        translitMap.put("ஜி", "ji");
        translitMap.put("ஜீ", "jii");
        translitMap.put("ஜு", "ju");
        translitMap.put("ஜூ", "ju");
        translitMap.put("ஜெ", "je");
        translitMap.put("ஜே", "jee");
        translitMap.put("ஜை", "jai");
        translitMap.put("ஜொ", "jo");
        translitMap.put("ஜோ", "joo");
        translitMap.put("ஜௌ", "jau");

        translitMap.put("ஶ்", "S-");
        translitMap.put("ஶ", "S-a");
        translitMap.put("ஶா", "S-aa");
        translitMap.put("ஶி", "S-i");
        translitMap.put("ஶீ", "S-ii");
        translitMap.put("ஶு", "S-u");
        translitMap.put("ஶூ", "S-uu");
        translitMap.put("ஶெ", "S-e");
        translitMap.put("ஶே", "S-ee");
        translitMap.put("ஶை", "S-ai");
        translitMap.put("ஶொ", "S-o");
        translitMap.put("ஶோ", "S-oo");
        translitMap.put("ஶௌ", "S-au");

        translitMap.put("ஷ்", "sh");
        translitMap.put("ஷ", "sha");
        translitMap.put("ஷா", "shaa");
        translitMap.put("ஷி", "shi");
        translitMap.put("ஷீ", "shii");
        translitMap.put("ஷு", "shu");
        translitMap.put("ஷூ", "shuu");
        translitMap.put("ஷெ", "she");
        translitMap.put("ஷே", "shee");
        translitMap.put("ஷை", "shai");
        translitMap.put("ஷொ", "sho");
        translitMap.put("ஷோ", "shoo");
        translitMap.put("ஷௌ", "shau");

        translitMap.put("ஸ்", "S");
        translitMap.put("ஸ", "Sa");
        translitMap.put("ஸா", "Saa");
        translitMap.put("ஸி", "Si");
        translitMap.put("ஸீ", "Sii");
        translitMap.put("ஸு", "Su");
        translitMap.put("ஸூ", "Suu");
        translitMap.put("ஸெ", "Se");
        translitMap.put("ஸே", "See");
        translitMap.put("ஸை", "Sai");
        translitMap.put("ஸொ", "So");
        translitMap.put("ஸோ", "Soo");
        translitMap.put("ஸௌ", "Sau");

        translitMap.put("ஹ்", "h");
        translitMap.put("ஹ", "ha");
        translitMap.put("ஹா", "haa");
        translitMap.put("ஹி", "hi");
        translitMap.put("ஹீ", "hii");
        translitMap.put("ஹு", "hu");
        translitMap.put("ஹூ", "huu");
        translitMap.put("ஹெ", "he");
        translitMap.put("ஹே", "hee");
        translitMap.put("ஹை", "hai");
        translitMap.put("ஹொ", "ho");
        translitMap.put("ஹோ", "hoo");
        translitMap.put("ஹௌ", "hau");

        translitMap.put("க்ஷ்", "ksh");
        translitMap.put("க்ஷ", "ksha");
        translitMap.put("க்ஷா", "kshaa");
        translitMap.put("க்ஷி", "kshi");
        translitMap.put("க்ஷீ", "kshii");
        translitMap.put("க்ஷு", "kshu");
        translitMap.put("க்ஷூ", "kshuu");
        translitMap.put("க்ஷெ", "kshe");
        translitMap.put("க்ஷே", "kshee");
        translitMap.put("க்ஷை", "kshai");
        translitMap.put("க்ஷொ", "ksho");
        translitMap.put("க்ஷோ", "kshoo");
        translitMap.put("க்ஷௌ", "kshau");

        translitMap.put("ஸ்ரீ", "sri");
    }


    public static final ArrayMap<String, String> getTamil2LatinMap() {

        return translitMap;
    }

}
