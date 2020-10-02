package com.example.clientflightapp.client.controller;

import com.example.clientflightapp.client.CustomerRegisteryClient;
import com.example.clientflightapp.client.Data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerClientController {
    @Autowired
    CustomerRegisteryClient customerRegisteryClient;
    @GetMapping
    public ResponseEntity<List<Customer>> Customers(){
        return ResponseEntity.ok(customerRegisteryClient.custumers());
    }
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) throws URISyntaxException {
        return customerRegisteryClient.save(customer);
    }
}
