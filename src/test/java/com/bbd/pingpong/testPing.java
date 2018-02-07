package com.bbd.pingpong;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testPing {
    @Test
    public void testNumber1() {
        assertEquals(1, RomanConverter.Convert("I"));
    }

    @Test
    public void testNumber2() {
        assertEquals(2, RomanConverter.Convert("II"));
    }

    @Test
    public void testNumber5() {
        assertEquals(5, RomanConverter.Convert("V"));
    }

    @Test
    public void test2DifferentNumber() {
        assertEquals(6, RomanConverter.Convert("VI"));
    }

    @Test
    public void testSmallchar() {
        assertEquals(6, RomanConverter.Convert("vi"));
    }

    @Test
    public void testX() {
        assertEquals(10, RomanConverter.Convert("x"));
    }

    @Test
    public void testL() {
        assertEquals(50, RomanConverter.Convert("l"));
    }

    @Test
    public void testC() {
        assertEquals(100, RomanConverter.Convert("C"));
    }

    @Test
    public void testD() {
        assertEquals(500, RomanConverter.Convert("D"));
    }

    @Test
    public void testM() {
        assertEquals(1000, RomanConverter.Convert("M"));
    }

    @Test
    void exceptionTestingA() {
        Throwable exception = assertThrows(RuntimeException.class,
                () -> {
                    RomanConverter.Convert("A");
                });
        assertEquals("Invalid figure found", exception.getMessage());
    }

    @Test
    void exceptionTestingSpace() {
        Throwable exception = assertThrows(RuntimeException.class,
                () -> {
                    RomanConverter.Convert(" ");
                });
        assertEquals("Invalid figure found", exception.getMessage());
    }

    @Test
    public void testNumber4() {
        assertEquals(4, RomanConverter.Convert("IV"));
    }

    @Test
    public void testNumber40() {
        assertEquals(40, RomanConverter.Convert("XL"));
    }

    @Test
    public void testNumber9() {
        assertEquals(9, RomanConverter.Convert("IX"));
    }

    @Test
    public void testNumber90() {
        assertEquals(90, RomanConverter.Convert("XC"));
    }

    @Test
    public void testNumber400() {
        assertEquals(400, RomanConverter.Convert("CD"));
    }

    @Test
    public void testNumber999() {
        assertEquals(404, RomanConverter.Convert("CDIV"));
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(RuntimeException.class,
                () -> {
                    RomanConverter.Convert("IIII");
                });
        assertEquals("Invalid sequence", exception.getMessage());
    }
}