package com.digital_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class DigitalLibraryAlphaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLibraryAlphaApplication.class, args);
	}

}
