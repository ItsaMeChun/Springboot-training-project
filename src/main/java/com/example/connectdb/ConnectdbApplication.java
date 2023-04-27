package com.example.connectdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ServletComponentScan("com.example.connectdb.repository")
//@ComponentScan("com.example.connectdb.repository")

@EnableAutoConfiguration
@Configuration
@SpringBootApplication
@ComponentScan
public class ConnectdbApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConnectdbApplication.class, args);
	}
}
