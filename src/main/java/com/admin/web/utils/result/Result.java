package com.admin.web.utils.result;


import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 3604972003323896788L;

    private final  static int OK = 200;
    private final  static int ERROR = 500;

    private Integer code;       //返回码
    private String message;     //返回消息
    private Object data;        //返回数据

    // 1.成功
    public static Result  success(Object data){
        return new Result(OK,"操作成功",data);
    }

    // 2.成功
    public static Result  success(String message,Object data){
        return new Result(OK,message,data);
    }

    // 3.成功
    public static Result  success(){
        return new Result(OK,"操作成功",null);
    }


    // 1.失败
    public static Result  error(){
        return new Result(ERROR,"操作失败",null);
    }

    // 2.失败
    public static Result  error(String message){
        return new Result(ERROR,message,null);
    }

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
