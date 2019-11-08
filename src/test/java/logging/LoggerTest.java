/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sami
 */
public class LoggerTest {
    
    public LoggerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Logger logger;
    
    @Before
    public void setUp() {
        logger = new Logger().useLogFile();
    }
    
    @After
    public void tearDown() {
        File file = new File("log.txt");
        
        try {
            Files.deleteIfExists(file.toPath());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void writingMessageWorks() {
        logger.logMessage("Hello World");
    }
    
    @Test
    public void writingErrorWorks() {
        logger.logError("Hello World");
    }
    
    @Test
    public void afterWritingLogFileExists() {
        logger.logMessage("Hello World");
            
        assert (new File("log.txt").exists());
    }
    
    @Test
    public void afterWritingErrorLogFileExists() {
        logger.logError("Hello World");
            
        assert (new File("log.txt").exists());
    }
    
    @Test
    public void afterWritingFileContainsMessage() {
        BufferedReader reader = null;
        try {
            logger.logMessage("Hello World");
            reader = new BufferedReader(new FileReader("log.txt"));
            assert (reader.lines().anyMatch(line -> line.contains("Hello World")));
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void afterWritingFileContainsError() {
        BufferedReader reader = null;
        try {
            logger.logError("Hello World");
            reader = new BufferedReader(new FileReader("log.txt"));
            assert (reader.lines().anyMatch(line -> line.contains("Hello World")));
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LoggerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void writingToInMemoryLogWorks() {
        logger.useMemory();
        
        logger.logMessage("Hello, World!");
        
        assert(logger.inMemoryLog.size() > 0);
    }
}
