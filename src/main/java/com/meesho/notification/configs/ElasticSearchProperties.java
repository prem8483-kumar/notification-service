package com.meesho.notification.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "es")
@Configuration
public class ElasticSearchProperties {
    private String host;
    private int port;

    private String userName;
    private String password;
}
