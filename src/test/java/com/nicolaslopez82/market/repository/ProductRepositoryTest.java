//package com.nicolaslopez82.market.repository;
//
//import com.opentable.db.postgres.embedded.EmbeddedPostgres;
//import jakarta.activation.DataSource;
//import org.junit.jupiter.api.extension.AfterAllCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import java.io.IOException;
//
//
//@RunWith(SpringRunner.class)
//@Testcontainers
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ProductRepositoryTest {
//
//    private static EmbeddedPostgres embeddedPostgres;
//
//    @Bean
//    public DataSource dataSource() throws IOException {
//        embeddedPostgres = EmbeddedPostgres.builder()
//                .setImage(DockerImageName.parse("postgres:14.1"))
//                .start();
//
//        return embeddedPostgres.getPostgresDatabase();
//    }
//
//    public static class EmbeddedPostgresExtension implements AfterAllCallback {
//        @Override
//        public void afterAll(ExtensionContext context) throws Exception {
//            if (embeddedPostgres == null) {
//                return;
//            }
//            embeddedPostgres.close();
//        }
//    }
//
//    @Container
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13.3")
//            .withDatabaseName("marketapitest")
//            .withUsername("postgres")
//            .withPassword("postgres");
//
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }
//}
