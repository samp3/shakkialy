package chess.connection;

import java.io.BufferedReader;
// import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * Easily mockable Abstraction around Java's HttpUrlConnection
 */
public class HTTPStream implements Iterator<String>, HTTPIO {

    private HttpURLConnection conn;
    private Iterator<String> iterator;

    public HTTPStream() {

    }
    
    /**
     * Open a connection as a GET request to the given URL
     * @param urlString A valid URL in String format
     * @return Open HTTPStream 
     */
    @Override
    public HTTPStream get(String urlString) {
        try {
            URL url = new URL(urlString);
            this.conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
        } catch (IOException e) {
            System.out.println(e);
        }
        return this;
    }
    
    /**
     * Open a connection as a POST request to the given URL
     * @param urlString A valid URL in String format
     * @param postData Data associated with the POST request, currently unused
     * @return An open HTTPStream 
     */
    @Override
    public HTTPStream post(String urlString, String postData) {
        try {
            URL url = new URL(urlString);
            this.conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
        } catch (IOException e) {
            System.out.println(e);
        }
        return this;
    }
    
    /**
     * Sets the request's headers to the values defined in the given Map
     * @param headerFields A key-value store with the HTTP headers
     * @return The open HTTPStream with the headers
     */
    @Override
    public HTTPStream setHeaders(Map<String, String> headerFields) {
        try {
            headerFields.entrySet().forEach((entry) -> {
                this.conn.setRequestProperty(entry.getKey(), entry.getValue());
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }
    
    /**
     * Connects the stream and instantiates the internal data iterator
     * @return A ready HTTPStream that can be read from
     */
    @Override
    public HTTPStream connect() {
        try {
            this.conn.connect();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            this.conn.getInputStream()));
            this.iterator = reader.lines().iterator();
        } catch (IOException e) {
            System.out.println(e);
        }
        return this;
    }
    
    /**
     * Retrieves the HTTP status code of the open HTTPStream
     * <b>NOTE:</b> HTTPStream must be connected before status code is read
     * @return HTTP status code
     */
    @Override
    public int getHTTPStatus() {
        try {
            return this.conn.getResponseCode();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        // I'm a tea pot!
        //
        // This code should never need to be returned.
        // But in case it ever is, for unknown reasons,
        // we might a well use a code that is an April Fool's
        // from 1998.
        //
        // This code still indicates an error
        return 418;
    }
    
    @Override
    public Iterator<String> getIterator() {
        return this;
    }
    
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public String next() {
        return this.iterator.next();
    }
    
    /**
     * Disconnects the HTTPStream
     * <b>NOTE:</b> The HTTPStream must not be used after closing
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        this.conn.disconnect();
    }
    
    
    /**
     * Reads all lines from the internal data iterator and appends them
     * together as a single String
     * @return The whole HTTP response body
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        while (iterator.hasNext()) {
            builder.append(iterator.next()).append("\n");
        }
        
        return builder.toString();
    }
}
