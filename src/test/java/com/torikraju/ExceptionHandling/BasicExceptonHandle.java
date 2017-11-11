package com.torikraju.ExceptionHandling;

import org.junit.Test;

public class BasicExceptonHandle {

    @Test
    public void ArithmeticExceptionHandling() {


        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
