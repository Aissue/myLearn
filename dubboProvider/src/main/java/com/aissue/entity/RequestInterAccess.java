package com.aissue.entity;

import java.util.Date;

public class RequestInterAccess {
    private Integer id;

    private String appKey;

    private String interfaceCode;

    private Integer dayMaxAccess;

    private Integer dayMaxData;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode == null ? null : interfaceCode.trim();
    }

    public Integer getDayMaxAccess() {
        return dayMaxAccess;
    }

    public void setDayMaxAccess(Integer dayMaxAccess) {
        this.dayMaxAccess = dayMaxAccess;
    }

    public Integer getDayMaxData() {
        return dayMaxData;
    }

    public void setDayMaxData(Integer dayMaxData) {
        this.dayMaxData = dayMaxData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}