package org.example.task.service;

import jakarta.servlet.http.Part;
import org.example.task.util.LoggerAssistant;

/**
 * Recipient service class that receives the file name.
 */
public class FileNameRecipient {

    /**
     * A method that extracts the file name from the Content-Disposition header and returns it.
     */
    public static String getFileName(Part filePart) {
        String contentDisposition = filePart.getHeader("content-disposition");
        LoggerAssistant.logInfo("Getting the value of the Content-Disposition header, which contains information about the file");

        String[] elements = contentDisposition.split(";");
        LoggerAssistant.logInfo("Splitting the header into individual elements separated by ';'");

        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                LoggerAssistant.logInfo("Returning the file name, removing extra spaces and quotes");
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        LoggerAssistant.logInfo("Returning null because the file name could not be found");
        return null;
    }
}
