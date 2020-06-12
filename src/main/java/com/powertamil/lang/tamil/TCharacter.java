/*
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since   26-05-2018
 */
package com.powertamil.lang.tamil;

import java.util.Comparator;
import java.util.logging.Logger;

public class TCharacter implements java.io.Serializable, CharSequence, Comparable<String> {

    protected static final Logger LOG = Logger.getLogger(TCharacter.class.getName());

    private static final long serialVersionUID = 1L;
    public static final int MAX_LEGAL_SIZE = 4;
    public int LEX_ORDER = 0;
    public boolean SAME_AS_ASCII = false;

    private char[] charContents = null;

    /**
     * Cache the hash code for the string
     */
    private int hash; // Default to 0

    /**
     * Constructs a newly allocated {@code Character} object that represents the
     * specified {@code char} value. NOTE : A Code Unit is the number of bits an
     * encoding uses. So UTF-8 and UTF-16 would use 8 and 16 bit code units. A Code
     * Point is a Character and represented by one or more Code Units depending on
     * the encoding.
     * <p>
     * Currently allows USACII chars as well in a Tamil Character object.
     *
     * @param cp1 Code point to be represented by the {@code TCharacter} object.
     */
    public TCharacter(char cp1) {
        char[] tarry = new char[]{cp1};
        doTCharacter(tarry);
    }

    /**
     * Holds only the single code point Tamil character and disallows ASCII.
     *
     * @param cp1           Code Point
     * @param strictlyTamil true refuses USASCII chars and false makes it null.
     */
    public TCharacter(char cp1, boolean strictlyTamil) {
        if (!(2944 < cp1 && cp1 < 3071)) {
            throw new IllegalArgumentException("Input Code Point is Not Tamil...!");
        } else {
            char[] tarry = new char[]{cp1};
            doTCharacter(tarry);
        }
    }

    public TCharacter(char cp1, char cp2) {
        char[] tarry = new char[]{cp1, cp2};
        doTCharacter(tarry);
    }

    public TCharacter(char cp1, char cp2, char cp3) {
        char[] tarry = new char[]{cp1, cp2, cp3};
        doTCharacter(tarry);
    }

    public TCharacter(char cp1, char cp2, char cp3, char cp4) {
        char[] tarry = new char[]{cp1, cp2, cp3, cp4};
        doTCharacter(tarry);
    }

    /**
     * @param carray charArray with one valid Tamil Character
     * @throws IllegalArgumentException An Illegal or Inappropriate Argument
     */
    public TCharacter(char[] carray) throws IllegalArgumentException {

        int arrSize = carray.length;
        if (arrSize > 4 || arrSize < 0)
            throw new IllegalArgumentException("\n String too big or too small to form a valid Tamil character!");

        doTCharacter(carray);
    }

    /**
     * Internal private method to construct the Tamil Character.
     *
     * @param carray char array with code points
     */
    private void doTCharacter(char[] carray) {
        boolean isValid = false;
        int tcharlen = carray.length;
        if (tcharlen == 4) {
            if (TCUtils.isKshaUyirMei(carray[0], carray[1], carray[2], carray[3])) {
                isValid = true;
            } else if (TCUtils.isSriChar(carray[0], carray[1], carray[2], carray[3])) {
                isValid = true;
            }
            if (isValid) {
                charContents = new char[4];
                charContents[0] = carray[0];
                charContents[1] = carray[1];
                charContents[2] = carray[2];
                charContents[3] = carray[3];
                LEX_ORDER = UTF8.getAllTamilList().indexOf(this.toString());
            }
        } else if (tcharlen == 3) {
            if (TCUtils.isKshaChar(carray[0], carray[1], carray[2])) {
                isValid = true;
            }
            if (isValid) {
                charContents = new char[3];
                charContents[0] = carray[0];
                charContents[1] = carray[1];
                charContents[2] = carray[2];
                LEX_ORDER = UTF8.getAllTamilList().indexOf(this.toString());
            }
        } else if (tcharlen == 2) {
            if (TCUtils.isUyirMei(carray[0], carray[1]) || TCUtils.isGranthaUyirMei(carray[0], carray[1])) {
                isValid = true;
            }
            if (isValid) {
                charContents = new char[2];
                charContents[0] = carray[0];
                charContents[1] = carray[1];
                LEX_ORDER = UTF8.getAllTamilList().indexOf(this.toString());
            }
        } else if (tcharlen == 1) {
            if (carray[0] < 0xFF) {
                charContents = new char[1];
                charContents[0] = carray[0];
                LEX_ORDER = (int) carray[0];
                SAME_AS_ASCII = true;
            } else if (TCUtils.isUyir(carray[0]) || TCUtils.isAgaram(carray[0]) || TCUtils.isGranthaAgaram(carray[0]) ||
                    TCUtils.isTNumber(carray[0]) || TCUtils.isTSymbol(carray[0])) {
                isValid = true;
            }
            if (isValid) {
                charContents = new char[1];
                charContents[0] = carray[0];
                LEX_ORDER = UTF8.getAllTamilList().indexOf(this.toString());
            }
        }
    }

