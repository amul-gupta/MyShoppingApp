package com.example.MyShoppingApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(
				title = "MyShoppingApp",
				description = "REST API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "myname",
						email = "myemail"
				)
		)
)

@SpringBootApplication
public class MyShoppingAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyShoppingAppApplication.class, args);
		System.out.println("Welcome to MyShopping application!!!");

	}

}
