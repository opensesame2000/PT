/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since 27-Sep-2013
 */
package com.powertamil.dictionary;

import java.util.ArrayList;
import java.util.List;

public class WordMeaning {
    private String wordName;
    private List<String> meaningList = new ArrayList<String>();
    private String createdTime;
    private String updatedTime;
    private int ptId;
    private int muthaliId;

    //Constructors
    public WordMeaning(String wordName) {
        this.wordName = wordName;
    }

    public WordMeaning(String wordName, List<String> meaningList) {
        super();
        this.wordName = wordName;
        this.meaningList = meaningList;
    }

    //Accessors and Mutators
    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public List<String> getMeaningList() {
        return meaningList;
    }

    public void setMeaningList(List<String> meaningList) {
        this.meaningList = meaningList;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public int getMuthaliId() {
        return muthaliId;
    }

    public void setMuthaliId(int muthaliId) {
        this.muthaliId = muthaliId;
    }

    //toString()
    @Override
    public String toString() {
        return "WordMeaning [wordName=" + wordName + ", meaningList=" + meaningList + "]";
    }
}

