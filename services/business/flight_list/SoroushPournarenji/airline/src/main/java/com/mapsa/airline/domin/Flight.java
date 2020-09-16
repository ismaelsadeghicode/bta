package com.mapsa.airline.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    @NotBlank(message = "Origin is empty")
    private String origin;
    @NotBlank(message = "Destination is empty")
    private String destination;
    @NotNull(message = "Quantity is empty")
    @Range(min = 0, max = 200, message = "Quantity range(0-200)")
    private Integer quantity;
    @NotNull(message = "Fee is empty")
    @Range(min = 0, message = "Fee greater than zero")
    private Long fee;
    private String description;
}
