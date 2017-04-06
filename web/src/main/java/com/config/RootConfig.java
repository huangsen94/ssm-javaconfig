package com.config;

import com.ssm.config.DaoConfig;
import com.ssm.config.ServiceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Created by hs on 2017/3/29.
 */
@Configuration
@Import({DaoConfig.class, ServiceConfig.class})
public class RootConfig {

}
