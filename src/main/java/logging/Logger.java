/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.io.FileWriter;
import java.io.IOException;
// import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * A logger for errors and messages
 */
public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    
    private boolean useStdOut;
    private boolean useLogFile;
    private boolean useMemory;
    private String filePath;
    
    public ArrayList<String> inMemoryLog;
    
    /**
     * Default constructor, will not log until logging features are manually enabled
     */
    public Logger() {
        useStdOut = false;
        useLogFile = false;
        useMemory = false;
        
        this.inMemoryLog = new ArrayList<>();
        filePath = "./log.txt";
    }
    
    /**
     * Turn on logging to standard output
     * @return Self
     */
    public Logger useStdOut() {
        this.useStdOut = true;
        
        return this;
    }
    
    /**
     * Turn on logging to a text file
     * @return 
     */
    public Logger useMemory() {
        this.useMemory = true;
        
        return this;
    }
    
    /**
     * Turn on logging to a text file
     * @return 
     */
    public Logger useLogFile() {
        this.useLogFile = true;
        
        return this;
    }
    
    /**
     * Set an alternate path for the log file
     * @param path Path to a file
     * @return Self
     */
    public Logger alternatePath(String path) {
        this.filePath = path;
        
        return this;
    }
    
    /**
     * Logs a message, used for general status notifications
     * @param message Message to be logged
     */
    public void logMessage(String message) {
        String messageWithDate;
        
        if (useStdOut) {
            messageWithDate = LocalDateTime.now().toString() + textInGreen(" MESSAGE: ") + message;
            System.out.println(messageWithDate);
        }
        
        if (useMemory) {
            messageWithDate = LocalDateTime.now().toString() + " MESSAGE: " + message;
            inMemoryLog.add(messageWithDate);
        }
        
        if (useLogFile) {
            messageWithDate = LocalDateTime.now().toString() + " MESSAGE: " + message;
            
            FileWriter out = null;
            try {
                out = new FileWriter(filePath, true);
                out.write(messageWithDate + "\n");
                out.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Logs an error, used for when encountering an exceptional or a fatal situation
     * @param message Error message to be logged
     */
    public void logError(String message) {
        String messageWithDate;
        
        if (useStdOut) {
            messageWithDate = LocalDateTime.now().toString() + textInRed(" ERROR: ") + message;
            System.out.println(messageWithDate);
        }
        
        if (useMemory) {
            messageWithDate = LocalDateTime.now().toString() + " ERROR: " + message;
            inMemoryLog.add(messageWithDate);
        }
        
        if (useLogFile) {
            messageWithDate = LocalDateTime.now().toString() + " ERROR: " + message;
            
            FileWriter out = null;
            try {
                out = new FileWriter(filePath, true);
                out.write(messageWithDate + "\n");
                out.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Surrounds given text with ANSI colour codes indicating red
     * @param text
     * @return 
     */
    private String textInRed(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }
    
    /**
     * Surrounds text with ANSI colour codes indicating green
     * @param text
     * @return 
     */
    private String textInGreen(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }
}
