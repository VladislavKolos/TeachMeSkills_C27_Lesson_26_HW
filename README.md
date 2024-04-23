# TeachMeSkills_C27_Lesson_26_HW

Homework for lesson #26

1. **Task #1**

A web application has been written that, when launched, reports to the console that it is running, and when finished,
reports to the console that it is closing and exits. For a request, a record is displayed in the console with the time
of this request (the duration of this request). 2 endpoints have been created: **"/book"** - which downloads any book
from the server; **"/load-book"** - which loads books to the server. Implemented a logger for writing to the console.
Web-application contains:

- Util class **"LoggerAssistant"** - class for writing logs to the console. Contains: **"logInfo"** method for logging
  information messages; **"logError"** method for logging errors;
- Listener class **"AppListener"** - class that reports when an application starts and stops. Contains: **"
  contextInitialized"** method called when the application starts; **"contextDestroyed"** method called when the
  application stops;
- Filter class **"WritingRequestToConsoleFilter"** - class for logging the processing time of each request. Contains **"
  doFilter"** method that logs request processing time;
- Service class **"FileNameRecipient"** - class that receives the file name. Contains **"getFileName"** method that
  extracts the file name from the **"Content-Disposition"** header and returns it;
- Servlet classes:
- **"BookDownloadServlet"** - class for downloading a book from a server. Contains **"doGet"** method that processes a
  GET-request to download a book;
- **"BookLoadServlet"** - class for uploading a book to the server. Contains **"doPost"** method that processes a
  POST-request to upload a book to the server.

An **"index.jsp"** file created to display the main page of a web-application.
**"WebServlet"**, **"WebFilter"** and **"WebListener"** annotations have also been added to the servlet classes, filter
class and listener class respectively.
The **"log4j2.xml"** file has been created - a configuration file for the **"Log4j 2"** logging library. This file is
used to configure the logging configuration. It contains information about which logging messages should be written to
which files or output devices, and what logging levels should be taken into account.
