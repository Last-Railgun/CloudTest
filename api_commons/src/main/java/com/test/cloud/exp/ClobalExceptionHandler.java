package com.test.cloud.exp;

import com.test.cloud.resp.ResultData;
import com.test.cloud.resp.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ClobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception ex) {
        log.error("全局异常捕获:", ex.getMessage(), ex);
        return ResultData.fail(ReturnCode.RC500.getCode(), ex.getMessage());
    }
}
