package com.example.clientflightapp.client;

import com.example.clientflightapp.client.Data.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class CustomerRegisteryClient {
    @Value("${uri.register}")
    private String uri;
    private  RestTemplate restTemplate;
    public List<Customer> custumers(){
      restTemplate =new RestTemplate();
        ResponseEntity<List<Customer>> listResponseEntity=restTemplate.exchange(uri,
                HttpMethod.GET, null
                , new ParameterizedTypeReference<List<Customer>>() {
                });
        List<Customer> customers=listResponseEntity.getBody();
     
        return customers;
    }
    public ResponseEntity<Customer> save(Customer customer) throws URISyntaxException {
        restTemplate=new RestTemplate();
        URI uri1=new URI(uri);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Customer> request=new HttpEntity<>(customer,httpHeaders);
        ResponseEntity<Customer> result=restTemplate.postForEntity(uri1,request,Customer.class);
        return result;

    }
}
