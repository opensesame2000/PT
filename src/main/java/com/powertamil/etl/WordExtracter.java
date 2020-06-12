/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since 23-03-2019
 */
package com.powertamil.etl;

import com.powertamil.collections.ArrayMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;
import java.util.ArrayList;


public class WordExtracter {

    private ArrayMap<String, HashSet<String>> extractWords(String fileName) {
        BufferedReader reader;
        BufferedWriter writer;
        HashSet<String> wordSet = new HashSet<String>();
        HashSet<String> duplicates = new HashSet<>();
        try {
            reader = new BufferedReader(new FileReader("E:\\files\\AM-Root\\" + fileName));
            writer = new BufferedWriter(new FileWriter("E:\\files\\words\\" + "Words-" + fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] dataArray = line.split("\t");
                String word = dataArray[0].trim();

                if (wordSet.add(word)) {

                } else {
                    duplicates.add(word);
                }
                line = reader.readLine();
                writer.write(word + "\r\n");
            }
            reader.close();
            writer.close();
        } catch (IOException _e) {
            _e.printStackTrace();
        }

        ArrayMap<String, HashSet<String>> resMap = new ArrayMap<>();

        System.out.println("WordSet size::" + wordSet.size());
        resMap.put("WORDS", wordSet);
        resMap.put("DUPLICATES", duplicates);

        return resMap;
    }


    public static ArrayMap<String, List<String>> getWordsDuplicates() {
        WordExtracter we = new WordExtracter();
        BufferedWriter writer;

        ArrayList<String> dList1 = new ArrayList<String>();
        ArrayList<String> wList1 = new ArrayList<String>();

        for (int i = 1; i <= 108; i++) {

            ArrayMap<String, HashSet<String>> resmap = we.extractWords("AM-" + i + ".txt");
            //Add the HashSet to List
            wList1.addAll(resmap.get("WORDS"));
            dList1.addAll(resmap.get("DUPLICATES"));
        }

        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("E:\\files\\words\\" + "Words-All.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("E:\\files\\words\\" + "Words-Duplicates.txt"));
            //Printing Words without Duplicates
            for (String s : wList1) {
                //System.out.print(s + " ");
                writer1.write(s + "\r\n");
            }
            for (String s : dList1) {
                //System.out.print(s + " ");
                writer2.write(s + "\r\n");
            }
            writer1.close();
            writer2.close();
        } catch (IOException _ee) {
            _ee.printStackTrace();
        }

        System.out.println("WLIST SIZE ::" + wList1.size());
        System.out.println("DLIST SIZE ::" + dList1.size());

        ArrayMap<String, List<String>> resMap = new ArrayMap<>();

        resMap.put("WORDS", wList1);
        resMap.put("DUPLICATES", dList1);

        return resMap;
    }

}
