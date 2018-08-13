package com.aissue.test;


import com.aissue.entity.ShareInterface;
import com.aissue.entity.User;
import org.junit.jupiter.api.Test;

import java.util.*;


public class MyMain {

    public static void main(String[] args) {
        List<ShareInterface> before = new ArrayList<>();
        List<ShareInterface> after = new ArrayList<>();
        ShareInterface s1 = new ShareInterface("aaa","http",32);
        ShareInterface s2 = new ShareInterface("bbb","http",30);
        ShareInterface s3 = new ShareInterface("ccc","http",30);
        ShareInterface s4 = new ShareInterface("ddd","http",30);
        ShareInterface s5 = new ShareInterface("aaa","http",30);
        ShareInterface s6 = new ShareInterface("bbb","http",30);
        ShareInterface s7 = new ShareInterface("ccc","http",30);
        ShareInterface s8 = new ShareInterface("ddd","http",30);

        before.add(s1);
        before.add(s2);
        /*before.add(s3);
        before.add(s4);*/

        after.add(s5);
        after.add(s6);
        /*after.add(s7);
        after.add(s8);*/


        Map<String,List<ShareInterface>> map = handleShareInter(before,after);
        System.out.println(before);
        System.out.println(after);


    }

    public static Map<String,List<ShareInterface>> handleShareInter(List<ShareInterface> beforeList,List<ShareInterface> afterList){
        Map<String,List<ShareInterface>> resultMap = new HashMap<>();

        //两个列表比较找到待暴露和取消暴露的最终列表
        List<ShareInterface> exportList = new ArrayList<>();
        List<ShareInterface> unexportList = new ArrayList<>();
        List<ShareInterface> tmpList = new ArrayList<>();
        List<ShareInterface> exage = new ArrayList<>();

        //原无共享接口暴露
        if(beforeList == null){
            //现有共享接口暴露
            if(afterList != null && afterList.size()>0){
                exportList = afterList;
            }
        }
        //原有共享接口暴露
        else if(beforeList != null && beforeList.size()>0){
            //现有共享接口暴露
            if(afterList != null && afterList.size()>0){
                //找到交集
                for(ShareInterface beforeInter : beforeList){
                    for(ShareInterface afterInter : afterList){
                        if(beforeInter.equals(afterInter)){
                            tmpList.add(afterInter);
                            continue;
                        }
                    }
                }
                //设置暴露接口

                afterList.removeAll(tmpList);
                exportList = afterList;
                //设置取消暴露接口
                beforeList.removeAll(tmpList);
                unexportList = beforeList;
            }
            //现无共享接口暴露
            else{
                unexportList = beforeList;
            }
        }

        resultMap.put("exportList",exportList);
        resultMap.put("unexportList",unexportList);
        return resultMap;
    }


    @Test
    public void test(){
        int x=0;
        int y=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<5;j++){
                if(i==6){
                    break;
                }
                y++;
            }
            x++;
        }
        System.out.println("x:"+x);
        System.out.println("y:"+y);
    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> tmp = new ArrayList<>();
        tmp.add("a");

        User user = new User();
        user.setList(list);

        List<String> kk = user.getList();
        kk.removeAll(tmp);
        //user的属性list发生了变化
        System.out.println(user.getList());


    }

    @Test
    public void test3(){
        Map<String,String> map = new HashMap<>();
        map.put(null,"abc");
        Set s = new HashSet<>();
        Set s2 = new LinkedHashSet();
        Set s3 = new TreeSet();
        s2.add(1);
        s2.add(3);
        s2.add(4);
        s.add(1);
        s.add(3);
        s.add(4);
        System.out.println(s2+"|"+s);

    }
}
