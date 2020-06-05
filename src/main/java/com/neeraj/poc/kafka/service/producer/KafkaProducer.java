package com.neeraj.poc.kafka.service.producer;

import com.neeraj.poc.kafka.model.KafkaProperties;
import com.neeraj.poc.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
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

    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public Object sendMessage(Object message) throws InvalidTargetObjectTypeException {
        if (message instanceof String) {
            return sendStringMessage((String) message);
        } else if (message instanceof User) {
            return sendUserMessage((User) message);
        }
        throw new InvalidTargetObjectTypeException("Message " + message + " is not valid.");
    }

    private User sendUserMessage(User user) {
        userKafkaTemplate.send(kafkaProperties.getUserTopic(), user);
        return user;
    }

    public String sendStringMessage(String message) {
        String transformedMessage = LocalDateTime.now() + " Server :" + message;
        stringKafkaTemplate.send(kafkaProperties.getStringTopic(), transformedMessage);
        return transformedMessage;
    }
}
