package com.meesho.notification.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.Objects;

@Configuration
public class RedisConfig {

    private final RedisProperties redisProperties;

    public RedisConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());

        JedisConnectionFactory jedisConnectionFactory =  new JedisConnectionFactory();
        Objects.requireNonNull(jedisConnectionFactory.getPoolConfig()).setMinIdle(redisProperties.getMinIdleConnections());
        jedisConnectionFactory.getPoolConfig().setMaxIdle(redisProperties.getMaxIdleConnections());
        jedisConnectionFactory.getPoolConfig().setMaxTotal(redisProperties.getMaxTotalConnections());
        jedisConnectionFactory.getPoolConfig().setMaxWait(Duration.ofMillis(redisProperties.getCommandTimeout()));

        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
