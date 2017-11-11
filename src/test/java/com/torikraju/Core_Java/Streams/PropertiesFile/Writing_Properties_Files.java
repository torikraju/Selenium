package com.torikraju.Core_Java.Streams.PropertiesFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class Writing_Properties_Files {

    private String location;
    private Properties properties;
    private FileOutputStream outputStream;
    private File file;


    @Before
    public void setUp() throws FileNotFoundException {
        location = "resources/Files/Default.properties";
        properties = new Properties();
        outputStream = new FileOutputStream(location, true);
        file = new File(location);
    }


    @Test
    public void writing_to_propertiesFile() throws IOException {

        if (!file.exists()) {
            //creating a new file if file not exists
            PrintWriter writer = new PrintWriter(location, "UTF-8");
            writer.close();
        }

        properties.setProperty("WriteProperty1", "WriteProperty1_value_1");
        properties.setProperty("WriteProperty2", "WriteProperty1_value_2");
        properties.setProperty("WriteProperty3", "WriteProperty1_value_3");
        properties.store(outputStream, null);
        System.out.println("properties file updated Successfully!!");
    }



    @After
    public void closeFile() throws IOException {
        outputStream.close();
    }


}
