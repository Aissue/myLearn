package com.aissue.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/7/14.
 */
public class JedisUtil {
    private static Set<String> IPS = new HashSet<String>();
    private static Jedis jedis;
    static {
//        IPS.add("192.168.40.14:26379");
        IPS.add("192.168.40.13:26379");
        IPS.add("192.168.40.12:26379");
    }

    public static void test(){
        JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster",IPS,"123456");
        jedis = sentinelPool.getResource();
        String str = jedis.get("test");
        System.out.println(str);
        String hostIp = sentinelPool.getCurrentHostMaster().getHost();
        int hostPort = sentinelPool.getCurrentHostMaster().getPort();
        System.out.println(hostIp + ":"+hostPort);
    }

    public static void main(String[] args) {
        test();
    }


}
