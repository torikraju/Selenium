package com.torikraju.Core_Java.Streams.Excel_File;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Excel_Reader_Test {


    private String location;


    @Before
    public void setUp() throws IOException, InvalidFormatException {
        location = "resources/Files/ExcelReader.xlsx";
    }


    @Test
    public void writing_to_Excel_File() throws Exception {

        String sheetName = "authentication";

        Excel_Reader reader = new Excel_Reader(location);

        System.out.println("Row Count: " + reader.getRowCount(sheetName));
        System.out.println("Column Count: " + reader.getColumnCount(sheetName));
        System.out.println("Sheet exist: " + reader.isSheetExist(sheetName));

        System.out.println("Get cellData: " + reader.getCellData(sheetName, 3, 2));
        System.out.println("Get cellData: " + reader.getCellData(sheetName, "Email", 2));

        //reader.addSheet("test");
       // reader.removeSheet("test");


    }

    @After
    public void closeFile() throws IOException {

    }
}
