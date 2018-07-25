package com.aissue.provider;

import com.aissue.core.DubboUtil;
import com.aissue.core.HttpGenericService;
import com.aissue.core.InterfaceGenericService;
import com.alibaba.dubbo.config.ServiceConfig;
import org.apache.log4j.Logger;

public class HttpProvider {
    private static final Logger logger = Logger.getLogger(HttpProvider.class);

    public void example() throws Exception {
        HttpGenericService interfaceGenericService = new HttpGenericService();
        ServiceConfig newConfig = DubboUtil.buildServiceConfig("httpInterface",interfaceGenericService,3000);
        DubboUtil.export("httpInterface",newConfig);
    }
}
