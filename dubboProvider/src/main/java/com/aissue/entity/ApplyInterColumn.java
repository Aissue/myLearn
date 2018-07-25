package com.aissue.entity;

/**
 * Created by 子华 on 2017/5/24.
 * 申请的接口字段
 */
public class ApplyInterColumn {

    private Integer id;

    private String applyNo;

    private String columnCode;

    private Integer isAgree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }
}
