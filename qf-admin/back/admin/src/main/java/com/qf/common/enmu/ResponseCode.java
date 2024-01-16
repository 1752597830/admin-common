package com.qf.common.enmu;

/**
 * @author : sin
 * @date : 2024/1/14 12:33
 * @Description : 响应码
 */
public enum ResponseCode {

    SUCCESS(200, "一切ok"),
    FAIL(500, "失败"),
    LOGIN_ERROR(501, "登录失败"),
    VERIFY_CODE_ERROR(502, "验证码错误"),
    NO_LOGIN(401, "未登录"),
    NO_PERMISSION(403, "权限不足，请联系管理员!"),
    NO_ACCESS(504, "没有访问权限"),
    NO_DATA(505, "没有数据"),
    NO_EXIST(404, "资源不存在"),

    //数据库操作错误码
    OPT_ERROR(1001, "");

    private Integer code;

    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
