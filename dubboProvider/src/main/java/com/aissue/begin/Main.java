package com.aissue.begin;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore semaphore = new Semaphore(1);
    private static ApplicationContext context;
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        semaphore.acquire();
        context = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
        logger.info("服务提供方开始服务");
        semaphore.acquire();
    }
}
