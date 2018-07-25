package com.aissue.entity;

import java.util.Date;
import java.util.Map;

/**
 *  2017/3/8.
 * @author 子华
 */
public class InterRequestVo<T> extends Effect<T> {

    /**
     * 请求唯一的UUID 必有
     */
    private String requestId;
    /**
     * 令牌
     * this is a token 必有(老版本)
     */
    private String token;

    /**
     * 应用的APPKEY 必有(新版本)
     */
    private String appKey;
    /**
     * 签名 必有
     */
    private String sign;

    /**
     * 接口编码
     */
    private String interCode;

    /**
     * 请求时间 必有
     */
    private String requestTime;

    /**
     * 接收到时间
     */
    private Date transferBeginTime;

    /**
     * 结束时间
     */
    private Date transferEndTime;

    /**
     * 请求人IP
     */
    private String transferIp;

    /**
     * 接口请求参数信息
     */
    private Map<String,String> params;

    private Map<String,String> headers;

    /**
     * 待请求接口的申请信息
     */
    private ApplyInter applyInter;

    /**
     * 接口统计
     */
    private InterfaceInvokeCount interfaceInvokeCount;


    private RequestInterAccess requestInterAccess;

    /**
     * 请求策略
     */
    private RequestPloy requestPloy;

    /**
     * 应用信息
     */
    private AppInfo appInfo;


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * 二级平台平台编码
     * @return
     */
    private String secondaryPlatform;

    public String getToken() {
        return token;
    }

    public String getInterCode() {
        return interCode;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setInterCode(String interCode) {
        this.interCode = interCode;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getTransferBeginTime() {
        return transferBeginTime;
    }

    public void setTransferBeginTime(Date transferBeginTime) {
        this.transferBeginTime = transferBeginTime;
    }

    public Date getTransferEndTime() {
        return transferEndTime;
    }

    public void setTransferEndTime(Date transferEndTime) {
        this.transferEndTime = transferEndTime;
    }

    public String getTransferIp() {
        return transferIp;
    }

    public void setTransferIp(String transferIp) {
        this.transferIp = transferIp;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public ApplyInter getApplyInter() {
        return applyInter;
    }

    public void setApplyInter(ApplyInter applyInter) {
        this.applyInter = applyInter;
    }

    public InterfaceInvokeCount getInterfaceInvokeCount() {
        return interfaceInvokeCount;
    }

    public void setInterfaceInvokeCount(InterfaceInvokeCount interfaceInvokeCount) {
        this.interfaceInvokeCount = interfaceInvokeCount;
    }

    public RequestPloy getRequestPloy() {
        return requestPloy;
    }

    public void setRequestPloy(RequestPloy requestPloy) {
        this.requestPloy = requestPloy;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public RequestInterAccess getRequestInterAccess() {
        return requestInterAccess;
    }

    public void setRequestInterAccess(RequestInterAccess requestInterAccess) {
        this.requestInterAccess = requestInterAccess;
    }

    public String getSecondaryPlatform() {
        return secondaryPlatform;
    }

    public void setSecondaryPlatform(String secondaryPlatform) {
        this.secondaryPlatform = secondaryPlatform;
    }
}
