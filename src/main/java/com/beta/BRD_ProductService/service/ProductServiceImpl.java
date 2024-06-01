package com.beta.BRD_ProductService.service;

import com.beta.BRD_ProductService.entity.Product;
import com.beta.BRD_ProductService.exception.ProductCreationException;
import com.beta.BRD_ProductService.exception.ProductInsufficientQuantityException;
import com.beta.BRD_ProductService.exception.ProductNotFoundException;
import com.beta.BRD_ProductService.model.ProductRequest;
import com.beta.BRD_ProductService.repository.ProductRepository;
import com.beta.BRD_ProductService.utils.Roles;
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
                    .createdBy(String.valueOf(Roles.ADMIN))
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

    @Override
    public void reduceQuantity(Long id, int quantity) {

        log.info("reduceQuantity method :: start");
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product with id " + id + " not found"));

        if(product.getQuantity() < quantity){
            throw  new ProductInsufficientQuantityException("Insufficient quantity available");
        }
        if(quantity != 0){
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            log.info("Product quantity updated successfully");
        }
    }
}
