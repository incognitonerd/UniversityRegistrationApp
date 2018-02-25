package com.unireg.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@ComponentScan({RunApp.PACKAGE_NAME})
@EnableJpaRepositories({RunApp.PACKAGE_NAME})
@EntityScan({RunApp.PACKAGE_NAME})
public class RunApp extends SpringBootServletInitializer {
	public static final String PACKAGE_NAME = "com.unireg";
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(RunApp.class);
	}
	
	public static void main(String[] args){
		SpringApplication.run(RunApp.class, args);
	}
}