/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 1.0
 * @since 01-06-2018
 */
package com.powertamil.lang.tamil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TString implements Serializable {

    private static final long serialVersionUID = 1L;
    ArrayList<TCharacter> tstringContents = new ArrayList<TCharacter>();
    //NULL_STRING checks
    private static final Predicate<String> NS_PREDICATE = Objects::isNull;
    private static final Supplier<String> NS_SUPPLIER = () -> "'value' must not be null!!";

    /**
     * Cache the hash code for the string
     */
    private int hash; // Default to 0

    /**
     * Constructs a newly allocated {@code TamilString} object.
     *
     * @param tcarray the value to be represented by the {@code Character} object.
     */
    public TString(TCharacter[] tcarray) {
        for (int i = 0; i < tcarray.length; i++) {
            tstringContents.add(tcarray[i]);
        }
        this.hashCode();
    }

    /**
     * Constructs a newly allocated {@code TamilString} object.
     *
     * @param tcList the value to be represented by the {@code Character} object.
     */
    public TString(List<TCharacter> tcList) {
        for (int i = 0; i < tcList.size(); i++) {
            tstringContents.add(tcList.get(i));
        }
        this.hashCode();
    }

    /**
     * Constructs a newly allocated {@code TamilString} object.
     *
     * @param tstring Another TamilString object.
     */
    public TString(TString tstring) {
        this.tstringContents = tstring.tstringContents;
        this.hash = tstring.hash;
    }

    /**
     * Constructs a newly allocated {@code TamilString} object.
     */
    public TString() {

    }

    /**
     * Returns a view of the portion of this TamilString between the specified
     * {@code startIndex}, inclusive, till the end.
     *
     * @param startIndex The starting index
     * @return Returns the substring.
     */
    public TString subString(int startIndex) {
        return subString(startIndex, this.length());
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code start}, inclusive, and {@code fin}, exclusive.
     *
     * @param start the start index
     * @param fin   the end
     * @return Returns the substring.
     */
    public TString subString(int start, int fin) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (fin > this.length()) {
            throw new StringIndexOutOfBoundsException(fin);
        }
        if ((start == 0) && (fin == this.length())) {
            return this;
        }
        List<TCharacter> templist = tstringContents.subList(start, fin);
        TString ts = new TString(templist);
        return ts;
    }

    /**
     * Inserts the specified element at the very end of this TamilString.
     *
     * @param str TamilString to be concatenated.
     * @return TamilString object
     */
    public TString concat(TString str) {
        int otherLen = str.length();
        if (otherLen == 0) {
            return this;
        }
        TString buf = new TString(this);
        for (int i = 0; i < str.length(); i++) {
            buf.add(str.tcharAt(i));
        }
        return buf;
    }

    /**
     * Returns the values from each provided TStrings combined into a single TString.
     *
     * @param strings zero or more {@code TString} Tamil Strings
     * @return a single TString containing all the values from the source TStrings, in order
     */
    public static TString chain(TString... strings) {
        TString result = new TString();
        int pos = 0;
        for (TString ts : strings) {
            result.concat(ts);
        }
        return result;
    }


    /**
     * Compares this string to the specified object. The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * TamilString} object that represents the same sequence of characters as this
     * object.
     *
     * @param anObject The object to compare this {@code TamilString} against.
     * @return {@code true} if the given object represents a {@code TamilString}
     * equivalent to this string, {@code false} otherwise.
     */
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof TString) {
            TString anotherString = (TString) anObject;
            int n = this.length();
            if (n == anotherString.length()) {
                ArrayList<TCharacter> v1 = this.tstringContents;
                ArrayList<TCharacter> v2 = anotherString.tstringContents;
                int i = 0;
                while (n-- != 0) {
                    if (!(v1.get(i).toString()).equals(v2.get(i).toString())) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a TamilCharacter object to the end of the TamilString
     *
     * @param tchar TamilCharacter to be added to the end.
     */
    private void add(TCharacter tchar) {
        tstringContents.add(tchar);
    }

    /**
     * Returns a string resulting from replacing all occurrences of {@code oldTC} in
     * this string with {@code newTC}.
     *
     * @param oldTC the old TamilCharacter.
     * @param newTC the new TamilCharacter.
     * @return a string derived from this string by replacing every occurrence of
     * {@code oldTC} with {@code newTC}.
     */
    public TString replace(TCharacter oldTC, TCharacter newTC) {
        List<TCharacter> templist = tstringContents;
        int removecount = 0;
        for (int i = 0; i < this.length(); i++) {
            TCharacter _tc = templist.get(i);
            if (_tc.toString().equals(oldTC.toString())) {
                templist.remove(i);
                removecount++;
            }
        }
        if (removecount != 0) {
            TString ts = new TString(templist);
            return ts;
        }
        return this;
    }

    /**
     * Add a more descriptive documentation later.
     *
     * @param csq any charsequence to be appended
     * @return TString
     */
    public TString append(CharSequence csq) {
        if (csq == null) {
            throw new NullPointerException("Argument null at TamilString.append()...!" + csq);
        }
        return this.append(csq);
    }

    /**
     * Returns the length of this TamilString. The length is equal to the number of
     * {@code TamilCharacter} units in this string.
     *
     * @return the length of the sequence of TamilCharacters in this object.
     */
    public int length() {
        return tstringContents.size();
    }


    public boolean isEmpty() {
        if (tstringContents.size() != 0) {
            return false;
        }
        return true;
    }

    /**
     * Returns the char value at the specified index. An index ranges from zero to
     * length() - 1. The first char value of the sequence is at index zero, the next
     * at index one, and so on, as for array indexing.
     *
     * @param index the index specified
     * @return an integer
     */
    public TCharacter tcharAt(int index) {
        if (index > this.length()) {
            throw new IndexOutOfBoundsException("Index is beyond String size...!" + index);
        }
        //ArrayList Index starts from 0.
        return this.tstringContents.get(index);
    }


    /**
     * Tests if this TamilString starts with the specified prefix.
     *
     * @param prefix the prefix.
     * @return {@code true} if the character sequence represented by the argument is
     * a prefix of the character sequence represented by this string;
     * {@code false} otherwise. Note also that {@code true} will be returned
     * if the argument is an empty string or is equal to this {@code String}
     * object as determined by the {@link #equals(Object)} method.
     */
    public boolean startsWith(String prefix) {
        validate(prefix, NS_PREDICATE, NS_SUPPLIER);
        return this.toString().startsWith(prefix);
    }

    /**
     * Tests if this TamilString ends with the specified suffix.
     *
     * @param suffix the suffix.
     * @return {@code true} if the character sequence represented by the argument is
     * a suffix of the character sequence represented by this object;
     * {@code false} otherwise. Note that the result will be {@code true} if
     * the argument is the empty string or is equal to this {@code String}
     * object as determined by the {@link #equals(Object)} method.
     */
    public boolean endsWith(String suffix) {
        validate(suffix, NS_PREDICATE, NS_SUPPLIER);
        return this.toString().startsWith(suffix, this.length() - suffix.length());
    }

    /**
     * Validator for NULL
     *
     * @param value     Value that must be checked for Nulls.
     * @param predicate Condition that is checked for.
     * @param supplier  Represents a supplier of results.
     */
    private static void validate(String value, Predicate<String> predicate, final Supplier<String> supplier) {
        if (predicate.test(value)) {
            throw new IllegalArgumentException(supplier.get());
        }
    }

    /**
     * Returns a hash code for this TamilString. The hash code for a
     * {@code TamilString} object is computed as <blockquote>
     * <pre>
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * </pre>
     * </blockquote> using {@code int} arithmetic, where {@code s[i]} is the
     * <i>i</i>th character of the string, {@code n} is the length of the string,
     * and {@code ^} indicates exponentiation. (The hash value of the empty string
     * is zero.)
     *
     * @return a hash code value for this object.
     */
    public int hashCode() {
        int h = hash;
        if (h == 0 && tstringContents.size() > 0) {

            for (int i = 0; i < tstringContents.size(); i++) {
                TCharacter tc = this.tcharAt(i);
                h = 31 * h + tc.LEX_ORDER;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tstringContents.size(); i++) {
            sb.append(tstringContents.get(i).toString());
        }
        return sb.toString();
    }
}