package com.xiaomaoguai.gecco.constant;

/**
 * Created by Administrator on 12/4/2016.
 */
public enum CurrencyType{
    RMB("000201","人民币"),DOLLARS("000202","美元"),POUND("000203","英镑"),EURO("000204","欧元");

    private final String currencyTypeCode;
    private final String text;
    public String getCurrencyTypeCode() {
        return currencyTypeCode;
    }

    public String getText() {
        return text;
    }

    CurrencyType(String currencyTypeCode, String text) {
        this.currencyTypeCode = currencyTypeCode;
        this.text = text;
    }
}
