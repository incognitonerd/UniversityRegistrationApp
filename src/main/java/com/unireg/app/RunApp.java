package com.unireg.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.unireg"})
@EnableJpaRepositories({"com.unireg"})
@EntityScan({"com.unireg"})
public class RunApp extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(RunApp.class);
	}
	
	public static void main(String[] args){
		SpringApplication.run(RunApp.class, args);
	}
	// @Bean
	// public DataSource dataSource() {
	// return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	// }
	//
	// @Bean
	// public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	// LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
	// lef.setDataSource(dataSource);
	// lef.setJpaVendorAdapter(jpaVendorAdapter);
	// lef.setPackagesToScan("com.balazsholczer");
	// return lef;
	// }
	//
	// @Bean
	// public JpaVendorAdapter jpaVendorAdapter() {
	// HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	// hibernateJpaVendorAdapter.setShowSql(false);
	// hibernateJpaVendorAdapter.setGenerateDdl(true);
	// hibernateJpaVendorAdapter.setDatabase(org.springframework.orm.jpa.vendor.Database.MYSQL);
	// return hibernateJpaVendorAdapter;
	// }
}