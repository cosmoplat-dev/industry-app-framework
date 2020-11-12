package com.cosmoplat.common.bysiness;

import java.io.Serializable;

public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = -3756093330406208742L;

    private final static String NO_LOGIN_MSG = "登录已失效，请重新登录！";

    private final static String CODE_SUCCESS = "200";

    private T data;

    private String code;

    private String msg;

    private Boolean isSuccess;

    private String imgHost;

    public ResponseVo() {
        this.code = CODE_SUCCESS;
        this.msg = "请求成功";
        this.setIsSuccess(true);
    }

    public ResponseVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(Boolean success) {
        this.isSuccess = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getImgHost() {
        return imgHost;
    }

    public void setImgHost(String imgHost) {
        this.imgHost = imgHost;
    }

    public static <T> ResponseVo<T> ok() {
        ResponseVo resp = new ResponseVo();
        resp.setCode(CODE_SUCCESS);
        resp.setData(null);
        resp.setIsSuccess(true);
        return resp;
    }

    public static <T> ResponseVo<T> ok(T data) {
        ResponseVo resp = new ResponseVo();
        resp.setCode(CODE_SUCCESS);
        resp.setData(data);
        resp.setIsSuccess(true);
        return resp;
    }

    public static <T> ResponseVo<T> ok(String code, T data) {
        ResponseVo resp = new ResponseVo();
        resp.setCode(code);
        resp.setData(data);
        resp.setIsSuccess(true);
        return resp;
    }

    public static <T> ResponseVo<T> fail(String error) {
        ResponseVo resp = new ResponseVo();
        resp.setMsg(error);
        resp.setIsSuccess(false);
        return resp;
    }

    public static <T> ResponseVo<T> fail(String code, String error) {
        ResponseVo resp = new ResponseVo();
        resp.setCode(code);
        resp.setMsg(error);
        resp.setIsSuccess(false);
        return resp;
    }

    public static <T> ResponseVo<T> fail(String code, String error, T data) {
        ResponseVo resp = new ResponseVo();
        resp.setCode(code);
        resp.setMsg(error);
        resp.setData(data);
        resp.setIsSuccess(false);
        return resp;
    }

    public static <T> ResponseVo<T> noLogin() {
        ResponseVo resp = new ResponseVo();
        resp.setCode("timeout");
        resp.setMsg(NO_LOGIN_MSG);
        resp.setIsSuccess(false);
        return resp;
    }
    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"'+
                '}';
    }
}
