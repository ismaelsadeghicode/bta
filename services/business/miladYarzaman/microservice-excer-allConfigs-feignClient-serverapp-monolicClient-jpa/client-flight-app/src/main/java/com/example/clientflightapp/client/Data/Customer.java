package com.example.clientflightapp.client.Data;

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
