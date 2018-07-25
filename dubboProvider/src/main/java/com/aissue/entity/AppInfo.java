package com.aissue.entity;

import java.util.Date;

public class AppInfo {
    private Integer id;

    private String token;

    private String departmentCode;

    private String appName;

    private String appKey;

    private String appSecret;

    private Date secretStartTime;

    private Date secretEndTime;

    private Date createTime;

    private Date updateTime;

    private String IpWhite;

    //应用描述
    private String appDesc;

    //应用状态
    private Integer appStatus;

    private Integer appWeight;

    public AppInfo() {
    }


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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }


    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public Date getSecretStartTime() {
        return secretStartTime;
    }

    public void setSecretStartTime(Date secretStartTime) {
        this.secretStartTime = secretStartTime;
    }

    public Date getSecretEndTime() {
        return secretEndTime;
    }

    public void setSecretEndTime(Date secretEndTime) {
        this.secretEndTime = secretEndTime;
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

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getIpWhite() {return IpWhite;}

    public void setIpWhite(String ipWhite) {IpWhite = ipWhite;}

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public Integer getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Integer appStatus) {
        this.appStatus = appStatus;
    }

    public Integer getAppWeight() {
        return appWeight;
    }

    public void setAppWeight(Integer appWeight) {
        this.appWeight = appWeight;
    }
}