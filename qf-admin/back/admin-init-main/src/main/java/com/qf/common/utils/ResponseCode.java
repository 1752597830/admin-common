package com.qf.common.utils;


/**
 * @author sin
 * @date 2020/12/2 15:05
 * @description 响应码
 */
public enum ResponseCode {

    SUCCESS("00000", "一切ok"),
    FAIL("500", "失败"),
    LOGIN_ERROR("501", "登录失败"),
    VERIFY_CODE_ERROR("4001", "验证码错误"),
    NO_LOGIN("401", "未登录"),
    NO_PERMISSION("403", "权限不足，请联系管理员!"),
    NO_ACCESS("504", "没有访问权限"),
    NO_DATA("505", "没有数据"),
    NO_EXIST("404", "资源不存在");

    private String code;

    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
