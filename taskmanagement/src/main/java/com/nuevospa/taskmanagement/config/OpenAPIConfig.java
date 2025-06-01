package com.nuevospa.taskmanagement.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title("Task Management API")
                .version("1.0.0")
                .description("REST API for managing tasks for NUEVO SPA"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("tasks")
            .pathsToMatch("/api/tasks/**", "/api/auth/**")
            .build();
    }
}
