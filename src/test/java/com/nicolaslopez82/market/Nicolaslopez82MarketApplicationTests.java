//package com.nicolaslopez82.market;
//
//import com.nicolaslopez82.market.domain.Category;
//import com.nicolaslopez82.market.domain.Product;
//import com.nicolaslopez82.market.domain.repository.ProductRepository;
//import com.nicolaslopez82.market.domain.service.ProductService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//@SpringBootTest
//class Nicolaslopez82MarketApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//    @Autowired
//    private ProductService productService;
//
//
//    @Test
//    public void getProductIdTest(){
//        final List<Product> products = productService.findAll();
//        Assertions.assertEquals(products.get(1).getProductId(),2);
//        Assertions.assertEquals(products.get(5).getProductName(),"Tomate");
//        Assertions.assertTrue(products.stream().anyMatch(product -> product.getProductId()>=1));
//    }
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Test
//    public void productRepository_SaveProduct_ReturnAProduct() {
//
//        //Arrange
//        Product product = new Product();
//        //product.setProductId(100);
//        product.setProductName("Test");
//        product.setCategoryId(1);
//        product.setPrice(5000);
//        product.setStock(10);
//        product.setActive(true);
//
//        Category category = new Category();
//        category.setCategoryId(8);
//        category.setCategory("Despensa");
//        category.setActive(true);
//
//        product.setCategory(category);
//
//        //Act
//
//        Product productResult = productRepository.save(product);
//
//        //Assert
//
//        Assertions.assertNotNull(productResult);
//    }
//}
