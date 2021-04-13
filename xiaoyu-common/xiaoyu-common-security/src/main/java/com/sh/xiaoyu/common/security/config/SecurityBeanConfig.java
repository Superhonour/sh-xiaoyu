package com.sh.xiaoyu.common.security.config;

import com.sh.xiaoyu.common.security.service.ClientDetailsServiceImpl;
import com.sh.xiaoyu.common.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * 说明：
 *
 * @Title : SecurityBeanConfig.java
 * @Package com.sh.xiaoyu.common.security.config
 * @See: {@link SecurityBeanConfig}<br/>
 * Copyright: Copyright (c) 2017<br/>
 * Company:sany huax witsight team by product
 * @Author : liuwd7
 * @Date: 2021-04-13 14:40:15
 * @version: V1.0
 */
@Configuration
public class SecurityBeanConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
        return new ClientDetailsServiceImpl();
    }
}