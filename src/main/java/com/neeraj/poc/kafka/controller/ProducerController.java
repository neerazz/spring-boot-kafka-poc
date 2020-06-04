package com.neeraj.poc.kafka.controller;

import com.neeraj.poc.kafka.service.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on:  Jun 04, 2020
 */

@RestController
public class ProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        return new ResponseEntity<>(kafkaProducer.sendMessage(message), HttpStatus.ACCEPTED);
    }
}
