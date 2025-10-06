
package com.nicolaslopez82.market.domain.service;

import com.nicolaslopez82.market.domain.Product;
import com.nicolaslopez82.market.domain.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Given a call to the service method findAll(), it should return a List<Product>.")
    @Test
    void findAll() {

        List<Product> products = Mockito.mock(List.class);
        Mockito.when(productRepository.getAll()).thenReturn(products);
        List<Product> productList = productService.findAll();
        Assertions.assertNotNull(productList);
    }


    @DisplayName("Given a Product ID, when we call to the service method getProduct(id)," +
    " we expect that the product is returned.")
    @Test
    void getProduct() {
        Integer id = 1;

        Product productMocked = new Product();
        productMocked.setProductId(id);
        productMocked.setProductName("productNameTest");
        productMocked.setCategoryId(1);
        productMocked.setPrice(10);
        productMocked.setStock(100);
        productMocked.setActive(true);

        Mockito.when(productRepository.getProductById(id)).thenReturn(Optional.of(productMocked));
        Optional<Product> product = productService.getProduct(id);

        Assertions.assertTrue(product.isPresent());
        Assertions.assertNotNull(product.get());
        Assertions.assertEquals(productMocked.getProductId(), product.get().getProductId());
        Mockito.verify(productRepository, Mockito.times(1)).getProductById(id);
    }

    @DisplayName("Given a Product, that we want to create " +
            "when we call to 'save()', we expect that the product is created.")
    @Test
    void save() {
        Product productMocked = new Product();
        productMocked.setProductName("productNameTest");
        productMocked.setCategoryId(1);
        productMocked.setPrice(10);
        productMocked.setStock(100);
        productMocked.setActive(true);

        Product productExpected = new Product();
        productExpected.setProductName("productNameTest");
        productExpected.setCategoryId(1);
        productExpected.setStock(100);
        productExpected.setPrice(10);
        productExpected.setActive(true);

        Mockito.when(productRepository.save(productMocked)).thenReturn(productMocked);

        Product result = productService.save(productMocked);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(productExpected.getProductName(), result.getProductName(), "The name of the product is incorrect");

        Mockito.verify(productRepository, Mockito.times(1)).save(productMocked);
    }

    @DisplayName("Given a Product id, it should be deleted after call the delete service method.")
    @Test
    void delete() {
        Product productMocked = new Product();
        productMocked.setProductId(1);
        productMocked.setProductName("productNameTest");
        productMocked.setCategoryId(1);
        productMocked.setPrice(10);
        productMocked.setStock(100);
        productMocked.setActive(true);

        int productId = 1;

        Mockito.when(productRepository.getProductById(productId)).thenReturn(Optional.of(new Product()));
        Mockito.doNothing().when(productRepository).delete(productId);

        Assertions.assertTrue(productService.delete(productId));
    }
}
