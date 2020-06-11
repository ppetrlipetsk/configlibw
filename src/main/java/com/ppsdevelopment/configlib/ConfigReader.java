package com.ppsdevelopment.configlib;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties property = new Properties();


    public static boolean readConfig(String fileName) {
        boolean result=true;
        try {
            readConfig(fileName,false);
        } catch (IOException e) {
            result=false;
        }

        return result;
    }

    public static boolean readConfig(String fileName, boolean exceptions) throws IOException {
        boolean result=true;
        try {
            property.load(new FileInputStream(fileName));
        } catch (IOException e) {
            result=false;
            if (exceptions) throw e;
        }
        return result;
    }

    public static String getPropertyValue(String propName){
        return property.getProperty(propName);
    }
}
