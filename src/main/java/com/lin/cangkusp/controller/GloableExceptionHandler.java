package com.lin.cangkusp.controller;

import com.lin.cangkusp.common.constant.ConResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloableExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ConResult handleException(Exception e){
        e.printStackTrace();
        return ConResult.error().setMsg(e.getMessage());
    }
}
