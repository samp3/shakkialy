/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

/**
 * Factory for creating HTTPStream objects as HTTPIO objects
 * Used for dependency injection
 */
public class HTTPStreamFactory implements HTTPIOFactory {

    @Override
    public HTTPIO createNew() {
        return new HTTPStream();
    }
    
}
