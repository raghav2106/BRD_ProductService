package com.beta.BRD_ProductService.service;

import com.beta.BRD_ProductService.entity.Product;
import com.beta.BRD_ProductService.exception.ProductCreationException;
import com.beta.BRD_ProductService.exception.ProductNotFoundException;
import com.beta.BRD_ProductService.model.ProductRequest;
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
        try{
            log.info("addproduct method : start");
            Product product = Product.builder()
                    .productName(productRequest.getProductName())
                    .price(productRequest.getPrice())
                    .img(productRequest.getImg())
                    .quantity(productRequest.getQuantity())
                    .createdBy(productRequest.getCreatedBy())
                    .build();
            productRepository.save(product);
            log.info("addproduct method : end");
            return product.getProductId();
        }catch (Exception ex){
            log.error("failed to execute add product method "+ex.getMessage());
            throw new ProductCreationException("Failed to add product "+ ex.getMessage());
        }

    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
