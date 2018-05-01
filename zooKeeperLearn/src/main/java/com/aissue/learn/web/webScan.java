package com.aissue.learn.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class webScan implements InitializingBean {

    public void afterPropertiesSet() throws Exception {
        System.out.println("=========作为jar包的一个组件，老子被扫描到了=================");
    }
}
