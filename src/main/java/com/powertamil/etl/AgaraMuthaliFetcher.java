/**
 * @author  Rajkumar Palani {@link "www.rajkumarpalani.com"}
 * @version 0.1
 * @since   27-03-2019
 */

package com.powertamil.etl;

import org.apache.commons.io.FileUtils;
import com.powertamil.util.ArchiveUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class AgaraMuthaliFetcher {
    /**
     * About:
     * This class Fetches the AgaraMuthali Data available in a Zip file at the URL :
     * http://www.rajkumarpalani.com/porul/data/AgaraMuthaliData.zip
     * copies it to the the FILES_ROOT and unzips it to AM_ROOT.
     */

    protected static final Logger log = LoggerFactory.getLogger(AgaraMuthaliFetcher.class);
    protected static final String FILES_ROOT = "E:\\files";
    protected static final String AM_ROOT;

    static {
        AM_ROOT = FILES_ROOT + File.separator + "AM-Root" + File.separator;
    }

    public static File getDataPath() {
        File DataPath = new File(AM_ROOT);
        return DataPath;
    }

    /**
     * Downloads and unzips the Dataset from S3
     *
     * @return null
     * @throws IOException
     */
    public static File downloadAndUnzip() throws IOException {
        File rootDir = new File(AM_ROOT);
        if (rootDir.exists()) {
            throw new IOException("Remove existing directory : " + AM_ROOT);
        } else {
            rootDir.mkdir();
            log.info("Downloading Agara Muthali Data file...");

            // Download Agara Muthali Dataset file from AWS S3
            File zipFile = new File(FILES_ROOT, "AgaraMuthaliData.zip");
            if (!zipFile.isFile()) {
                FileUtils.copyURLToFile(
                        new URL("http://www.rajkumarpalani.com/porul/data/AgaraMuthaliData.zip"), zipFile);
            }
            ArchiveUtils.unzipFileTo(zipFile.getAbsolutePath(), rootDir.getAbsolutePath());
        }
        return null;
    }
}