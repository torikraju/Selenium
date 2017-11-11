package com.torikraju.Core_Java.Streams.PropertiesFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Reading_Properties_Files {

    private String location;
    private Properties properties;
    private FileInputStream inputStream;

    @Before
    public void setUp() throws FileNotFoundException {
        location = "resources/Files/Default.properties";
        properties = new Properties();
        inputStream = new FileInputStream(location);
    }

    @Test
    public void reading_single_element() throws IOException {
        properties.load(inputStream);
        System.out.println(properties.getProperty("email"));
    }

    @Test
    public void reading_all_element() throws IOException {
        properties.load(inputStream);
        Set<Object> objects = properties.keySet();

        for (Object o : objects) {
            String key = (String) o;
            System.out.println(key + "=" + properties.getProperty(key));
        }
    }

    @After
    public void closeFile() throws IOException {
        inputStream.close();
    }


}
