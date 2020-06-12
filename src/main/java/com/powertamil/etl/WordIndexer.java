package com.powertamil.etl;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import com.powertamil.lang.tamil.TCUtils;
import com.powertamil.lang.tamil.TCharacter;
import com.powertamil.lang.tamil.TSUtils;
import com.powertamil.lang.tamil.TString;

public class WordIndexer {

    String fpath = "E:\\files\\words\\";
    String fname1 = "Words-AM-1.txt";

    public LinkedHashSet<String> indexEm(String fname) {
        BufferedReader reader;
        BufferedWriter writer;

        LinkedHashSet<String> set = new LinkedHashSet<String>();
        ArrayList<String> duplicates = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("E:\\files\\words\\Words-" + fname));
            writer = new BufferedWriter(new FileWriter("E:\\files\\words\\" + "Index.txt"));
            String line = reader.readLine();
            while (line != null) {
                String word = line.trim();

                TString ts1 = TSUtils.parse(word);
                TCharacter tc0 = ts1.tcharAt(0);
                TCharacter tc1 = null;
                boolean single = true;
                String entry = "";

                if (ts1.length() >= 2) {
                    single = false;
                }
                if (!single) {
                    tc1 = ts1.tcharAt(1);
                }

                if (TCUtils.isAytham(tc0.charAt(0))) {
                    entry = "ஃ";
                    set.add(entry);
                } else if (TCUtils.isUyir(tc0.charAt(0))) {
                    if (single) {
                        entry = tc0.toString();
                        set.add(entry);
                    } else {
                        entry = tc0.toString() + tc1.toString();
                        set.add(entry);
                    }
                } else if (TCUtils.isAgaram(tc0.charAt(0))) {
                    if (single) {
                        entry = tc0.toString();
                        set.add(entry);
                    } else {
                        entry = tc0.toString() + tc1.toString();
                        set.add(entry);
                    }
                }
                line = reader.readLine();
                writer.write(word + "\r\n");
            }
            reader.close();
            writer.close();
        } catch (IOException _e) {
            _e.printStackTrace();
        }
        return set;
    }


    public static void main(String[] args) {
        WordIndexer wi = new WordIndexer();
        BufferedWriter writer;

        LinkedHashSet<String> finalset = new LinkedHashSet<>();

        for (int i = 1; i <= 108; i++) {
            LinkedHashSet hs = wi.indexEm("AM-" + i + ".txt");
            System.out.println("=======================\n\n\n" + hs);
            System.out.println(hs.size());
            finalset.addAll(hs);
        }

        try {
            writer = new BufferedWriter(new FileWriter("E:\\files\\words\\" + "index.txt"));

            for (String s : finalset) {
                //System.out.print(s + " ");
                writer.write(s + "\r\n");
            }
            writer.close();
        } catch (IOException _ee) {
            _ee.printStackTrace();
        }

    }

}
