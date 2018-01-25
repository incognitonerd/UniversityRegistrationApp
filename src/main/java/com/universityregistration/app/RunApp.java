package com.universityregistration.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.universityregistration"})
// @EntityScan({"com.universityregistration"})
// @EnableJpaRepositories({"com.universityregistration"})
public class RunApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(RunApp.class);
	}
	
	public static void main(String[] args){
		SpringApplication.run(RunApp.class, args);
	}
}