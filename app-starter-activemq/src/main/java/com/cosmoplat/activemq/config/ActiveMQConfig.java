package com.cosmoplat.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.jms.Queue;

/**
 * @author 27279
 */
@Configuration
@PropertySource(value = {"classpath:application-activemq.yml",
}, encoding = "utf-8",factory = YamlConfigFactory.class)
public class ActiveMQConfig {

    private static final String TOPIC = "myActiveMQTopic";

    @Bean
    public ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("test");
    }
    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic(TOPIC);
    }
}

