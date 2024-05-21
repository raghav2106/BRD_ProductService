package com.beta.BRD_ProductService.controller;

import com.beta.BRD_ProductService.exception.ProductNotFoundException;
import com.beta.BRD_ProductService.model.ProductRequest;
import com.beta.BRD_ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Long> addProduct( @RequestBody ProductRequest productRequest){
        Long prodId = productService.addproduct(productRequest);
        return new ResponseEntity<>(prodId, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);

        }
}

