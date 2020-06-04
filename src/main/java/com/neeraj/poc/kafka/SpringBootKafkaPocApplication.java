package com.neeraj.poc.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootKafkaPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaPocApplication.class, args);
	}

}
