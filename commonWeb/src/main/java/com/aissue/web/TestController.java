package com.aissue.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping("index")
    @ResponseBody
    public String test1(){
        logger.info("test logger...");
        return "successful!";
    }

}
