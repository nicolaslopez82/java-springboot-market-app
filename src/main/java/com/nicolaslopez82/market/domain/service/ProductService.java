package com.nicolaslopez82.market.domain.service;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProductById(id);
    }

    public Optional<List<Product>> getProductsByCategoryId(int id) {
        return productRepository.getProductsByCategoryId(id);
    }

    public Optional<List<Product>> getScarceProducts(int quantity) {
        return productRepository.getProductsByCategoryId(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int id) {
        return productRepository.getProductById(id).map(product -> {
            productRepository.delete(id);
            return true;
        }).orElse(false);
    }

}
