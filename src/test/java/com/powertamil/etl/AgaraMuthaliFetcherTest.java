package com.powertamil.etl;


import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgaraMuthaliFetcherTest {

    @Test
    void downloadAndUnzip() {
        try {
            AgaraMuthaliFetcher.downloadAndUnzip();
        } catch (IOException _ioe) {
            _ioe.printStackTrace();
        }
        File path = AgaraMuthaliFetcher.getDataPath();
        assertTrue(path.isDirectory());
    }
}