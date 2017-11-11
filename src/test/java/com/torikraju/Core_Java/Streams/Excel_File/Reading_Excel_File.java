package com.torikraju.Core_Java.Streams.Excel_File;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Reading_Excel_File {


    private String location;
    private File file;
    private FileInputStream inputStream;
    private Workbook workbook;


    @Before
    public void setUp() throws IOException, InvalidFormatException {
        location = "resources/Files/Default.xlsx";
        file = new File(location);
        inputStream = new FileInputStream(file);
        workbook = WorkbookFactory.create(inputStream);

    }


    @Test
    public void writing_to_Excel_File() throws IOException {

        //How to get a cell value
        Sheet sheet = workbook.getSheetAt(0);

/*      Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);*/

        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    @After
    public void closeFile() throws IOException {
        inputStream.close();
    }
}
