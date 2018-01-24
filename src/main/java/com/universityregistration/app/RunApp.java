package com.universityregistration.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.universityregistration"})
//@EntityScan({"com.universityregistration"})
//@EnableJpaRepositories({"com.universityregistration"})
public class RunApp extends SpringBootServletInitializer {
	public static void main(String[] args){
		System.out.println("testing webhook");
		SpringApplication.run(RunApp.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(RunApp.class);
	}
}