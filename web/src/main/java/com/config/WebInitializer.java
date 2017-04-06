package com.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by hs on 2017/4/6.
 */
@Order(2)
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // spring root config
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    // web context
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MvcConfig.class};
    }

    // DispatcherServlet url
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
