package com.guvi.SpringWebflux.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String id;
    private String name;
    private int quantity;
    private double price;

    // Constructors, getters, and setters
}

