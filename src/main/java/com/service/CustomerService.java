package com.service;

import com.models.Customer;

import java.util.Random;

public class CustomerService {


    public static Customer createCustomer() {
        Random random = new Random();
        int age = random.nextInt(15,110);
        return new Customer("vasek@gmail.com",age);
    }
}
