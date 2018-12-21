package com.aissue.annotation.impl;

import com.aissue.annotation.IAnnotation;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@org.springframework.stereotype.Service("annotation1")
public class Annotation1 implements IAnnotation {

    public String test1(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是默认的超时时间...";
    }

    @Override
    public String test2() {
        return null;
    }
}
