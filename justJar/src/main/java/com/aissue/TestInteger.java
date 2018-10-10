package com.aissue;

public class TestInteger {
    public static void main(String[] args) {
        Integer a = 1234;
        Integer b = 1234;

        System.out.println(a.equals(b));
        System.out.println(a==b);
        System.out.println(a.intValue()==b.intValue());

        String x = System.getProperty("123");
        System.out.println(x);

    }
}
