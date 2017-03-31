package com.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hs on 2017/3/31.
 */
@Configuration
@ComponentScan(basePackages = {"com.ssm.service"})
public class ServiceConfig {
}
