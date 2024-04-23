package org.example.task.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.task.util.LoggerAssistant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Servlet class for downloading a book from a server.
 */
@WebServlet("/book")
public class BookDownloadServlet extends HttpServlet {

    /**
     * A method that processes a GET-request to download a book.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String booksPath = "D:\\apache-tomcat-10.1.20-windows-x64\\apache-tomcat-10.1.20\\webapps";
        LoggerAssistant.logInfo("Getting the path to the books folder");

        String fileName = req.getParameter("bookFileName");
        LoggerAssistant.logInfo("Getting the book file name from a request");

        String filePath = booksPath + File.separator + fileName;
        LoggerAssistant.logInfo("Generating the full path to the book file");

        String encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");
        LoggerAssistant.logInfo("Setting the Content-Disposition header to specify the file name");

        resp.setContentType("application/octet-stream");
        LoggerAssistant.logInfo("Setting the content type for the response");

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             OutputStream outputStream = resp.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            resp.getWriter().println("Book downloaded successfully");
            LoggerAssistant.logInfo("Successfully reading the book file and sending it to the client");
        } catch (IOException e) {
            LoggerAssistant.logError("Error reading book file or sending data to client: ", e);
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println("Error downloading the book");
        }
    }
}
