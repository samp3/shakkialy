/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

/**
 * Abstract factory for generating HTTPIO objects
 */
public interface HTTPIOFactory {
    HTTPIO createNew();
}
