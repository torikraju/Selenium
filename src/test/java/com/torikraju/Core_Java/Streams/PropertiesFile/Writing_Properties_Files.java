package com.torikraju.Core_Java.Streams.PropertiesFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writing_Properties_Files {

    private String location;
    private Properties properties;
    private FileOutputStream outputStream;


    @Before
    public void setUp() throws FileNotFoundException {
        location = "resources/Files/Default.properties";
        properties = new Properties();
        outputStream = new FileOutputStream(location, true);
    }


    @Test
    public void writing_to_propertiesFile() throws IOException {
        properties.setProperty("WriteProperty1", "WriteProperty1_value_1");
        properties.setProperty("WriteProperty2", "WriteProperty1_value_2");
        properties.setProperty("WriteProperty3", "WriteProperty1_value_3");
        properties.store(outputStream, "Writing form java program");
        System.out.println("properties file updated Successfully!!");
    }

    @Test
    public void update_propertiesFile() throws IOException {


    }


    @After
    public void closeFile() throws IOException {
        outputStream.close();
    }


}
