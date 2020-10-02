package com.example.btafeignclient.controller;

import com.example.btafeignclient.client.CustomerClient;
import com.example.btafeignclient.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer-client")
public class CustomerController {
    @Autowired
    CustomerClient customerClient;
   @GetMapping("/{id}")
    public ResponseEntity<Customer> customer(@PathVariable Long id){

        return ResponseEntity.ok(customerClient.findCustomer(id));
    }
    @GetMapping
    public ResponseEntity<List<Customer>> customers(){

        return ResponseEntity.ok(customerClient.findCustomers());
    }
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerClient.save(customer));
    }
}
