package com.example.uberHttpBackend.controller;

import com.example.uberHttpBackend.mqtt.gateway.MqttGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/mqtt")
@RequiredArgsConstructor
public class MqttController {
    @Autowired
    private final MqttGateway mqttGateway;

    @PostMapping("/send")
    public String sendMsg(String data) {
        mqttGateway.sendToMqtt(data);
        return "success";
    }

    /**
     * 发送mqtt消息
     *
     * @param data  负载
     * @param topic 话题
     * @return
     */
    @PostMapping("/topic/send")
    public String sendMsg(String data, String topic) {
        mqttGateway.sendToMqtt(data, topic);
        return "success";
    }
}
