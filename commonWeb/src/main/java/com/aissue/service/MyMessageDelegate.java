package com.aissue.service;

import java.io.Serializable;
import java.util.Map;

public interface MyMessageDelegate {
    void handleMessage(String message);
    /*void handleMessage(Map message);
    void handleMessage(byte[] message);
    void handleMessage(Serializable message);
    void handleMessage(Serializable message, String channel);*/
}
