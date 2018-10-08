package com.aissue.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMain1 {
    public static void main(String[] args) throws Exception{
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("cardID","140602");
            dataMap.put("gender","男");
            dataMap.put("nation","汉族");
            dataMap.put("registerPlace","山西朔州");
            dataMap.put("status","党员");
            list.add(dataMap);
        }
        Map<String,Object> datas = new HashMap<>();
        datas.put("data",list);
        datas.put("name", "邱林和");

        MDoc mdoc = new MDoc();
        mdoc.createDoc(datas, "D:/outFile.doc");
        System.out.println("模板生成成功");
    }
}
