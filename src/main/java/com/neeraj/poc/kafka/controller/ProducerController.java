package com.neeraj.poc.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neeraj.poc.kafka.model.Country;
import com.neeraj.poc.kafka.model.User;
import com.neeraj.poc.kafka.model.UserAddress;
import com.neeraj.poc.kafka.service.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.management.modelmbean.InvalidTargetObjectTypeException;

/**
 * Created on:  Jun 04, 2020
 */

@RestController
public class ProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) throws InvalidTargetObjectTypeException {
        String sendMessage = (String) kafkaProducer.sendMessage(message);
        return new ResponseEntity<>(sendMessage, HttpStatus.ACCEPTED);
    }

    @PostMapping("/send")
    public ResponseEntity<User> sendMessage(@RequestBody User user) throws InvalidTargetObjectTypeException {
        User sendUser = (User) kafkaProducer.sendMessage(user);
        return new ResponseEntity<>(sendUser, HttpStatus.ACCEPTED);
    }
}
