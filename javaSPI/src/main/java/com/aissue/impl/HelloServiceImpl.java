package com.aissue.impl;

import com.aissue.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "hello,you are greatest!";
    }
}
