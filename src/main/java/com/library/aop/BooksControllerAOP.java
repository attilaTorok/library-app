package com.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BooksControllerAOP {

	private Logger logger = LoggerFactory.getLogger(ServiceAOP.class);

	@Before("booksControllers()")
	public void beforeBooksControllers(JoinPoint joinPoint){
		logger.info("Allowed execution for {}", joinPoint);
	}

	@Pointcut("execution(* com.library.view.books.controller.*.*(..))")
	public void booksControllers() {}

}
