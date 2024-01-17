package com.qf.common.exception;

import com.qf.common.enmu.ResponseCode;
import com.qf.common.util.BaseResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: sin
 * @Description  全局异常处理
 */


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException e) {
        return BaseResponse.fail(e.getCode(), e.getErrMessage());
    }

    /**
     * 处理参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse handleValidationExceptions(MethodArgumentNotValidException e) {
        String msg  =e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return BaseResponse.fail(ResponseCode.VALID_ERROR.getCode(), msg == null ? ResponseCode.VALID_ERROR.getMsg() : msg);
    }
}