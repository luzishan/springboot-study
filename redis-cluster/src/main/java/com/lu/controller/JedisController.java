package com.lu.controller;

import com.lu.config.RedisConfig;
import com.lu.config.RedisProperties;
import com.lu.service.IJedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * @author lzs
 * @version 1.0
 * @date 2020/12/16 15:36
 */
@RestController
public class JedisController {

    @Autowired
    private RedisProperties redisProperties;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private IJedisClient jedisClient;

    @RequestMapping(value = "/getRedisValue")
    public String getRedisValue() {
        System.out.println(redisProperties.toString());
        Map<String, JedisPool> clusterNodes = redisConfig.getJedisCluster().getClusterNodes();
        for (Map.Entry<String, JedisPool> temp : clusterNodes.entrySet()) {
            System.out.println(temp);
        }
        System.out.println(jedisClient.get("runoob"));
        return jedisClient.get("runoob");
    }
}
