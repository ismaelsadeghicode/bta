package com.mapsa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name ="ACCOUNT" )
@SequenceGenerator(
        name="account_seq",
        sequenceName = "ACCOUNT_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Account {
    @Id
    @Column(name = "ID", table = "ACCOUNT",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "account_seq")
    private long id;
    @Basic
    @Column(name = "USERNAME", table = "ACCOUNT")
    private String username;
    @Basic
    @Column(name = "EMAIL", table = "ACCOUNT")
    private String email;
    @Basic
    @Column(name = "PASSWORD", table = "ACCOUNT")
    private String password;
    @Basic
    @Column(name = "ACTIVE", table = "ACCOUNT")
    private String active="d";


}
