package com.neeraj.poc.kafka.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created on:  Jun 04, 2020
 */

@Component
@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {
    private String bootstrapServer;
    private String topic;
    private String consumerGroupId;
}
