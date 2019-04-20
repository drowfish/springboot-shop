package com.example.exception;

import com.example.util.Result;
import com.example.util.stateAndMessage.StateAndMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defultExcepitonHandler(HttpServletRequest request, Exception e){

        if(e instanceof LoginException){
            return new Result(StateAndMessage.FAIL,e.getMessage(),null);
        }
        e.printStackTrace();
        System.out.println(e.getMessage());
        System.out.println("未知异常");
        return new Result();
    }
}
