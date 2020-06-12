package com.powertamil.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveUtilsTest {
    String srcpath = "E:\\temp\\AMdata\\AgaraMuthaliData.zip";
    String destpath = "E:\\temp\\AMdata\\";

    @Test
    void unzipFileTo() {
        try {
            ArchiveUtils.unzipFileTo(srcpath, destpath);

            System.out.println("unzipped successfully...!");


        } catch (Exception _ee) {
            _ee.printStackTrace();
        }

    }
}