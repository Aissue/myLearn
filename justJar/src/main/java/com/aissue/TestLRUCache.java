package com.aissue;

/**
 * Created by Administrator on 2020/3/31.
 */
public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache<String,String> lurCache = new LRUCache<String, String>(3);
        lurCache.put("1","aa");
        lurCache.put("2","bb");
        lurCache.put("3","cc");
        for(String key : lurCache.keySet()){
            System.out.println(key);
        }
        System.out.println("=====");
        lurCache.get("1");
        lurCache.get("1");
        lurCache.get("1");
        lurCache.get("1");
        for(String key : lurCache.keySet()){
            System.out.println(key);
        }
        lurCache.put("4","dd");
        System.out.println("=====");
        for(String key : lurCache.keySet()){
            System.out.println(key);
        }

    }
}
