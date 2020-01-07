package com.fun.feifun.base.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * 统一返回实体类
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {




    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty(value = "放回信息", required = true)
    private String msg;
    @ApiModelProperty(value = "数据", required = true)
    private T data;

    /**
     * 构造方法
     */
    private Result(int code,String msg,T data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    private Result(IReMsg reMsg,T data){
        this(reMsg.getCode(),reMsg.getMessage(), data);
    }


    //成功的返回
    public static <T> Result<T> success() {
        return new Result<>(ReMsg.SUCCESS,null);
    }
    public static <T> Result<T> success( T t) {
        return new Result<>(ReMsg.SUCCESS, t);
    }
    public static <T> Result<T> success( IReMsg reMsg) {
        return new Result<>(reMsg, null);
    }
    public static <T> Result<T> success( String msg) {
        return new Result<>(ReMsg.SUCCESS.getCode(), msg,null);
    }

    //失败的返回
    public static <T> Result<T> err() {
        return new Result<>(ReMsg.FAILURE,null);
    }
    public static <T> Result<T> err(IReMsg reMsg) {
        return new Result<>(reMsg, null);
    }
    public static <T> Result<T> err(String msg) {
        return new Result<>(400, msg,null);
    }
}
