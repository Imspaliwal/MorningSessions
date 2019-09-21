package com.advance.test;

import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	static Logger logger = org.apache.logging.log4j.LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		
		System.out.println("\n 	Hello Log!	\n");
		
		logger.info("This is information message");
		logger.warn("This is warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
	
		System.out.println("\n	Completed");
		
	}
}
