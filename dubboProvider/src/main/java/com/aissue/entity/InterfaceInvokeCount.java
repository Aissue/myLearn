package com.aissue.entity;

import java.util.Date;

/**
 * Created by YS on 2017/3/10.
 */
public class InterfaceInvokeCount {

    /**
     * 应用appKey
     */
    private String appKey ;

    /**
     * 接口编码
     */
    private String interCode;
    /**
     * 访问次数
     */
    private long accessCount;

    /**
     * 数据量
     */
    private long dataCount;

    //时间类型
    private Date date;

    // 时间类型 String
    private String dateFormat;

    private long beyondCount;

    private long successCount;

    public long getBeyondCount() {
        return beyondCount;
    }

    public void setBeyondCount(long beyondCount) {
        this.beyondCount = beyondCount;
    }

    public long getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(long successCount) {
        this.successCount = successCount;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public String getInterCode() {
        return interCode;
    }

    public void setInterCode(String interCode) {
        this.interCode = interCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
