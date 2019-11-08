/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MockHTTPIO implements HTTPIO {
    public String url;
    public String requestType;
    public String postData;
    public boolean connected = false;
    
    public Map<String, String> headers;
    public Iterator<String> output;
    public int statusCode = 200;
    
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public void setOutput(Iterator<String> output) {
        this.output = output;
    }
    
    @Override
    public HTTPIO get(String url) {
        this.url = url;
        this.requestType = "GET";
        
        return this;
    }

    @Override
    public HTTPIO post(String url, String postData) {
        this.url = url;
        this.requestType = "POST";
        
        return this;
    }

    @Override
    public HTTPIO setHeaders(Map<String, String> headers) {
        this.headers = headers;
        
        return this;
    }

    @Override
    public HTTPIO connect() {
        this.connected = true;
        
        return this;
    }

    @Override
    public int getHTTPStatus() {
        return this.statusCode;
    }

    @Override
    public void close() throws IOException {
        this.connected = false;
    }

    @Override
    public Iterator<String> getIterator() {
        return this.output;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        while (output.hasNext()) {
            builder.append(output.next()).append("\n");
        }
        
        return builder.toString();
    }
}
