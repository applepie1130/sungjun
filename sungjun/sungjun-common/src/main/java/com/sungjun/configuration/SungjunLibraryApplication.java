package com.sungjun.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages ="com.sungjun.configuration")
public class SungjunLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SungjunLibraryApplication.class, args);
	}
}
