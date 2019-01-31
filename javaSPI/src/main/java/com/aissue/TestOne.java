package com.aissue;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

public class TestOne {

    @Test
    public void test1(){
        ServiceLoader<HelloService> loaders = ServiceLoader.load(HelloService.class);
        for(HelloService helloService:loaders){
            System.out.println(helloService.say());
        }
    }

}
