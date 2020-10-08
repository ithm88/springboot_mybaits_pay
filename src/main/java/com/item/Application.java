package com.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/*
* @apringBootApplicaiton相当于三个注解
* @configuration 定义一个配置类
* @EnableAutoConfiguration spring boot 自动根据jar包的依赖来自动配置项目
* @ComponentScan spring 自动扫描类上的注解,并注入spring容器
* */

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    // redis 转json格式,第二种
    @Bean   //创建一个redis连接工厂
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        //创建redis的Template对象
        RedisTemplate redisTemplate=new RedisTemplate();
        //设置redis连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }


}
