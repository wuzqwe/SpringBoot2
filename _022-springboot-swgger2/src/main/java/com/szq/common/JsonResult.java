package com.szq.common;

public class JsonResult {

    private String code;
    private String msg;


    public JsonResult() {
        this.code="200";
        this.msg="操作成功";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
