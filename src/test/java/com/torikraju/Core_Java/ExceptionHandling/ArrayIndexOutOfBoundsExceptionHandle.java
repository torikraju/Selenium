package com.torikraju.Core_Java.ExceptionHandling;

import org.junit.Test;

public class ArrayIndexOutOfBoundsExceptionHandle {

    @Test
    public void ArrayIndexOutOfBoundsExceptionHandling() {

        try {
            int i[] = new int[2];
            i[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.fillInStackTrace());
        }


    }

}
