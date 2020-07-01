package com.cosmoplat.examplecontroller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 27279
 */
@RestController
@RequestMapping("activemq")
@Api(value = "ActiveMQProviderController",description = "发送ActiveMQController")
public class ActiveMQProviderController {
    private final static Logger log = LoggerFactory.getLogger(ActiveMQProviderController.class);
    /**
     * 注入存放消息的队列，用于下列方法一
     */
    @Autowired
    private ActiveMQQueue activeMQQueue;

    @Autowired
    private ActiveMQTopic activeMQTopic;
    /**
     * 注入springboot封装的工具类
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 点对点模式
     * @param msg
     */
    @PostMapping("sendToQueue")
    @ApiOperation(httpMethod = "POST",value = "发送点对点消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "msg", paramType = "query",   dataType = "String",  value = "要发送的消息信息!")
    })
    public void send(String msg) {
        //方法一：添加消息到消息队列
        jmsMessagingTemplate.convertAndSend(activeMQQueue, msg);

        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        jmsMessagingTemplate.convertAndSend("test", msg);
        log.info("--客户端发送消息成功--");
    }

    /**
     * 发布模式
     */
    @PostMapping("sendToTopic")
    @ApiOperation(httpMethod = "POST",value = "发送发布模式消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "msg",    paramType = "query",  dataType = "String",  value = "要发送的消息信息!")
    })
    public void sendMessage(String msg){

        //发送消息
        jmsMessagingTemplate.convertAndSend(activeMQTopic, msg);
        log.info("--客户端发送消息成功--");

    }

}
