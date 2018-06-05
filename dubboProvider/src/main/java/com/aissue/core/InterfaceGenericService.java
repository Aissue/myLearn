package com.aissue.core;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class InterfaceGenericService implements GenericService {

    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test overload invoke...";
    }
}
