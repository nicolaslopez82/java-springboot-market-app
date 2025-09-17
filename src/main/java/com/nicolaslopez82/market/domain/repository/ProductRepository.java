package com.nicolaslopez82.market.domain.repository;

import com.nicolaslopez82.market.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * This ProductRepository interface talk in terms of Domains.
 */
public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getProductsByCategoryId(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProductById(int productId);
    Product save(Product product);
    void delete(int product);
}
