package com.sparta.fk;


import java.io.IOException;
import java.util.logging.*;

public class App
{

    public static final Logger logger = Logger.getLogger(App.class.getName()); // no constructor so use factory class .getLogger

    public static void setUpLogger(){

        setFileHandler();
        configureConsoleHandler();
        configureLogger();

}

    private static void configureLogger() {
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.setFilter(new CustomFilter());
    }

    private static void configureConsoleHandler() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
    }


    private static void setFileHandler() {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logFile.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new XMLFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error setting up FileHandler", e);
        }
    }


    public static void main( String[] args )
    {
        setUpLogger();

        logger.log(Level.INFO, "Hello, this is an info message");
        logger.log(Level.WARNING, "This is a warning message");
        logger.log(Level.FINE, "This is a fine message");
    }
}
