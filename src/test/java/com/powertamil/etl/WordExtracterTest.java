package com.powertamil.etl;

import com.powertamil.collections.ArrayMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordExtracterTest {

    @Test
    void getWordsDuplicates() {

        ArrayMap<String, List<String>> result = WordExtracter.getWordsDuplicates();

        assertTrue((result.get("WORDS")).size() == 63589);
        assertTrue((result.get("DUPLICATES")).size() == 151);
    }
}