    /**
     * Check for a valid Tamil Character
     *
     * @param anyTamilChar Character
     * @return true if input Character is valid Tamil Character
     */
    public static boolean isValidTamilCharacter(Character anyTamilChar) {
        final int intVal = Character.getNumericValue(anyTamilChar);
        return (2944 < intVal && intVal < 3071);
    }

    @Override
    public int length() {
        if (charContents == null) {
            throw new NullPointerException("Tamil Character " + this.hashCode() + "found to be EMPTY!");
        }
        return charContents.length;
    }

    @Override
    public char charAt(int index) {
        if (index > MAX_LEGAL_SIZE || MAX_LEGAL_SIZE < this.length()) {
            throw new IndexOutOfBoundsException("Accessing array over the index at (" + index + ")");
        }
        return charContents[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    /**
     * TamilCharacter Comparator.
     */
    public static Comparator<TCharacter> LEX_CHAR_COMPARE = new Comparator<TCharacter>() {

        /**
         * Compares two strings lexicographically. The comparison is not based on the
         * Unicode value of each character in the Composite Character as it is not
         * possible. So a index of each character in a lexicographically sorted array is
         * used instead. The character sequence represented by this {@code String}
         * object is compared lexicographically to the character sequence represented by
         * the argument string.
         *
         * @param onetc
         *            the {@code String} to be compared against.
         * @param othertc
         *            the {@code String} to be compared.
         * @return the value {@code 0} :: if the "onetc" is equal to "othertc" a value
         *         less than {@code 0} :: if onetc is lexicographically less than
         *         othertc; and a value greater than {@code 0} :: if onetc is
         *         lexicographically greater than othertc.
         */
        public int compare(TCharacter onetc, TCharacter othertc) {

            int diff = 0;
            int len = Math.min(onetc.length(), othertc.length()); // lesser of 2 strings to reduce comparisons
            int o1, o2;
            if (onetc != null && othertc != null) {
                for (int i = 0; i < len; i++) {
                    o1 = find(onetc); // get indexes of chars in o1 and o2
                    o2 = find(othertc);
                    diff = o1 - o2; // calculate distance
                    // break if even one constituent char of a composite char differs.
                    if (diff != 0) {
                        break;
                    }
                }
            }
            return diff;
        }
    };

    /**
     * function to find the index of an element in an object array in Java
     *
     * @param target looking for this TamilCharacter
     * @return index - if match found for the character else return -1;
     */
    public static int find(TCharacter target) {
        TCharacter[] tcarr = UTF8.getAllUTFTC();
        if (target != null) {
            for (int i = 0; i < tcarr.length; i++) {
                if (target.equals(tcarr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Compares this string to the specified TamilCharacter. The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * TamilCharacter} object that represents the same sequence of CodePoints as
     * this object.
     *
     * @param obj The object to compare this {@code String} against
     * @return {@code true} if the given object represents a {@code TamilCharacter}
     * equivalent to this TamilCharacter, {@code false} otherwise
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TCharacter)) {
            TCharacter aTC = (TCharacter) obj;
            int count = this.length();
            // Constituent chars equivalence is checked here with their Unicode value.
            if (count == aTC.length()) {
                char[] v1 = this.charContents;
                char[] v2 = aTC.charContents;
                int i = 0;
                while (count-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a hash code for this Character. The hash code for a
     * {@code TamilCharacter} object is computed as <blockquote>
     *
     * <pre>
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * </pre>
     *
     * </blockquote> using {@code int} arithmetic, where {@code s[i]} is the
     * <i>i</i>th character of the TamilCharacter, {@code n} is the length of the
     * TamilCharacter, and {@code ^} indicates exponentiation. (The hash value of
     * the empty TamilCharacter is zero.)
     *
     * @return a hash code value for this object.
     */
    public int hashCode() {
        int h = hash;
        if (h == 0 && this.length() > 0) {
            char[] val = charContents;
            for (int i = 0; i < this.length(); i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

    /**
     * This object contents in String form is returned.
     *
     * @return A String.
     */
    public String toString() {
        StringBuffer tcbuf = new StringBuffer();
        for (int i = 0; i < charContents.length; i++) {
            tcbuf.append(charContents[i]);
        }
        return String.valueOf(tcbuf);
    }

    @Override
    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
