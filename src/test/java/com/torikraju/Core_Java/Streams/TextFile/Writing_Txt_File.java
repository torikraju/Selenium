package com.torikraju.Core_Java.Streams.TextFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Random;

public class Writing_Txt_File {

    private String location;
    private File file;
    private  FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private Random rand;


    @Before
    public void setUp() throws IOException {
        location = "resources/Files/Default.txt";
        file = new File(location);
        fileWriter = new FileWriter(file, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        rand = new Random();
    }


    @Test
    public void writing_to_TxtFile() throws IOException {

        if (!file.exists()) {
            //creating a new file if file not exists
            PrintWriter writer = new PrintWriter(location, "UTF-8");
            writer.close();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                int num = rand.nextInt(89) + 10;//range between 10 and 99.
                bufferedWriter.write(num + "\t");
            }
            bufferedWriter.newLine();
        }
    }


    @After
    public void closeFile() throws IOException {
        bufferedWriter.close();
        fileWriter.close();
    }

}
