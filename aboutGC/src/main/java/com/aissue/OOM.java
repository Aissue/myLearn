package com.aissue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/19.
 */
public class OOM {
    static class OOMObject{
        public byte[] placehokder = new byte[10*1024];
    }

    public static void fillHeap(int num) throws Exception{
        List<OOMObject> list = new ArrayList();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
//        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(10000);
        System.gc();
    }
}
