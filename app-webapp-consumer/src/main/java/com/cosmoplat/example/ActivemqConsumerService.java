package com.cosmoplat.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 27279
 */
@Component
public class ActivemqConsumerService {
    private final static Logger log = LoggerFactory.getLogger(ActivemqConsumerService.class);
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
      */
    // 使用JmsListener配置消费者监听的队列
    @JmsListener(destination = "test")
    public void handleMessage(String msg) {
        log.info("服务端成功接收queue消息成功：{}",msg);
    }

//    @JmsListener(destination = "myActiveMQQueue")
//    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
//    @SendTo("outQueue")
//    public String handleMessage2(String msg) {
//        log.info("成功接受msg: {}",msg);
//        return "成功接受msg" + msg;
//    }
    // 使用JmsListener配置消费者监听的队列
    @JmsListener(destination = "myActiveMQTopic")
    public void handleMessage1(String msg) {
        log.info("消费者1成功接收topic消息成功：{}", msg);
    }

    // 使用JmsListener配置消费者监听的队列
    @JmsListener(destination = "myActiveMQTopic")
    public void handleMessage2(String msg) {
        log.info("消费者2成功接收topic消息成功：{}", msg);
    }

}
