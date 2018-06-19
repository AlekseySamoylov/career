package com.alekseysamoylov.career.security;

import org.junit.Test;

public class MainTest {

    private String text;

    @Test
    public void testFirst() {
        System.out.println(text);
        text = "Hi";
        System.out.println(text);
    }

    @Test
    public void testSecond() {
        System.out.println(text);
        text = "Buy";
        System.out.println(text);
    }
}
