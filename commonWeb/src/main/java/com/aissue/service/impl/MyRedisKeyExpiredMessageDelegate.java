package com.aissue.service.impl;

import com.aissue.service.MyMessageDelegate;

import java.io.Serializable;
import java.util.Map;

public class MyRedisKeyExpiredMessageDelegate implements MyMessageDelegate {
    @Override
    public void handleMessage(String message) {
        System.out.println("handleMessage(String message)--->"+message);
    }

    /*@Override
    public void handleMessage(Map message) {
        System.out.println("handleMessage(Map message)--->"+message);
    }

    @Override
    public void handleMessage(byte[] message) {
        System.out.println("handleMessage(byte[] message)--->"+message);
    }

    @Override
    public void handleMessage(Serializable message) {
        System.out.println("handleMessage(Serializable message)--->"+message);
    }

    @Override
    public void handleMessage(Serializable message, String channel) {
        System.out.println("handleMessage(Serializable message, String channel)--->"+message+"|"+channel);
    }*/
}
