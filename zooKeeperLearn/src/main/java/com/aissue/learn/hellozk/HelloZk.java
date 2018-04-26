package com.aissue.learn.hellozk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


public class HelloZk {
    private ZooKeeper zk = null;
    private HelloWatcher hw = null;

    @Before
    public void before() throws IOException {//10.1.1.147:2181,
        this.zk = new ZooKeeper("192.168.248.128:2181,127.0.0.1:2181", 3000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
//                System.out.println("已经触发了"+watchedEvent.getType()+"事件。");
            }
        });
        this.hw = new HelloWatcher();
    }

    @Test
    public void test2(){
        try{
            if(zk.exists("/testWatch",hw) == null){
                zk.create("/testWatch","tesWatchValue".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            System.out.println(new String(zk.getData("/testWatch",true,null)));
            Thread.sleep(3000l);
            zk.setData("/testWatch","changeValue".getBytes(),-1);
            System.out.println(new String(zk.getData("/testWatch",true,null)));
//            if(zk.exists("/testWatch",hw) != null){
//                zk.delete("/testWatch",-1);
//            }

        }catch (Exception e){
        }
    }

    @Test
    public void test1(){
        try {
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
