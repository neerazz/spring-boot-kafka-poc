package com.neeraj.poc.kafka.model;

import lombok.Data;

/**
 * Created on:  Jun 05, 2020
 */
@Data
public class UserAddress {

    String line1;
    String line2;
    String city;
    String state;
    Country country;
}
