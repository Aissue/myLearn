package com.aissue.web;

import com.aissue.entity.User;
import com.aissue.learn.utils.JsonUtil;
import com.aissue.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author yscredit
 */
@Controller
@RequestMapping("test")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public Map test1(){
        logger.info("test logger...");
        Map<String,String> map = new HashMap<>();
        map.put("name","aissue");
        map.put("age","27");
        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("mysql")
    @ResponseBody
    public String test2(){
        logger.info("test2 logger...");
        List<User> userList = new ArrayList<>();
        User user = userService.selectByPrimaryKey(1);
        userList.add(user);
        User user2 = userService.selectUser("admin","21232f297a57a5a743894a0e4a801fc3","1");
        userList.add(user2);

        return JsonUtil.toJsonString(userList);
    }

    @RequestMapping("logs")
    @ResponseBody
    public void test3(){
        logger.info("logger info...");
        logger.debug("logger debug...");
        logger.error("logger error");
        logger.warn("logger warning...");
    }

    @RequestMapping("error")
    @ResponseBody
    public Map test4(){
        Map<String,String> map = new HashMap<>();
        map.put("name","error");
        map.put("age","20");
        throw new RuntimeException("just a error test!");
        //return map;
    }
}
