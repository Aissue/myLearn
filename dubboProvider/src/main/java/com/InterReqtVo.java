package com;

import java.io.Serializable;
import java.util.Map;

/**
 * 请求接口公共类
 */
public class InterReqtVo implements Serializable{

    //请求参数
    private Map<String, Object> params;

    //请求唯一ID
    private String requestId;

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
