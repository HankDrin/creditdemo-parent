package com.service.web.conf;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.service.common.tool.jackson.SnakeCaseDeserializer;
import com.service.common.tool.jackson.SnakeCaseKeySerializer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@Configuration
public class WebMvcConfig {

    @Bean
    public ResultModelWrapperConverter getResultModelWrapperConverter() {
        return new ResultModelWrapperConverter();
    }

    /**
     * 自定义jackson反序列化策略(Map类型驼峰Key转下划线)
     * 该bean在容器中由spring-boot自动识别配置,
     * 详见{@link JacksonAutoConfiguration}
     *
     * @return
     */
    @Bean
    public SimpleModule getSimpleModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addKeySerializer(String.class, new SnakeCaseKeySerializer());
        simpleModule.addDeserializer(Map.class, new SnakeCaseDeserializer());
        return simpleModule;
    }

    @Bean
    public ParameterNameDiscoverer getParameterNameDiscoverer(){
        return new DefaultParameterNameDiscoverer();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
