package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.App;

@Configuration
@ComponentScan("com.library.converter")
@EnableJpaRepositories(basePackages = "com.library.repository")
@Import({ DataSourceConfig.class, JpaConfig.class })
public class AppConfig {

	@Bean
	public App app() {
		return new App();
	}
	
}
