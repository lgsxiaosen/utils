package com.github.lgsxiaosen.utils.utils;

/**
 * @author: xiaosen
 * 返回状态码
 */
public enum ResponseCode {
    SERVER_STATUS_ERROR("6000", "server状态错误"),
    URL_NOT_FOUND("404", "该请求不存在"),
    BAD_REQUEST("400", "错误的请求，请求格式不规范，不符合API要求"),
    METHOD_NOT_ALLOWED("405", "请求的方式错误"),
    CSRF_TOKEN_MISSING("40000", "CSRF token missing or incorrect"),
    SUCCEED("200", "成功"),
    ERROR("500", "失败"),
    VALIDATE_FAIL("10002", "数据校验失败"),
    GET_BY_PARAM_ERROR("10003", "根据参数获取结果失败，数据不存在"),
    SYSTEM_ERROR("500", "系统错误"),
    NO_AUTHENTICATED("20001", "未认证"),
    CONNECT_ERROR("20002", "链接错误"),
    NO_PER("10004", "权限不足"),
    UPDATEFAIL("10005", "修改失败"),
    SYSTEM_BUSY("10006", "系统繁忙"),
    NOTEXISTINFO("10007", "信息不存在"),
    ARGUMENTERROR("400001", "参数有误"),
    SUBMIT_AGAIN("10009", "重复提交");

    private String val;
    private String msg;

    private ResponseCode(String value, String msg) {
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return this.val;
    }

    public String msg() {
        return this.msg;
    }


}
