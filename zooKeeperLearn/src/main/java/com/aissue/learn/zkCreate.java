package com.aissue.learn;

import org.apache.zookeeper.ZooKeeper;


public class zkCreate {
    public static void main(String[] args) throws Exception {
        /* 连接zookeeper */
        ZooKeeper zooKeeper = new ZooKeeper("59.202.34.234:2181", 60000, null);


    }
}
