package com.mapsa.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name ="P" )
@SequenceGenerator(
        name="p_seq",
        sequenceName = "P_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class P {
    @Id
    @Column(name = "ID", table = "P",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "p_seq")
    private long id;
    @Basic
    @Column(name = "PERSON_ID", table = "P")
    private long personId;
    @Basic
    @Column(name = "ACCOUNT_ID", table = "P")
    private long accountId;
}
