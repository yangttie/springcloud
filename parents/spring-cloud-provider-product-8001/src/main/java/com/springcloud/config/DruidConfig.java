package com.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
//为了解决 数据源采用的是Druid，目前更新 GitHub 中的数据源配置，只有重启服务才能获取新配置，不然获取不到。

@Configuration
public class DruidConfig {

    @RefreshScope //刷新配置
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

}
