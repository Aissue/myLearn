package com.aissue.exception;

import java.io.Serializable;

public class BizException extends RuntimeException implements Serializable{

    private String code;

    public BizException(String code,String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
