package com.mapsa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Entity
@Table(name ="CART" )
@SequenceGenerator(
        name="cart_seq",
        sequenceName = "CART_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Cart {
    @Id
    @Column(name = "ID", table = "CART",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cart_seq")
    private long id;
    @Basic
    @Column(name = "TOTAL_PRICE", table = "CART")
    private long totalPrice;
    @Basic
    @Column(name = "DATE_CREATE", table = "CART")
    private Timestamp dateCreate;
    @Basic
    @Column(name = "STATUS", table = "CART")
    private String status;
    @Basic
    @Column(name = "QUANTITY", table = "CART")
    private byte quantity;
    @Basic
    @Column(name = "FLIGHT_ID", table = "CART")
    private long flightId;
    @Basic
    @Column(name = "ACCOUNT_ID", table = "CART")
    private long accountId;

}
