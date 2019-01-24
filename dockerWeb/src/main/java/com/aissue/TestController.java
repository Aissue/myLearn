package com.aissue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logs")
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/addLog")
    public void test(){
        log.info("test。。。");
    }

}
