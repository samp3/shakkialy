/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.connection;

import java.util.ArrayList;

public class MockHTTPIOFactory implements HTTPIOFactory {
    ArrayList<MockHTTPIO> createdObjects;
    int index = 0;
    
    public MockHTTPIOFactory() {
        this.createdObjects = new ArrayList<>();
    }
    
    public void addMockHTTPIOToQueue(MockHTTPIO mockHTTP) {
        createdObjects.add(mockHTTP);
    }
    
    @Override
    public HTTPIO createNew() {
        if (index == createdObjects.size()) {
            createdObjects.add(new MockHTTPIO());
        }
        
        return createdObjects.get(index++);
    }
    
}
