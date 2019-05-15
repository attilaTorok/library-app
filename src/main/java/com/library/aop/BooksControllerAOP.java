package com.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * BooksControllerAOP class is a spring aspect for handle logging in the {@link com.library.view.books.controller books.controller} package.
 * 
 * @author Török Attila
 */
@Aspect
@Configuration
public class BooksControllerAOP {

	private Logger logger = LoggerFactory.getLogger(ServiceAOP.class);

	/**
	 * Logging before controller's methods.
	 * 
	 * @param joinPoint A joinpoint is a candidate point in the Program Execution of the application where an
	 * aspect can be plugged in. This point could be a method being called,
	 * an exception being thrown, or even a field being modified. These are the points where your aspect’s code
	 * can be inserted into the normal flow of your application to add new behavior.
	 */
	@Before("booksControllers()")
	public void beforeBooksControllers(JoinPoint joinPoint){
		logger.info("Allowed execution for {}", joinPoint);
	}

	/**
	 * Define a pointcut for every method in the com.library.view.books.controller package.
	 */
	@Pointcut("execution(* com.library.view.books.controller.*.*(..))")
	public void booksControllers() {}

}
