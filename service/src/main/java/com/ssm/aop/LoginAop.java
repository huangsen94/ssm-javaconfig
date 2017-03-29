package com.ssm.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by hs on 2017/3/12.
 */
public class LoginAop {

   public void beforeAdvice() {
       System.out.println("login before...");
   }
}
