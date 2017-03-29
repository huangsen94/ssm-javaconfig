package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by hs on 2017/3/2.
 */
@Controller
public class BaseController {

    /**
     * 统一异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        System.out.println("BaseController handleException !");
        return "error-404";
    }
}
