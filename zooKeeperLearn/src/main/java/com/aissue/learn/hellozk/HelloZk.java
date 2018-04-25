package com.aissue.learn.hellozk;

import org.apache.zookeeper.*;
import org.junit.Test;

import java.util.List;


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
                zk.create("/testRootPath","testRootValue".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            System.out.println(new String(zk.getData("/testRootPath",false,null)));
            if(zk.exists("/testRootPath/testChildPath",false) == null){
               zk.create("/testRootPath/testChildPath","testChildValue".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
            }
            System.out.println(new String(zk.getData("/testRootPath/testChildPath",false,null)));
            List<String> list = zk.getChildren("/testRootPath",false);
            for(String str : list){
                System.out.println("======"+str);
            }
//            zk.setData("/testRootPath","NewRootValue".getBytes(),-1);
//            zk.delete("/testRootPath/testChildPath",0);
//            zk.delete("/testRootPath",0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
