package com.aissue.entity;

/**
 * Created by YS on 2017/3/9.
 */
public class Effect<T> {

    /**
     * 表示结果，根据情景设置结果字符串,默认是00
     */
    private String code="00";

    /**
     * 结果的解释
     */
    private String msg="成功";

    private String data = "";

    /**
     * 需要返回的数据
     */
    private T datas;

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public static Effect init(String code,String msg){
        Effect effect = new Effect();
        effect.setCode(code);
        effect.setMsg(msg);
        return effect;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
