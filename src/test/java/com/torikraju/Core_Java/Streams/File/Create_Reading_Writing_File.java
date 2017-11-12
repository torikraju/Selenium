package com.torikraju.Core_Java.Streams.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class Create_Reading_Writing_File {


    private String location;
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;


    @Before
    public void setUp() throws IOException {
        location = "resources/Files/CreateReadWrite.txt";
        file = new File(location);
        fileWriter = new FileWriter(location, true);
        bufferedWriter = new BufferedWriter(fileWriter);
        fileReader = new FileReader(location);
        bufferedReader = new BufferedReader(fileReader);
    }


    @Test
    public void writing_to_TxtFile() throws IOException {

        if (!file.exists()) {
            //creating a new file
            file.createNewFile();
        }
        //write to a file Sorting
/*      bufferedWriter.write("This is a Line");
        bufferedWriter.newLine();
        bufferedWriter.write("This is another line");*/

        //write to a file ending

        //read file start
        //reading first line of the file
        //System.out.println(bufferedReader.readLine());
        //reading the very next line
        //System.out.println(bufferedReader.readLine());

        //rading hole file
        String i = "";
        while ((i = bufferedReader.readLine()) != null) {
            System.out.println(i);
        }
        //end of reading file...

    }

    @After
    public void closeFile() throws IOException {
        bufferedWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }


}
