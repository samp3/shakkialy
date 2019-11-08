/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class HTTPStreamTest {
    
    private HTTPStream http;
    
    public HTTPStreamTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void httpStreamGETSuccessful() {
        http = new HTTPStream()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .connect();
        
        String content = http.toString();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(200, http.getHTTPStatus());
    }
    
    @Test
    public void httpStreamGETReturnsContent() {
        http = new HTTPStream()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .connect();
        
        String content = http.toString();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assert(!content.isEmpty());
    }
    
    @Test
    public void httpStreamFunctionsAsAnIterator() {
        http = new HTTPStream()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .connect();
        
        Iterator<String> iterator = http;
        
        boolean containsLine = iterator.hasNext();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assert(containsLine);
    }
    
    @Test
    public void httpStreamGetIteratorReturnsSelf() {
        http = new HTTPStream()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .connect();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(http, http.getIterator());
    }
    
    @Test
    public void httpStreamGETSendsHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        
        headers.put("Authorization", "Bearer test");
        
        http = new HTTPStream()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .setHeaders(headers)
                .connect();
        
        String content = http.toString();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assert(content.contains("Bearer test"));
    }
    
    @Test
    public void httpStreamPOSTSuccessful() {
        http = new HTTPStream()
                .post("https://postman-echo.com/post", "")
                .connect();
        
        String content = http.toString();
        
        assertEquals(200, http.getHTTPStatus());
    }
    
    @Test
    public void httpStreamPOSTSendsHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        
        headers.put("Authorization", "Bearer test");
        
        http = new HTTPStream()
                .post("https://postman-echo.com/post", "")
                .setHeaders(headers)
                .connect();
        
        String content = http.toString();
        
        try {
            http.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPStreamTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assert(content.contains("Bearer test"));
    }
}
