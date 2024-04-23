package org.example.task.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.task.util.LoggerAssistant;

/**
 * A class that reports when an application starts and stops.
 */
@WebListener
public class AppListener implements ServletContextListener {

    /**
     * Method called when the application starts.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web-application is starting");
        LoggerAssistant.logInfo("Launching a web-application");
    }

    /**
     * Method called when the application stops.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web-application is shutting down");
        LoggerAssistant.logInfo("Closing a web application");
    }
}
