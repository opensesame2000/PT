package com.powertamil.log;

import java.io.IOException;

import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

public class PTLogger {

    private static Logger LOG;
    //NOTE: make sure logging.properties is in classpath. aka resources folder in intelliJ project
    static {
        InputStream stream = PTLogger.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            //LOG.addHandler(new FileHandler("PowerTamil.log"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //must initialize loggers after setting above property
        LOG = Logger.getLogger(PTLogger.class.getName());
    }

    public static void main(String[] args) throws SecurityException, IOException {

        String str = new String("ராஜ்குமார்");
        // Encode data on your side using BASE64
        String encoded = Base64.getEncoder().withoutPadding().encodeToString(str.getBytes());
        System.out.println("encoded value is " + new String(encoded));

        // Decode data on other side, by processing encoded data
        byte[] valueDecoded = Base64.getDecoder().decode(encoded);
        System.out.println("Decoded value is " + new String(valueDecoded));



        System.out.println("-- main method starts --");
        LOG.info("an info msg");
        LOG.warning("a warning msg");
        LOG.severe("a severe msg");
        LOG.info("Logger Name: "+LOG.getName());

        //An array of size 3
        int []a = {1,2,3};
        int index = 4;
        LOG.config("index is set to "+index);

        try{
            System.out.println(a[index]);
        }catch(ArrayIndexOutOfBoundsException ex){
            LOG.log(Level.SEVERE, "Exception occurred...!", ex);
        }
    }
}
