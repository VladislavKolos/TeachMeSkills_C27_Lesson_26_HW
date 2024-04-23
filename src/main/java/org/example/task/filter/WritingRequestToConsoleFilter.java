package org.example.task.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.example.task.util.LoggerAssistant;

import java.io.IOException;
import java.util.Date;

/**
 * Filter class for logging the processing time of each request.
 */
@WebFilter({"/book", "/load-book"})
public class WritingRequestToConsoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method that logs request processing time.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        LoggerAssistant.logInfo("Declaration and initialization of a variable responsible for the beginning of the request processing time");

        filterChain.doFilter(servletRequest, servletResponse);
        LoggerAssistant.logInfo("Passing control to the next filter or servlet to process the request");

        long endTime = System.currentTimeMillis();
        LoggerAssistant.logInfo("Declaration and initialization of a variable responsible for the end of the request processing time");

        long duration = endTime - startTime;
        LoggerAssistant.logInfo("Declaration and initialization of a variable responsible for the duration of request processing time");

        System.out.println("Request processed in " + duration + " milliseconds at " + new Date());
        LoggerAssistant.logInfo("Displaying information to the console about the duration of request processing");
    }

    @Override
    public void destroy() {
    }
}
