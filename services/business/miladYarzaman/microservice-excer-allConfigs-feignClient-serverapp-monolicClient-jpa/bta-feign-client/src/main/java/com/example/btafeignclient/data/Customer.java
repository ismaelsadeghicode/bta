package com.example.btafeignclient.data;

import lombok.Data;

@Data
public class Customer {
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String subscribNumber;
    protected String nationality;
}
