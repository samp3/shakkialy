/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.model;

import org.json.*;

/**
 * Lichess profile data
 */
public class Profile {
    public String id;
    public String username;
    
    /**
     * Parses a Profile from Lichess JSON data according to https://lichess.org/api#operation/accountMe
     * @param json A string of JSON data
     * @return A Profile containing the ID and username of the user
     */
    public static Profile parseFromJson(String json) {
        Profile newProfile = new Profile();
        
        JSONObject jsonProfile = new JSONObject(json);
        
        newProfile.id = jsonProfile.optString("id");
        newProfile.username = jsonProfile.optString("username");
        
        return newProfile;
    }
}
