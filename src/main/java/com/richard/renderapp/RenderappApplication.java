package com.richard.renderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RenderappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenderappApplication.class, args);
	}
}

// Add this REST controller class inside the same file or separately
@RestController
class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello, World";
	}
}
