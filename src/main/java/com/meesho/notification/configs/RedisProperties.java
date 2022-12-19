package com.meesho.notification.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "redis")
@Configuration
public class RedisProperties {

    private String host;
    private int port;
    private int database;
    private String password;
    private int maxIdleConnections;
    private int minIdleConnections;
    private int maxTotalConnections;
    private int commandTimeout;

}
