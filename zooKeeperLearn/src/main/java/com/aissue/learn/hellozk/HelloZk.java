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
    private HiWatcher hiw = null;

    @Before
    public void before() throws IOException {//10.1.1.147:2181,
        this.zk = new ZooKeeper("127.0.0.1:2181", 3000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
//                System.out.println("已经触发了"+watchedEvent.getType()+"事件。");
            }
        });
        this.hw = new HelloWatcher();
        this.hiw = new HiWatcher();
    }

    @Test
    //测试监控
    public void test4(){
        try{
            if(zk.exists("/aissue",hw) == null){//建立监听
                zk.create("/aissue","aissue".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            Thread.sleep(3000l);
//            zk.exists("/aissue",true);//为true时并不能监听，之前的监听器消失了
//            zk.exists("/aissue",hw);//必须重新设立监听，才能再次监听
            zk.getChildren("/aissue",hiw);
            if(zk.exists("/aissue/wangkun", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("/aissue/wangkun 发生变化："+ watchedEvent.getType().name());
                }
            }) == null){
                zk.create("/aissue/wangkun","wangkun".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            zk.setData("/aissue/wangkun","wangkun3".getBytes(),-1);//貌似改变子节点的值不会触发父节点的变化
            Thread.sleep(3000l);
            if(zk.exists("/aissue/test", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("/aissue/test 发生变化："+ watchedEvent.getType().name());
                }
            }) == null){
                zk.create("/aissue/test","wangkun".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            Thread.sleep(3000l);

        }catch (Exception e){

        }
    }

    @Test
    public void test3(){
        try{
            if(zk.exists("/aissue1",hw) == null){
                zk.create("/aissue1","aissue".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            if(zk.exists("/aissue1/wk",hiw) == null){
                zk.create("/aissue1/wk","wangkun".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            zk.setData("/aissue1/wk","wangerkun".getBytes(),-1);
            Thread.sleep(5000l);
        }catch (Exception e){

        }
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
