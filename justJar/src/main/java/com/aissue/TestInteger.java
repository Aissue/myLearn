package com.aissue;

import com.aissue.utils.JsonUtil;

import java.util.HashSet;
import java.util.Set;

public class TestInteger {
    public static void main(String[] args) {
        /*Integer a = 1234;
        Integer b = 1234;

        System.out.println(a.equals(b));
        System.out.println(a==b);
        System.out.println(a.intValue()==b.intValue());

        String x = System.getProperty("123");
        System.out.println(x);*/

        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        Set<String> set3 = new HashSet<String>();

        set1.add("a");
        set1.add("b");
        set1.add("v");
        set1.add("e");

        set2.add("a");
        set2.add("b");
        set2.add("v");
        set2.add("d");

        for(String s:set1){
            if(!set2.contains(s)){
                set3.add(s);
            }
        }

        System.out.println(set3.size()+"|"+ JsonUtil.toJsonString(set3));



    }
}
