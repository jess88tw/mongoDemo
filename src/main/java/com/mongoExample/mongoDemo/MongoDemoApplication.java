package com.mongoExample.mongoDemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Huminerals API collection",
				description = "Huminerals APIs for huminerals operations",
				version = "0.0.1",
				contact = @Contact(email = "jazz88tw@gmail.com")
		)
)
@SpringBootApplication
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

}
