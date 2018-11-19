package com.aissue.multithread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMain {
    @Test
    public void test1(){
        ExecutorService executorService0 = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        int x = Integer.MAX_VALUE + 1;
        System.out.println(x);
    }
}
