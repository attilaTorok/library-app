package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot entry point with annotation configurations.
 * 
 * @author Török Attila
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories("com.library.repository.repository.dao")
@EnableAspectJAutoProxy
@SpringBootApplication
public class LibraryApplication extends SpringBootServletInitializer {

	/**
	 * Entry point.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        //context.getBean(Populate.class).initData(); // <-- here
	}

}
