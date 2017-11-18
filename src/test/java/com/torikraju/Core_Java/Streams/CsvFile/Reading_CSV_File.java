package com.torikraju.Core_Java.Streams.CsvFile;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reading_CSV_File {


    private String location;

    @Before
    public void setUp() throws IOException {
        location = "resources/Files/Select.csv";
    }


    @Test
    public void writing_to_TxtFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get(location));
        List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        values.forEach(value -> System.out.println(value));
        lines.close();
    }


}
