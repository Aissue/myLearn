package com.aissue.entity;

import java.util.Date;

public class RequestPloy {
    private Integer id;

    private String token;

    private String appKey;

    private String refreshSecret;

    private Date refreshStartTime;

    private Date refreshEndTime;

    private Integer maxDataCount;

    private Integer maxAccessCount;

    private String requestSecret;

    private Date requestStartTime;

    private Date requestEndTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getAppKey() {return appKey;}

    public void setAppKey(String appKey) {this.appKey = appKey;}

    public String getRefreshSecret() {
        return refreshSecret;
    }

    public void setRefreshSecret(String refreshSecret) {
        this.refreshSecret = refreshSecret == null ? null : refreshSecret.trim();
    }

    public Date getRefreshStartTime() {
        return refreshStartTime;
    }

    public void setRefreshStartTime(Date refreshStartTime) {
        this.refreshStartTime = refreshStartTime;
    }

    public Date getRefreshEndTime() {
        return refreshEndTime;
    }

    public void setRefreshEndTime(Date refreshEndTime) {
        this.refreshEndTime = refreshEndTime;
    }

    public Integer getMaxDataCount() {
        return maxDataCount;
    }

    public void setMaxDataCount(Integer maxDataCount) {
        this.maxDataCount = maxDataCount;
    }

    public Integer getMaxAccessCount() {
        return maxAccessCount;
    }

    public void setMaxAccessCount(Integer maxAccessCount) {
        this.maxAccessCount = maxAccessCount;
    }

    public String getRequestSecret() {
        return requestSecret;
    }

    public void setRequestSecret(String requestSecret) {
        this.requestSecret = requestSecret == null ? null : requestSecret.trim();
    }

    public Date getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(Date requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public Date getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(Date requestEndTime) {
        this.requestEndTime = requestEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}