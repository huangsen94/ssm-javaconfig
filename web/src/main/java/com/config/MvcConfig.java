package com.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.common.interceptor.TraceInterceptor;
import com.exception.ExceptionHandler;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hs on 2017/3/29.
 */
@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.controller" )
public class MvcConfig extends WebMvcConfigurerAdapter {

    //static resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor traceInterceptor = new TraceInterceptor();
        InterceptorRegistration registration = registry.addInterceptor(traceInterceptor);
        registration.addPathPatterns("/**");
    }

    /* 配置fastjson */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 messageConverter4 = new FastJsonHttpMessageConverter4();
        ArrayList<MediaType> supportMediaTypes = Lists.newArrayList(
                MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE),
                MediaType.parseMediaType("text/html;charset=UTF-8"));
        messageConverter4.setSupportedMediaTypes(supportMediaTypes);
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setFeatures(
                Feature.AllowArbitraryCommas,
                Feature.AllowUnQuotedFieldNames,
                Feature.DisableCircularReferenceDetect);
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect
        );

        converters.add(0, messageConverter4);
    }

    /* 配置视图解析器 */
    @Bean
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
