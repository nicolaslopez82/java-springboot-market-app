/*
package com.nicolaslopez82.market.repository;

import com.nicolaslopez82.market.domain.Category;
import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Random;

@SpringBootTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ProductTest {

    @Test
    void contextLoads() {
    }

    @Autowired
    ProductRepository productRepository;

    @Test
    public void productRepository_SaveProduct_ReturnAProductById() {

        //Arrange
        // Generate a random number between 101 and 200 (inclusive)
        Random random =  new Random();
        int min = 101;
        int max = 200;
        int randomNumberInRange = random.nextInt(max - min + 1) + min;
        Product product = new Product();
        product.setProductId(randomNumberInRange);
        product.setProductName("Test" + randomNumberInRange);
        product.setCategoryId(1);
        product.setPrice(1000);
        product.setStock(10);
        product.setActive(true);

        Category category = new Category();
        category.setCategoryId(8);
        category.setCategory("Despensa");
        category.setActive(true);

        product.setCategory(category);

        //Act
        Product productResult = productRepository.save(product);

        //Assert
        Assertions.assertEquals(productResult.getProductId(), randomNumberInRange);
        Assertions.assertEquals(productResult.getProductName(), "Test" + randomNumberInRange);
    }

}
*/
