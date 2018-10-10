package com.aissue;

public enum  EnumTest {
    RED("red","红色"),GREEN("green","绿色"),BLUE("blue","蓝色");

    private final String key;
    private final String value;

    EnumTest(String key,String value){
        this.key = key;
        this.value = value;
    }
    //根据key获取枚举
    public static EnumTest getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(EnumTest temp:EnumTest.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

}
