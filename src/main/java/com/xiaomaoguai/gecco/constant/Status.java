package com.xiaomaoguai.gecco.constant;

/**
 * Created by Administrator on 12/4/2016.
 */
public enum Status {
    TAKE("11010301","在业"),EXISTENCE("11010302","存续"),REVOKE("11010303","吊销"),LOGOUT("11010304","注销");

    private  final String statusCode;
    private  final String text;

    public String getStatusCode() {
        return statusCode;
    }

    public String getText() {
        return text;
    }

    private Status(String statusCode, String text) {
        this.statusCode = statusCode;
        this.text=text;
    }
}
