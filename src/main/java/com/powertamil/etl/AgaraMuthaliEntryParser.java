/**
 * @author Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since 27-03-2019
 */


/**
 * Refactor to return HashMap<List<String>, List<WordMeaning>> instead of Treemaps
 */
package com.powertamil.etl;

import java.util.*;
import java.io.*;

import com.powertamil.dictionary.WordMeaning;

public class AgaraMuthaliEntryParser implements DictionaryEntryParser {

    private static final char COMMA = ',';
    private static final char SEMICOLON = ';';
    private static final String TAB = "\t";

    public TreeMap<String, WordMeaning> parseAllAgaraMuthaliFiles(String workingdir) {
        File[] files = new File(workingdir).listFiles((dir, name) -> name.endsWith(".txt"));
        System.out.println(files.length);

        assert files.length == 109;

        TreeMap<String, WordMeaning> wmtotal = new TreeMap<>();
        TreeMap<String, WordMeaning> wmMap = null;

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Processing File:: "+ file.getName());
                try {
                    InputStream fstream = new FileInputStream(workingdir + file.getName());
                    wmMap = readWordDefinitions(fstream, "utf8");

                } catch (IOException _ioe) {
                    _ioe.printStackTrace();
                }
                wmtotal.putAll(wmMap);
            }
        }
        System.out.println("wmarrtotal:: " + wmtotal.size());
        return wmtotal;
    }


    //Parse All meanings for one file.
    TreeMap<String, WordMeaning> readWordDefinitions(InputStream stream, String encoding) throws IOException {
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(stream, encoding));
        String line = null;
        TreeMap<String, WordMeaning> wmMap = new TreeMap<>();
        WordMeaning wm = null;
        int count =0;
        while ((line = reader.readLine()) != null) {

            wm = parseLine(line);
            count++;
            if(wmMap.containsKey(wm.getWordName())  ){
                System.out.println("DUPLICATE FOUND...:: " + wm.getWordName());
                wmMap.put(wm.getWordName()+"-1", wm);
            }
            wmMap.put(wm.getWordName(), wm);
        }
        //System.err.println("Count:: "+count + " one file treeMapsize::"+wmMap.size());
        return wmMap;
    }

    /**
     * Parse TSV line
     *
     * @param line line to parse
     * @return String array of parsed valued, null
     * @throws RuntimeException on malformed input
     */
    private WordMeaning parseLine(String line) {
        String[] values = line.split("\\t");

        if (values.length != 2) {
            System.err.println("More than two tabs found in ::\n" + line);
        }
        assert values.length == 2;

        WordMeaning wm = new WordMeaning(values[0].trim());
        List<String> meaningsList = getMeanings(values);

        if (meaningsList.size() == 0) {
            throw new RuntimeException("Meanings missing in entry: " + line);
        }
        wm.setMeaningList(meaningsList);

        return wm;
    }


    private List<String> getMeanings(String[] parts) {
        List<String> result = new ArrayList<>();
        int meaningsCount = 0;
        String meaningSeq = parts[1];

        for (int i = 0; i < meaningSeq.length(); i++) {
            if (meaningSeq.indexOf(SEMICOLON) >= 1) {
                String[] m1 = meaningSeq.split(";");
                for (int j = 0; j < m1.length; j++) {
                    result.add(m1[j]);
                }
            } else {
                result.add(meaningSeq);
            }
        }
        return result;
    }

}
