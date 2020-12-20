package com.ecommerce.litil.response;

public class BaseResponse {
    private Object object;
    private String statusDesc;
    private String statusCode;

    public BaseResponse(){

    }

    public BaseResponse(String statusCode , String statusDesc){
        this.statusCode = statusCode;
        this.statusDesc = statusDesc;
    }

    public Object getObject () {
        return object;
    }

    public void setObject ( Object object ) {
        this.object = object;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}
