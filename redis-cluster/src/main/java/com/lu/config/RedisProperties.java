package com.lu.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/16 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisProperties {

    private int expireSeconds;

    private String nodes;

    private int commandTimeout;
}
