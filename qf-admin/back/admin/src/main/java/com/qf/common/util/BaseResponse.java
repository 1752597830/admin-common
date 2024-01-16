package com.qf.common.util;

import com.qf.common.enmu.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : sin
 * @date : 2024/1/14 12:32
 * @Description : 结果响应封装
 */
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;


    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> success() {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMsg());
        return response;
    }

    public static <T> BaseResponse<T> success(String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
    public static <T> BaseResponse<T> fail(String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResponseCode.FAIL.getCode());
        response.setMsg(msg);
        return response;
    }
    public static <T> BaseResponse<T> fail(Integer code, String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}