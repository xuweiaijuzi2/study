package com.xuwei.iot.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 测试类
 * @Author : Sherlock
 * @Date : 2023/8/1 16:35
 */
@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttSendClient mqttSendClient;

    @GetMapping(value = "/publishTopic")
    public String publishTopic(String topic, String sendMessage) {
        System.out.println("topic:" + topic);
        System.out.println("message:" + sendMessage);
        this.mqttSendClient.publish(false, topic, sendMessage);
        return "topic:" + topic + "\nmessage:" + sendMessage;
    }

}
