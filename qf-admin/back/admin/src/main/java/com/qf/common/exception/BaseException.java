package com.qf.common.exception;

/**
 * @author : sin
 * @date : 2024/1/14 20:25
 * @Description : 自定义异常处理
 */
public class BaseException extends RuntimeException{

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String errMessage;

    public BaseException() {

    }

    public BaseException(Integer code, String errMessage) {
        this.code = code;
        this.errMessage = errMessage;
    }

    public Integer getCode() {
        return code;
    }

    public String getErrMessage() {
        return errMessage;
    }
}