package com.jiang.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class Result<T> {

    private static final String successCode = "0000";
    private static final String errorCode = "-1";
    private static final String Msg = "处理成功";
    private static final String erroeMsg = "处理失败";

    private String code;
    private String url;
    private String message;
    private Date timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T Data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public Result(){
        this.code = successCode;
        this.timestamp = new Date();
        this.message = Msg;
    }

    public Result(String code ,String message,String url){
        this();
        this.code = code;
        this.message = message;
        this.url = url;
        this.Data = null;
    }

    public Result(String code ,String message,String url,T data){
        this();
        this.code = code;
        this.message = message;
        this.Data = data;
    }

    public Result(String code ,String message){
        this();
        this.code = code;
        this.message = message;
        this.Data = null;
    }

    public Result(T data){
        this();
        this.Data = data;
    }
    public static Result fail(ErrorType errorType){
        return new Result(errorType.getCode(),errorType.getMesg());
    }
    public static Result fail(ErrorType errorType,String url,Object data){
        return new Result(errorType.getCode(),errorType.getMesg(),url,data);
    }
    public static Result fail(String code ,String message,String url){
        return new Result(code ,message,url);
    }
    public static Result fail(String code ,String message){
        return new Result(code,message);
    }
    public static Result fail(){
        return new Result(errorCode,erroeMsg);
    }
    public static Result fail(Object data){
        return new Result(errorCode,erroeMsg,null,data);
    }
    public static Result success(Object data){
        return new Result(successCode,Msg,null,data);
    }
    public static Result success(){
        return new Result();
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
