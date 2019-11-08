/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.model;

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
public class ProfileTest {
    
    public ProfileTest() {
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
    
    public String testJson = "{\n"
        + "\n"
        + "    \"id\": \"georges\",\n"
        + "    \"username\": \"Georges\",\n"
        + "    \"title\": \"NM\",\n"
        + "    \"online\": true,\n"
        + "    \"playing\": true,\n"
        + "    \"streaming\": false,\n"
        + "    \"createdAt\": 1290415680000,\n"
        + "    \"seenAt\": 1522636452014,\n"
        + "    \"profile\": \n"
        + "\n"
        + "{\n"
        + "\n"
        + "    \"bio\": \"Free bugs!\",\n"
        + "    \"country\": \"EC\",\n"
        + "    \"firstName\": \"Thibault\",\n"
        + "    \"lastName\": \"Duplessis\",\n"
        + "    \"links\": \"github.com/ornicar\\r\\ntwitter.com/ornicar\",\n"
        + "    \"location\": \"On the road\"\n"
        + "\n"
        + "},\n"
        + "\"nbFollowers\": 2735,\n"
        + "\"nbFollowing\": 299,\n"
        + "\"completionRate\": 97,\n"
        + "\"language\": \"en-GB\",\n"
        + "\"count\": \n"
        + "{\n"
        + "\n"
        + "    \"ai\": 531,\n"
        + "    \"all\": 9265,\n"
        + "    \"bookmark\": 71,\n"
        + "    \"draw\": 340,\n"
        + "    \"drawH\": 331,\n"
        + "    \"import\": 66,\n"
        + "    \"loss\": 4480,\n"
        + "    \"lossH\": 4207,\n"
        + "    \"me\": 0,\n"
        + "    \"playing\": 6,\n"
        + "    \"rated\": 7157,\n"
        + "    \"win\": 4440,\n"
        + "    \"winH\": 4378\n"
        + "\n"
        + "},\n"
        + "\"perfs\": \n"
        + "{\n"
        + "\n"
        + "    \"blitz\": \n"
        + "\n"
        + "{},\n"
        + "\"bullet\": \n"
        + "{},\n"
        + "\"chess960\": \n"
        + "{},\n"
        + "\"puzzle\": \n"
        + "\n"
        + "    {}\n"
        + "\n"
        + "},\n"
        + "\"patron\": true,\n"
        + "\"disabled\": false,\n"
        + "\"engine\": false,\n"
        + "\"booster\": false,\n"
        + "\"playTime\": \n"
        + "\n"
        + "    {\n"
        + "        \"total\": 3296897,\n"
        + "        \"tv\": 12134\n"
        + "    }\n"
        + "\n"
        + "}";
        
    @Test
    public void profileCanParseJson() {
        Profile profile = Profile.parseFromJson(testJson);
            
        assert (true);
    }
        
    @Test
    public void profileIdReadCorrectly() {
        Profile profile = Profile.parseFromJson(testJson);
        
        assertEquals(profile.id, "georges");
    }
    
    @Test
    public void profileUsernameReadCorrectly() {
        Profile profile = Profile.parseFromJson(testJson);
        
        assertEquals(profile.username, "Georges");
    }
}
