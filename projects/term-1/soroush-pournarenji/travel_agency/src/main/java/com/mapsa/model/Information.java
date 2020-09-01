package com.mapsa.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "INFORMATION")
@SequenceGenerator(
        name="information_seq",
        sequenceName = "INFORMATION_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Information {
    @Id
    @Column(name = "ID", table = "INFORMATION",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "information_seq")
    private long id;
    @Column(name = "FIRST_NAME", table = "INFORMATION")
    private String firstName;
    @Column(name = "LAST_NAME", table = "INFORMATION")
    private String lastName;
    @Column(name = "NATIONAL_CODE", table = "INFORMATION")
    private String nationalCode;
    @Column(name = "PHONE", table = "INFORMATION")
    private String phone;
    @Column(name = "AGE", table = "INFORMATION")
    private byte age;
    @Column(name = "ADDRESS", table = "INFORMATION")
    private String address;
    @Column(name = "ACCOUNT_ID", table = "INFORMATION")
    private long accountId;

}
