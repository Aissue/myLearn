package com.aissue.web;

import com.aissue.entity.User;
import com.aissue.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yscredit
 */
@Controller
@RequestMapping("test")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public Map test1(){
        logger.info("test logger...");
        Map<String,String> map = new HashMap<>();
        map.put("name","aissue");
        map.put("age","27");
        return map;
    }

    @RequestMapping("mysql")
    @ResponseBody
    public User test2(){
        logger.info("test2 logger...");
        User user = userService.selectByPrimaryKey(1);
        return user;
    }
}
