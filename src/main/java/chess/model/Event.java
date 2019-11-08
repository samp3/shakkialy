/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.model;

import org.json.JSONObject;

/**
 * Java representation of a Lichess event 
 * Event types handled 
 */
public class Event {
    public EventType type;
    
    public String id;
    
    public static Event parseFromJson(String json) {
        Event event = new Event();
        
        JSONObject jsonEvent = new JSONObject(json);
        
        String type = jsonEvent.getString("type");
        
        if (type.equals("challenge")) { 
            event.type = EventType.Challenge; 
            
            JSONObject jsonChallenge = jsonEvent.getJSONObject("challenge");
            
            event.id = jsonChallenge.getString("id");
        } else { 
            event.type = EventType.GameStart;
            JSONObject jsonGame = jsonEvent.getJSONObject("game");
            
            event.id = jsonGame.getString("id");
        }
        
        return event;
    }
}
