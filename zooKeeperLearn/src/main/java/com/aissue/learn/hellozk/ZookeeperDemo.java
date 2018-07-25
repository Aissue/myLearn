package com.aissue.learn.hellozk;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class ZookeeperDemo {
    private ZooKeeper zk = null;

    @Before
    public void before() throws IOException {//10.1.1.147:2181,
        this.zk = new ZooKeeper("127.0.0.1:2181", 3000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
//                System.out.println("已经触发了"+watchedEvent.getType()+"事件。");
            }
        });
    }

    @Test
    public void test2(){
        try{
            if(zk.exists("/test2",false)==null){
                zk.create("/test2","test2".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            zk.getChildren("/test2", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("/test2 节点的子节点们有变化了...变化方式是："+watchedEvent.getType().name());
                }
            });
            if(zk.exists("/test2/node1", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("test2/node1 节点发生了变化...变化方式是："+watchedEvent.getType().name());
                }
            })==null){
                zk.create("/test2/node1","".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            Thread.sleep(3000l);
        }catch(Exception e){

        }
    }

    @Test
    //一个节点可以做多个监听...这都行...
    public void test1(){
        try{
            if(zk.exists("/root", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getPath()+" 触发...触发方式是："+watchedEvent.getType().name());
                }
            })==null){
                zk.create("/root","rootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            zk.exists("/root", new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getPath()+" 触发2...触发方式是："+watchedEvent.getType().name());
                }
            });
            zk.setData("/root","rootData1".getBytes(),-1);
            Thread.sleep(3000l);
        }catch(Exception e){

        }
    }
}
