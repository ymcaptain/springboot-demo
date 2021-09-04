/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jovi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * druid配置类
 */
@Configuration
@ServletComponentScan
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid") //加载时读取指定的配置信息,前缀为spring.datasource.druid
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean StatViewServlet() {
        //设置druid的dashboard访问路径（ip:端口/druid/）
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>(1);
        //durid监控登录账户和密码，这里可以注释掉改为shiro或者别的方式去做访问控制
        map.put("loginUsername", "admin");
        map.put("loginPassword", "admin!");
        //允许访问
        map.put("allow", "");
        //设置属性进注册servlet
        bean.setInitParameters(map);
        return bean;
    }
}