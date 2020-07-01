package com.cosmoplat.model;

/**
 * @author 27279
 */
public class ResponseMsg {
    public static final String NO_METHOD = "调用失败,m参数错误";
    public static final String SYS_ERROR = "调用失败";
    public static final String JSON_ERROR = "调用失败,json参数不能为空";
    public static final String PROCESS_ERROR = "调用失败,处理异常";
    public static final String TOKEN_ERROR = "请求拒绝,token校验失败";
    public static final String SUCCESS = "调用成功";
    public ResponseMsg() {
    }
}
