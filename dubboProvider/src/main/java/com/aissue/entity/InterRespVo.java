package com.aissue.entity;

/**
 * Created by YS on 2017/3/9.
 * @author 子华
 */
public class InterRespVo<T> extends Effect<T> {

    /**
     * 此次返回数据量，默认值是0
     */
    private Integer dataCount=0;

    /**
     * 请求的唯一ID
     */
    private String requestId;

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
