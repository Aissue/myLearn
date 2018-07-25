package com.aissue.provider;

import com.aissue.begin.Main;
import com.aissue.core.DubboUtil;
import com.aissue.core.InterfaceGenericService;
import com.alibaba.dubbo.config.ServiceConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitProvider implements InitializingBean {
    private static final Logger logger = Logger.getLogger(InitProvider.class);

    public void afterPropertiesSet() throws Exception {
        logger.info("Spring is running ...");
        InterfaceGenericService interfaceGenericService = new InterfaceGenericService();
        ServiceConfig newConfig = DubboUtil.buildServiceConfig("aissueInterface2",interfaceGenericService,3000);
        DubboUtil.export("aissueInterface",newConfig);
    }


}
