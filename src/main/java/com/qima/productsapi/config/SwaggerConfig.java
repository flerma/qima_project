package com.qima.productsapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Products API",
        version = "1.0",
        description = "Products API documentation"
    )
)
public class SwaggerConfig {
}
