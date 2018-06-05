package com.aissue.core;

import com.aissue.utils.ApplicationContextHandle;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import java.util.Properties;

/**
 * Created by linzhipeng on 2018/1/26.
 */
public class DubboConfig {

    private static Properties dubbo = (Properties) ApplicationContextHandle.getBean("dubbo");

    private static ApplicationConfig applicationConfig;
    private static RegistryConfig registryConfig;
    private static ProtocolConfig protocolConfig;
    private static String version;

    private static DubboConfig dubboConfig;

    static {
        //当前应用配置
        applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubbo.getProperty("application_name"));
        // 连接注册中心配置
        registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubbo.getProperty("registry_address"));
        // 服务提供者协议配置
        protocolConfig = new ProtocolConfig();
        protocolConfig.setName(dubbo.getProperty("protocol_name"));
        protocolConfig.setPort(Integer.valueOf(dubbo.getProperty("protocol_port")));
        protocolConfig.setThreads(Integer.valueOf(dubbo.getProperty("protocol_threads")));
        //服务版本号
        version = dubbo.getProperty("service_version");
    }

    private DubboConfig(){

    }

    public static synchronized  DubboConfig getInstance(){
        if (dubboConfig == null){
            dubboConfig = new DubboConfig();
        }
        return dubboConfig;
    }

    public  ApplicationConfig getApplicationConfig() {
        return applicationConfig;
    }


    public  RegistryConfig getRegistryConfig() {
        return registryConfig;
    }


    public  ProtocolConfig getProtocolConfig() {
        return protocolConfig;
    }


    public  String getVersion() {
        return version;
    }


}
