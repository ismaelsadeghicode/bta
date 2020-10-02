package com.example.btafeignclient.client;

import com.example.btafeignclient.data.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "bta-server-service")
public interface CustomerClient {
    @GetMapping("/customer")
    List<Customer> findCustomers();
    @GetMapping("/customer/{id}")
    Customer findCustomer(@PathVariable Long id);
    @PostMapping("/customer")
    Customer  save(Customer customer);
}
