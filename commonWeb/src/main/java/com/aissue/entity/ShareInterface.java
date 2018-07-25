package com.aissue.entity;

public class ShareInterface {
    private String interfaceCode;
    private String invokeType;
    private Integer timeOut;

    public ShareInterface(String interfaceCode,String invokeType,Integer timeOut){
        this.interfaceCode = interfaceCode;
        this.invokeType = invokeType;
        this.timeOut = timeOut;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(String invokeType) {
        this.invokeType = invokeType;
    }

    public boolean equals(Object obj) {
        int hashCode = this.hashCode();
        if(obj instanceof ShareInterface){
            ShareInterface other = (ShareInterface)obj;
            int otherHashCode = other.hashCode();
            if(hashCode == otherHashCode){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        String str = this.toString();
        return str.hashCode();
    }

    @Override
    public String toString() {
        return this.getInterfaceCode()+this.getInvokeType()+this.getTimeOut();
    }
}
