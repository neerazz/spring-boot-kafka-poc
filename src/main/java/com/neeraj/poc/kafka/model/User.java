package com.neeraj.poc.kafka.model;

import lombok.Data;

/**
 * Created on:  Jun 05, 2020
 */
@Data
public class User {
    String fName;
    String lName;
    UserAddress address;
}
