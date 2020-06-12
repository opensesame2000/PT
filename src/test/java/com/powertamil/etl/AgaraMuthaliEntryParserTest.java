package com.powertamil.etl;

import java.io.*;
import java.util.*;

import com.powertamil.dictionary.WordMeaning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgaraMuthaliEntryParserTest {

    @Test
    void parseAllAgaraMuthaliFiles() {
        String dataSetPath = "E:\\files\\AM-Root\\";
        AgaraMuthaliEntryParser ameparse = new AgaraMuthaliEntryParser();
        Map<String, WordMeaning> wmtot = ameparse.parseAllAgaraMuthaliFiles(dataSetPath);

        assertTrue(wmtot.size() == 63743);// should be 64,048
    }

    //@Test
    void readWordDefinitions() {
        String dataSetPath = "E:\\files\\AM-Root\\AM-1.txt";
        AgaraMuthaliEntryParser ameparse = new AgaraMuthaliEntryParser();
        try {
            InputStream astream = new FileInputStream(dataSetPath);
            TreeMap<String, WordMeaning> wma = ameparse.readWordDefinitions(astream, "utf8");

            //System.out.println("inside Test :: wma size:: "+wma.size());
            assertTrue(wma.size() == 4680);// File AM-1.txt should have 4678 words with meanings.
        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }
}