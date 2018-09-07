package com.aissue;

import com.aissue.utils.JedisUtils;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.Semaphore;

public class test {
    public JedisUtils jedisUtils;
    public JedisPoolConfig jedisPoolConfig;

    @Before
    public void before(){
       jedisPoolConfig = new JedisPoolConfig();
       jedisPoolConfig.setMaxTotal(500);
       jedisPoolConfig.setMaxIdle(100);
       jedisPoolConfig.setMinIdle(50);
       jedisPoolConfig.setMaxWaitMillis(1000L);
       jedisPoolConfig.setTestOnBorrow(true);
       jedisPoolConfig.setTestOnReturn(true);
       jedisUtils = new JedisUtils(jedisPoolConfig,"192.168.40.14",6379);
    }

    @Test
    public void test1(){
        Long num = jedisUtils.publish("aissue","this is my message..."+System.currentTimeMillis());
        System.out.println(num);
        /*for(int i=0;i<50;i++){
            Long num = jedisUtils.publish("aissue","this is my message..."+System.currentTimeMillis());
            System.out.println(num);
        }*/


    }

    @Test
    public void test2() throws InterruptedException {
        /*Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();*/
        jedisUtils.subscrib("aissue");
//        semaphore.acquire();
    }
}
