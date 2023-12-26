package com.example.pdfcreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class PdfcreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfcreatorApplication.class, args);
	}
	@Configuration
	@EnableAsync
	public class AsyncConfig {
		// Configuration for asynchronous processing
	}
}
