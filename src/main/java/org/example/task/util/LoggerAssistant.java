package org.example.task.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger class for writing logs to the console.
 */
public class LoggerAssistant {
    private static final Logger logger = LogManager.getLogger(LoggerAssistant.class);

    private LoggerAssistant() {

    }

    /**
     * Method for logging information messages.
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Method for logging errors.
     */
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}