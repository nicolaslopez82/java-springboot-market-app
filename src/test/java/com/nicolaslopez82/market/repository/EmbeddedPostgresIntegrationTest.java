package com.nicolaslopez82.market.repository;


import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.repository.ProductRepository;
import com.nicolaslopez82.market.persistence.entity.Producto;
import com.nicolaslopez82.market.persistence.mapper.ProductMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ExtendWith(EmbeddedPostgresConfiguration.EmbeddedPostgresExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {EmbeddedPostgresConfiguration.class})
public class EmbeddedPostgresIntegrationTest {

    @Autowired
    private ProductRepository productoRepository;

    @Autowired
    ProductMapper productMapper;

    @Test
    void givenEmbeddedPostgres_whenSavePerson_thenSavedEntityShouldBeReturnedWithExpectedFields(){
        Producto producto = new Producto();
        producto.setNombre("New Producto");

        Product product = productMapper.toProduct(producto);

        Product savedProduct = productoRepository.save(product);
        Assertions.assertNotNull(savedProduct.getProductId());
        Assertions.assertEquals(product.getProductName(), savedProduct.getProductName());
    }
}
