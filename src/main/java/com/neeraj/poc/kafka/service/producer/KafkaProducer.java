package com.neeraj.poc.kafka.service.producer;

import com.neeraj.poc.kafka.model.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created on:  Jun 04, 2020
 */

@Service
public class KafkaProducer {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    public String sendMessage(String message) {
        String transformedMessage = LocalDateTime.now() + " Server :" + message;
        stringKafkaTemplate.send(kafkaProperties.getTopic(), transformedMessage);
        return transformedMessage;
    }
}
