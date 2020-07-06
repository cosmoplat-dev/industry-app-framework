package com.cosmoplat.examplecontroller;

import com.cosmoplat.emq.config.MqttPushClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 27279
 */
@RestController
@RequestMapping("Mqtt")
public class MqttProviderController {
    private final static Logger log = LoggerFactory.getLogger(MqttProviderController.class);
    @Autowired
    private MqttPushClient mqttPushClient;

    @Value("${spring.emq.topic}")
    private String kdTopic;

    @PostMapping("/sendMqtt")
    public String sendHello(String pushMessage){
        mqttPushClient.publish(0, false, kdTopic, pushMessage);
        log.info("Mqtt消息已发送, topic:{},Message:{}",kdTopic,pushMessage);
        return  pushMessage;
    }


}
