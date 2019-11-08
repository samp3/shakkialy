/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Abstract representation of a HTTP input/output object
 */
public interface HTTPIO {
    HTTPIO get(String url);
    
    HTTPIO post(String url, String postData);
    
    HTTPIO setHeaders(Map<String, String> headers);
    
    HTTPIO connect();
    
    int getHTTPStatus();
    
    void close() throws IOException;
    
    Iterator<String> getIterator();
}
