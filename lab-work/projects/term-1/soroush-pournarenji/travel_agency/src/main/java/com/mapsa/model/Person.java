package com.mapsa.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="PERSON" )
@SequenceGenerator(
        name="person_seq",
        sequenceName = "PERSON_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Person {
    @Id
    @Column(name = "ID", table = "PERSON",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "person_seq")
    private long id;
    @Column(name = "FIRST_NAME", table = "PERSON")
    private String firstName;
    @Column(name = "LAST_NAME", table = "PERSON")
    private String lastName;
    @Column(name = "NATIONAL_CODE", table = "PERSON")
    private String nationalCode;
    @Column(name = "PHONE", table = "PERSON")
    private String phone;
    @Column(name = "AGE", table = "PERSON")
    private String age;
    @Column(name = "ACCOUNT_ID", table = "PERSON")
    private long accountId;

}
