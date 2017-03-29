package com.config;

import com.exception.ExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by hs on 2017/3/29.
 */
@Configuration
@ComponentScan( basePackages = "com.controller" )
public class MvcConfig extends WebMvcConfigurerAdapter {


    /* 配置视图解析器 */
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /* 异常拦截器 */
    @Bean
    public ExceptionHandler exceptionResolver() {
        return new ExceptionHandler();
    }
}
