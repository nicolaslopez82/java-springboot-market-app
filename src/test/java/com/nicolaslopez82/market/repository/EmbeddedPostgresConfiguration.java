package com.nicolaslopez82.market.repository;

import com.nicolaslopez82.market.persistence.ProductoRepository;
import com.nicolaslopez82.market.persistence.entity.Producto;
import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import jakarta.activation.DataSource;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;

@Configuration
@EnableJpaRepositories(basePackageClasses = ProductoRepository.class)
@EntityScan(basePackageClasses = Producto.class)
public class EmbeddedPostgresConfiguration {
    private static EmbeddedPostgres embeddedPostgres;

    @Bean
    public DataSource dataSource() throws IOException {
        embeddedPostgres = EmbeddedPostgres.builder()
                .setImage(DockerImageName.parse("postgres:14.1"))
                .start();

        return (DataSource) embeddedPostgres.getPostgresDatabase();
    }

    public static class EmbeddedPostgresExtension implements AfterAllCallback {
        @Override
        public void afterAll(ExtensionContext context) throws Exception {
            if (embeddedPostgres == null) {
                return;
            }
            embeddedPostgres.close();
        }
    }
}
