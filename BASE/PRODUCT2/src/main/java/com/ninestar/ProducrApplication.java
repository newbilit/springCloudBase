package com.ninestar;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableEurekaClient
@EnableOAuth2Sso
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProducrApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProducrApplication.class, args);
	}
}
