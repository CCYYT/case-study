package com.example.springDemo.common;

public class Result {
    private Object data;
    private Integer code;
    private String msg;

    public Result(Integer code, Object data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Result ok(int code){
        return ok(code,"","ok");
    }
    public static Result ok(int code,Object data){
        return ok(code,data,"ok");
    }
    public static Result ok(int code,Object data,String msg){
        return new Result(code,data,msg);
    }
    public static Result fail(int code) {
        return fail(code,"fail");
    }
    public static Result fail(int code,String msg){
        return new Result(code,"",msg);
    }
}
