package com.aissue.core;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *dubbo工具类
 * Created by linzhipeng on 2018/1/26.
 */
public class DubboUtil {

    private static final Logger logger = Logger.getLogger(DubboUtil.class);

    // 暴露接口服务的Map
    private static Map<String,ServiceConfig> exportMap=new ConcurrentHashMap<>();
    // 引用接口服务的Map
    private static Map<String,ReferenceConfig> referenceMap=new ConcurrentHashMap<>();


    //dubbo通过API方式暴露接口服务
    public static void export(String interfaceCode,ServiceConfig serviceConfig){
        if (serviceConfig != null){
            serviceConfig.export();
            exportMap.put(interfaceCode,serviceConfig);
        }else {
            logger.warn("传入的serviceConfig为null");
        }
    }

    //dubbo通过API方式取消暴露接口服务
    public static void unexport(String interfaceCode){
        ServiceConfig serviceConfig = DubboUtil.exportMap.get(interfaceCode);
        if (serviceConfig != null){
            serviceConfig.unexport();
            DubboUtil.exportMap.remove(interfaceCode);
        }else {
            logger.warn("此interfaceCode未暴露过服务");
        }
    }




    public static Map<String, ServiceConfig> getExportMap() {
        return exportMap;
    }

    //创建接口暴露服务
    public static ServiceConfig buildServiceConfig(String interfaceCode,GenericService genericService){
        DubboConfig dubboConfig = DubboConfig.getInstance();
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(dubboConfig.getApplicationConfig());
        serviceConfig.setRegistry(dubboConfig.getRegistryConfig());
        serviceConfig.setProtocol(dubboConfig.getProtocolConfig());
        serviceConfig.setInterface(interfaceCode);
        serviceConfig.setRef(genericService);
        /*尽量在provider层进行时间的设定，消费端不做设定*/
        serviceConfig.setTimeout(60000);
        serviceConfig.setRetries(0);
        serviceConfig.setVersion(dubboConfig.getVersion());
        return serviceConfig;
    }

    //创建接口引用服务
    public static ReferenceConfig buildReferenceConfig(String interfaceCode){
        DubboConfig dubboConfig = DubboConfig.getInstance();
        ReferenceConfig reference = new ReferenceConfig();
        reference.setApplication(dubboConfig.getApplicationConfig());
        reference.setRegistry(dubboConfig.getRegistryConfig());
        reference.setVersion(dubboConfig.getVersion());
        // 声明为泛化接口
        reference.setInterface(interfaceCode);
        reference.setGeneric(true);
        return reference;
    }

    public static Map<String, ReferenceConfig> getReferenceMap() {
        return referenceMap;
    }

    public static ReferenceConfig getReferenceConfig(String interfaceCode){
        ReferenceConfig referenceConfig = referenceMap.get(interfaceCode);
        if (referenceConfig == null){
            referenceConfig = buildReferenceConfig(interfaceCode);
            referenceMap.put(interfaceCode,referenceConfig);
        }
        return referenceConfig;
    }
}
