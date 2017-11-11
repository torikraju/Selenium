package com.torikraju.Core_Java.Streams.Excel_File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Writing_Excel_File {


    private String location;


    @Before
    public void setUp() throws IOException {
        location = "resources/Files/Default.xlsx";

    }


    @Test
    public void writing_to_Excel_File() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("First Sheet");

 /*       Row row0 = sheet.createRow(0);
        Cell cell_1 = row0.createCell(0);
        Cell cell_2 = row0.createCell(1);

        cell_1.setCellValue("First Cell");
        cell_2.setCellValue("Second Cell");*/

        for (int rows = 0; rows < 4; rows++) {
            Row row = sheet.createRow(rows);
            for (int cols = 0; cols < 10; cols++) {
                Cell cell = row.createCell(cols);
                cell.setCellValue(new Random().nextInt(89) + 10);
            }
        }


        File file = new File(location);
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);

        outputStream.close();


    }


    @After
    public void closeFile() throws IOException {

    }
}
