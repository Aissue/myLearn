package com.aissue.web;

import com.aissue.entity.InterRequestVo;
import com.aissue.entity.User;
import com.aissue.learn.utils.JsonUtil;
import com.aissue.service.UserService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
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
//    private Logger logger = Logger.getLogger(TestController.class);
    private Logger logger = Logger.getLogger(User.class);

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public Map test1(String timeOut){
        logger.info("test logger...");
        Map<String,String> map = new HashMap<>();
        map.put("name","aissue");
        map.put("age","27");
        try {
            Long time = Long.parseLong(timeOut);
            TimeUnit.SECONDS.sleep(time);
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

    @RequestMapping("interface")
    @ResponseBody
    public String test5(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
//        reference.setInterface("3zbDJGceQd42n1z8");
//        reference.setInterface("3zbDJGceQd42n1z8");
        reference.setInterface("4xQ1w4fPWV4490b8");
        reference.setVersion("1.1.1");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.40.14:2181");
        reference.setRegistry(registryConfig);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("openApi");
        reference.setApplication(applicationConfig);
        // 声明为泛化接口
        reference.setGeneric(true);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object obj = genericService.$invoke("sayHello", new String[] {"APP_KEY"}, new Object[] {"bbd8009946f242dab57a9759327ca44a"});
//        Object obj = genericService.$invoke("sayHello", null,null);
        Map<String,List<Map<String,Object>>> map = (Map<String,List<Map<String,Object>>>)obj;
        String s = JsonUtil.toJsonString(obj);
        return s;
    }

    @RequestMapping("http")
    @ResponseBody
    public String test6(InterRequestVo interRequest){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setInterface(interRequest.getInterCode());
        reference.setVersion("1.0.1");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://59.202.43.113:2181");
        reference.setRegistry(registryConfig);
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("openApi");
        reference.setApplication(applicationConfig);
        reference.setGeneric(true);
        GenericService genericService = reference.get();

        /*Map<String,String> params = new HashMap<>();
        params.put("bizlicense","91330205MA2AEL986T");
        params.put("licenseNum","330205500007");
        params.put("name","深圳万顺叫车云信息技术有限公司宁波前洋分公司");*/
        /*String[] paramNames = {"interRequestVo"};
        Object[] paramValues = {interRequest};
        Object obj = genericService.$invoke("",paramNames,paramValues);
        Map<String,List<Map<String,Object>>> map = (Map<String,List<Map<String,Object>>>)obj;
        String s = JsonUtil.toJsonString(obj);*/
        return "";
    }
}
