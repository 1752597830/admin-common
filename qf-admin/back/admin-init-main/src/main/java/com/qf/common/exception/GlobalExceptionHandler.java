package com.qf.common.exception;

import com.qf.common.utils.BaseResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : sin
 * @date : 2023/11/26 13:27
 * @Description : 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException e) {
        return BaseResponse.fail(e.getCode(), e.getErrMessage());
    }
}