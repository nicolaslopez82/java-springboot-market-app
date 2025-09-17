package com.nicolaslopez82.market.persistence;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.repository.ProductRepository;
import com.nicolaslopez82.market.persistence.CRUD.ProductoCRUDRepository;
import com.nicolaslopez82.market.persistence.entity.Producto;
import com.nicolaslopez82.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCRUDRepository productoCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    public ProductoRepository() {}

    public ProductoRepository(ProductoCRUDRepository crudRepository) {}

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getProductsByCategoryId(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.getProductosLessThanAndEstadoOrderByCategoria(quantity, true);
        return productos.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Producto producto = productoCrudRepository.findByIdProducto(productId);
        return Optional.of(productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productoCrudRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
