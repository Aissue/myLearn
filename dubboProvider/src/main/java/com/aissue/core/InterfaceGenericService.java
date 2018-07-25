package com.aissue.core;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

public class InterfaceGenericService implements GenericService {

    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        try {
//            Thread.sleep(10L);
            Map<String,Object> paramMap = new HashMap<>();
            System.out.println("method is "+s);
            for(int i=0;i<strings.length;i++){
                paramMap.put(strings[i],objects[i]);
            }
            System.out.println(strings[strings.length]);
        } catch (Exception e) {
            throw new GenericException("","testException");
        }
        return "test overload invoke...[first one]";
    }
}
