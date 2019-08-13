package com.github.lgsxiaosen.utils.utils;

/**
 * @author: xiaosen
 * @date: 2018/11/29 13:33
 * @description: 公共返回类
 */
public class ResponseResult<T> {

    private String code;
    private String message;
    private T data;
    private String requestId;
    private Long requestTime;
    private Long responseTime;


    public ResponseResult() {
        this.setCode(ResponseCode.SUCCEED.val());
        this.setMessage(ResponseCode.SUCCEED.msg());
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(T data) {
        this.setCode(ResponseCode.SUCCEED.val());
        this.setMessage(ResponseCode.SUCCEED.msg());
        this.setResponseTime(System.currentTimeMillis());
        this.setData(data);
    }

    public ResponseResult(T data, Long requestTime, String requestId) {
        this.setCode(ResponseCode.SUCCEED.val());
        this.setMessage(ResponseCode.SUCCEED.msg());
        this.setData(data);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
        this.setRequestId(requestId);
    }

    public ResponseResult(ResponseCode code, Long requestTime) {
        this.setCode(code.val());
        this.setMessage(code.msg());
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(ResponseCode code, Long requestTime, String requestId) {
        this.setCode(code.val());
        this.setMessage(code.msg());
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
        this.setRequestId(requestId);
    }

    public ResponseResult(ResponseCode code, T data, Long requestTime) {
        this.setCode(code.val());
        this.setMessage(code.msg());
        this.setData(data);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(ResponseCode code, String message) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(ResponseCode code, String message, Long requestTime) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(ResponseCode code, String message, Long requestTime, String requestId) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
        this.setRequestId(requestId);
    }

    public ResponseResult(ResponseCode code, String message, T data, Long requestTime) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setData(data);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
    }

    public ResponseResult(ResponseCode code, String message, T data, Long requestTime, String requestId) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setData(data);
        this.setRequestTime(requestTime);
        this.setResponseTime(System.currentTimeMillis());
        this.setRequestId(requestId);
    }


    public String getCode() {
        return this.code;
    }

    public void setCode(ResponseCode code) {
        this.code = code.val();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }


}
