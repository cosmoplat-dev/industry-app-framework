package com.cosmoplat.example;

import com.cosmoplat.emq.config.MqttPushClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author 27279
 */
@Component
public class MqttConsumerRunner implements ApplicationRunner {
    private final static Logger log = LoggerFactory.getLogger(MqttConsumerRunner.class);
    @Autowired
    private MqttPushClient mqttPushClient;

    @Value("${spring.emq.topic}")
    private String kdTopic;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        mqttPushClient.subscribe(kdTopic);
        log.info("------已订阅---Topic:"+kdTopic);
    }
}
