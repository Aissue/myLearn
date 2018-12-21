package com.aissue.annotation.impl;

import com.aissue.annotation.IAnnotation;
import com.alibaba.dubbo.config.annotation.Service;

//@Service(timeout = 10000)
public class Annotation2 implements IAnnotation{
    @Override
    public String test1() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我是10s";
    }

    @Override
    public String test2() {
        return null;
    }
}
