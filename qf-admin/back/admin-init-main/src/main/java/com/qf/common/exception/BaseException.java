package com.qf.common.exception;

/**
 * @author : sin
 * @date : 2023/12/13 11:19
 * @Description : 自定义异常类
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常信息
     */
    private String errMessage;

    public BaseException() {

    }

    public BaseException(String code, String errMessage) {
        this.code = code;
        this.errMessage = errMessage;
    }

    public String getCode() {
        return code;
    }

    public String getErrMessage() {
        return errMessage;
    }
}