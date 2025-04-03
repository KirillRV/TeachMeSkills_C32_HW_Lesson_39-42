package com.tms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "Spring Boot REST Market",
        version = "1.0",
        description = "This is a simple market application on Spring Boot with REST API.  This API allows users to...",
        termsOfService = "https://reges.com/terms",
        contact = @Contact(
                name = "Kirill Reges",
                url = "https://www.reges.com/contact",
                email = "kirillreges639@gmail.com"
        ),
        license = @License(
                name = "Apache 2.0",
                url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
))
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}