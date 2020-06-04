package com.neeraj.poc.kafka.service.consumer;

import com.neeraj.poc.kafka.model.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on:  Jun 04, 2020
 */
@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumerGroupId}")
    public void consume(ConsumerRecord<String, String> record) {
        log.info("Consumed kafka record: {}", record);
        log.info("Consumed String message: {}", record.value());
    }
}
