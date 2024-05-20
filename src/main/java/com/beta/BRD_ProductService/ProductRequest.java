package com.beta.BRD_ProductService;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String productName;
    private BigDecimal price;
    private String img;
    private int quantity;
    private String createdBy;
}
