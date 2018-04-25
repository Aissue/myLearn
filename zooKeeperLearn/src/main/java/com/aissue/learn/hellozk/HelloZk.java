package com.aissue.learn.hellozk;

import org.apache.zookeeper.*;
import org.junit.Test;


public class HelloZk {
    @Test
    public void test1(){
        try {
            ZooKeeper zk = new ZooKeeper("192.168.248.128:2181", 3000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("已经触发了"+watchedEvent.getType()+"事件。");
                }
            });
            if(zk.exists("/testRootPath",false) == null){
                zk.create("/testRootPath","testRootPath".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            System.out.println(new String(zk.getData("/testRootPath",false,null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
