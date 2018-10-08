package com.aissue.learn;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

public class zkMove {
    public static void main(String[] args) throws Exception{
        //旧zk配置
        ZooKeeper oldzk = new ZooKeeper("59.202.34.234:2181", 60000, null);
        //新zk配置
        ZooKeeper newzk = new ZooKeeper("59.202.34.234:2181", 60000, null);
        //迁移的节点
        String oldnode = "/provider/yscredit/namespace/JfbRQUa8b36f6mSc/94cu3g0x6PdyIKb7";
        String newnode = "/provider/yscredit/namespace/06G0elz632T950Eb/94cu3g0x6PdyIKb7";
        move2(oldzk,oldnode,newnode);
        /*List<String> children = oldzk.getChildren(node, false);
        move(oldzk, newzk, children,node);
        oldzk.close();
        newzk.close();*/
        oldzk.close();
    }


    private static void move2(ZooKeeper zooKeeper,String oldNode,String newNode) throws Exception{
        byte[] data = zooKeeper.getData(oldNode, false, null);
//        System.out.println(JsonUtil.toJsonString(data));
        if(zooKeeper.exists(newNode,false)==null){
            zooKeeper.create(newNode,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
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
