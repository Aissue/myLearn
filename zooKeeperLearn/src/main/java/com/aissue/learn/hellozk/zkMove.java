package com.aissue.learn.hellozk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

public class zkMove {

    public static void main(String[] args) throws Exception{
        //旧zk配置
        ZooKeeper oldzk = new ZooKeeper("10.100.173.127:2181,10.100.173.136:2181,10.100.173.137:2181", 60000, null);
        //新zk配置
        ZooKeeper newzk = new ZooKeeper("10.100.96.115:2181,10.100.96.116:2181,10.100.96.117:2181", 60000, null);
        //迁移的节点
        String node = "/mhosts";
        List<String> children = oldzk.getChildren(node, false);
        move(oldzk, newzk, children,node);
        oldzk.close();
        newzk.close();
    }

    private static void move(ZooKeeper oldzk, ZooKeeper newzk, List<String> children, String parent)
            throws KeeperException, InterruptedException {
        if(children==null || children.isEmpty()){
            return;
        }else{
            for(String child:children){
                String c = parent+"/"+child;
                System.out.println(c);
                byte[] data = oldzk.getData(c, false, null);
                if(newzk.exists(c, false)==null){
                    newzk.create(c, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }else{
                    newzk.setData(c, data, -1, null, null);
                }
                move(oldzk, newzk, oldzk.getChildren(c, false),c);
            }
        }
    }
}
