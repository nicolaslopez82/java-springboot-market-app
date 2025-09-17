package com.nicolaslopez82.market.web.controller;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
       return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/products/{categoryId}")
    public Optional<List<Product>> getProductsByCategoryId(int categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

    @PostMapping("/products/product")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/products/product/delete/{id}")
    public void deleteProduct(@PathVariable int productId){
        productService.delete(productId);
    }
}
