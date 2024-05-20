package com.beta.BRD_ProductService.service;

import com.beta.BRD_ProductService.ProductRequest;
import com.beta.BRD_ProductService.entity.Product;
import com.beta.BRD_ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addproduct(ProductRequest productRequest) {
        Product product = Product.builder()
                        .productName(productRequest.getProductName())
                                .price(productRequest.getPrice())
                                        .img(productRequest.getImg())
                                                .quantity(productRequest.getQuantity())
                .createdBy(productRequest.getCreatedBy())
                .build();
         productRepository.save(product);
       return product.getProductId();
    }
}
