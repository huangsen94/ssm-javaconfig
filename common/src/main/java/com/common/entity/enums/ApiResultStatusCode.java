package com.common.entity.enums;

/**
 * Created by hs on 2017/3/22.
 */
public enum ApiResultStatusCode {
    SUCCESS("200", "success"),
    FAIL("500", "fail"),
    NO_RECORD("1000", "no record");

    private String code;
    private String msg;

    private ApiResultStatusCode(String code, String msg) {
        this.code = code;
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
}
