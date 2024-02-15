package com.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    // Singleton instance
    private static final MyLogger instance = new MyLogger();

    // Logger instance
    private final Logger logger;

    // Private constructor to prevent instantiation
    private MyLogger() {
        // Create the logger instance
        logger = LoggerFactory.getLogger(MyLogger.class);
    }

    // Get the singleton instance
    public static MyLogger getInstance() {
        return instance;
    }

    // Log an info message
    public void info(String message,Object obj) {
        logger.info(message);
    }
    public void info(String message) {
        logger.info(message);
    }

    // Log an error message with an exception
    public void error(String message, Object obj) {
        logger.error(message, obj);
    }
}
