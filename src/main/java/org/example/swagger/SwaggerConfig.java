package org.example.swagger;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title(
                                        "Quantity Measurement API"
                                )
                                .version("1.0")
                                .description(
                                        "UC17 Spring Boot REST API"
                                )
                );
    }
}
