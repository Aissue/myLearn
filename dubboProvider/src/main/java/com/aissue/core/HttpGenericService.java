package com.aissue.core;

import com.aissue.entity.InterRequestVo;
import com.aissue.entity.InterRespVo;
import com.aissue.entity.InterfaceInfo;
import com.aissue.exception.HttpException;
import com.aissue.utils.HttpClientUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

public class HttpGenericService implements GenericService {

    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        //参数组装
        Map<String,Object> paramMap = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            paramMap.put(strings[i],objects[i]);
        }
        InterfaceInfo interfaceInfo = (InterfaceInfo)paramMap.get("InterfaceInfo");
        InterRequestVo interRequest = (InterRequestVo)paramMap.get("InterRequestVo");

        if (null == interfaceInfo) {
            throw new GenericException("03", "接口信息不能为空");
        }
        if (!"HTTP".equals(interfaceInfo.getInvokeType())) {
            throw new GenericException("03", "非HTTP协议的提供者");
        }
        if (StringUtils.isEmpty(interfaceInfo.getNetUrl())) {
            throw new GenericException("03", "提供者地址不能为空");
        }
        Map<String, String> params = interRequest.getParams();
        String result = null;
        try {
            result = HttpClientUtil.sendPostForm(interfaceInfo.getNetUrl(),params,null);
        } catch (HttpException e) {
            String code ="44";
            if(e.getCode().startsWith("5")){
                code ="45";
            }
            throw new GenericException(code, e.getMessage());
        }
        InterRespVo respVo = new InterRespVo();
        respVo.setDatas(result);
        respVo.setDataCount(1);
        respVo.setRequestId(interRequest.getRequestId());

        return respVo;
    }
}
