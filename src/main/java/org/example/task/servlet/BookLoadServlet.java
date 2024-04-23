package org.example.task.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.task.service.FileNameRecipient;
import org.example.task.util.LoggerAssistant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Servlet class for uploading a book to the server.
 */
@WebServlet("/load-book")
@MultipartConfig
public class BookLoadServlet extends HttpServlet {

    /**
     * A method that processes a POST-request to upload a book to the server.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String loadBooksPath = "D:\\apache-tomcat-10.1.20-windows-x64\\apache-tomcat-10.1.20\\webapps";
        LoggerAssistant.logInfo("Forming the path to the folder where books will be loaded on the server");

        Part filePart = req.getPart("file");
        LoggerAssistant.logInfo("Reading a book file from a request");

        String fileName = FileNameRecipient.getFileName(filePart);
        LoggerAssistant.logInfo("Getting the name of the loaded file");

        String filePath = loadBooksPath + File.separator + fileName;
        LoggerAssistant.logInfo("Generating the full path to the load file");

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = filePart.getInputStream().read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            resp.getWriter().println("Book loaded successfully");
            LoggerAssistant.logInfo("Successfully writing a book file to the server");
        } catch (IOException e) {
            LoggerAssistant.logError("Error loading file to server", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Error loading the book");
        }
    }
}
