package com.torikraju.Core_Java.Streams.TextFile;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reading_Txt_File {


    private String location;

    @Before
    public void setUp() throws IOException {
        location = "resources/Files/Default.txt";
    }


    @Test
    public void writing_to_TxtFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(location));
        lines.forEach(System.out::println);
        lines.close();
    }


}
