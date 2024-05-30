package com.beta.BRD_ProductService.service;

import com.beta.BRD_ProductService.exception.ProductNotFoundException;
import com.beta.BRD_ProductService.model.ProductRequest;

public interface ProductService {
    Long addproduct(ProductRequest productRequest);

    void deleteProduct(Long id) throws ProductNotFoundException;

    void reduceQuantity(Long id, int quantity);
}
