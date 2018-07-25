package com.aissue.entity;

import java.util.Date;
import java.util.List;

public class InterfaceInfo {
    private Integer id;

    private String interfaceDepartment;

    private String interfaceName;

    private String interfaceCode;

    private Integer interfaceType;

    private String featuresDescription;

    private String url;
    private String queryCondition;
    private  String dataSource;

    private String dataFormat;

    private String useScenes;

    private String reqExample;

    private String returnExample;

    private Date createTime;

    private String invokeType;

    private String netUrl;

    private String interfaceStatus;

//    private List<InterfaceColmn> interfaceColmnList;
    private String departmentName;

    private String linkMan;

    private String linkTel;

    private String sharedType;

    private String systemCode;

    private String interfaceVersion;

    private String registerUnit;//接口注册单位部门编码

    private String registerName;//接口注册单位部门名称 add by wangkun，表无需该字段

    private String failReturnExample;

    private String fileName;

    private String fileUrl;

    private String aService;//提供服务

    private String isPlateFile;//是否是版式文件

    public String getIsPlateFile() {
        return isPlateFile;
    }

    public void setIsPlateFile(String isPlateFile) {
        this.isPlateFile = isPlateFile;
    }

    public String getaService() {
        return aService;
    }

    public void setaService(String aService) {
        this.aService = aService;
    }

    private String interfaceCodeNew;

    public String getInterfaceCodeNew() {
        return interfaceCodeNew;
    }

    public void setInterfaceCodeNew(String interfaceCodeNew) {
        this.interfaceCodeNew = interfaceCodeNew;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSharedType() {
        return sharedType;
    }

    public void setSharedType(String sharedType) {
        this.sharedType = sharedType;
    }
    public String getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        this.queryCondition = queryCondition;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getInterfaceStatus() {
        return interfaceStatus;
    }

    public void setInterfaceStatus(String interfaceStatus) {
        this.interfaceStatus = interfaceStatus;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode == null ? null : interfaceCode.trim();
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getFeaturesDescription() {
        return featuresDescription;
    }

    public void setFeaturesDescription(String featuresDescription) {
        this.featuresDescription = featuresDescription == null ? null : featuresDescription.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat == null ? null : dataFormat.trim();
    }

    public String getUseScenes() {
        return useScenes;
    }

    public void setUseScenes(String useScenes) {
        this.useScenes = useScenes == null ? null : useScenes.trim();
    }

    public String getReqExample() {
        return reqExample;
    }

    public void setReqExample(String reqExample) {
        this.reqExample = reqExample == null ? null : reqExample.trim();
    }

    public String getReturnExample() {
        return returnExample;
    }

    public void setReturnExample(String returnExample) {
        this.returnExample = returnExample == null ? null : returnExample.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType;
    }

    public String getNetUrl() {
        return netUrl;
    }

    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl;
    }

//    public List<InterfaceColmn> getInterfaceColmnList() {
//        return interfaceColmnList;
//    }
//
//    public void setInterfaceColmnList(List<InterfaceColmn> interfaceColmnList) {
//        this.interfaceColmnList = interfaceColmnList;
//    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getRegisterUnit() {
        return registerUnit;
    }

    public void setRegisterUnit(String registerUnit) {
        this.registerUnit = registerUnit;
    }

    public String getFailReturnExample() {
        return failReturnExample;
    }

    public void setFailReturnExample(String failReturnExample) {
        this.failReturnExample = failReturnExample;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}