package com.aissue.entity;

import java.util.List;

/**
 * Created by 子华 on 2017/5/24.
 * 申请接口的缓存数据
 */
public class ApplyInter {

    private Integer id;

    private String applyNo;

    private String appKey;

    private String interfaceCode;

    private Integer interfaceStatus;

    private String departmentCode;

    private String interfaceDepartment;

    private String interfaceName;

    private List<ApplyInterColumn> applyInterColumns;

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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public Integer getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(Integer interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }

    public List<ApplyInterColumn> getApplyInterColumns() {
        return applyInterColumns;
    }

    public void setApplyInterColumns(List<ApplyInterColumn> applyInterColumns) {
        this.applyInterColumns = applyInterColumns;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getInterfaceDepartment() {
        return interfaceDepartment;
    }

    public void setInterfaceDepartment(String interfaceDepartment) {
        this.interfaceDepartment = interfaceDepartment;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String colunm2Str(){
        if(null==applyInterColumns || applyInterColumns.size()==0) return "";
        StringBuffer sb = new StringBuffer();
        for (ApplyInterColumn colunm:applyInterColumns) {
            sb.append(colunm.getColumnCode()).append(",");
        }
        return  sb.substring(0,sb.length()-1);
    }
}
