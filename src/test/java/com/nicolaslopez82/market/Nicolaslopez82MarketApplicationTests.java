package com.nicolaslopez82.market;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@SpringBootTest
class Nicolaslopez82MarketApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private final ProductService productService = new ProductService();


    @Test
    public void getProductIdTest(){
        final List<Product> products = productService.findAll();
        Assertions.assertEquals(products.get(1).getProductId(),2);
        Assertions.assertEquals(products.get(5).getProductName(),"Tomate");
        Assertions.assertTrue(products.stream().anyMatch(product -> product.getProductId()>=1));
    }
}
