package com.aissue.web;

import org.apache.log4j.Logger;
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

    @RequestMapping("index")
    @ResponseBody
    public Map test1(){
        logger.info("test logger...");
        Map<String,String> map = new HashMap<>();
        map.put("name","aissue");
        map.put("age","27");
        return map;
    }

}
