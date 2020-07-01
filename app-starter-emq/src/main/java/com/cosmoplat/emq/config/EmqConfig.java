package com.cosmoplat.emq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 27279
 */
@PropertySource(value = {"application-emq.yml",
}, encoding = "utf-8",factory = YamlConfigFactory.class)
@Configuration
public class EmqConfig {
    @Value("${spring.emq.host}")
    private String host;
    @Value("${spring.emq.username}")
    private String username;
    @Value("${spring.emq.password}")
    private String password;

    @Value("${spring.emq.timeout}")
    private Integer timeout;
    @Value("${spring.emq.keepalive}")
    private Integer keepalive;
    @Value("${spring.emq.clientid}")
    private String clientId;
    @Value("${spring.emq.topic}")
    private String topic;

    @Autowired
    private MqttPushClient mqttPushClient;

    @Bean
    public MqttPushClient getMqttPushClient(){
        mqttPushClient.connect(host, clientId, username, password, timeout,keepalive);
        return mqttPushClient;
    }
}
