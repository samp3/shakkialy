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
public class EventTest {
    
    public EventTest() {
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

    public String testJson = "{\"type\":\"challenge\","
            + "\"challenge\":{\"id\":\"7pGLxJ4F\",\"status\":\"created\","
            + "\"challenger\":{\"id\":\"lovlas\",\"name\":\"Lovlas\","
            + "\"title\":\"IM\",\"rating\":2506,\"patron\":true,"
            + "\"online\":true,\"lag\":24},\"destUser\":{\"id\":\"thibot\","
            + "\"name\":\"thibot\",\"title\":null,\"rating\":1500,"
            + "\"provisional\":true,\"online\":true,\"lag\":45},"
            + "\"variant\":{\"key\":\"standard\",\"name\":\"Standard\","
            + "\"short\":\"Std\"},\"rated\":true,"
            + "\"timeControl\":{\"type\":\"clock\",\"limit\":300,"
            + "\"increment\":25,\"show\":\"5+25\"},\"color\":\"random\","
            + "\"perf\":{\"icon\":\"#\",\"name\":\"Rapid\"}}}";
    public String testJson2 = "{\"type\":\"gameStart\","
            + "\"game\":{\"id\":\"1lsvP62l\"}}";
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void eventParsesJson() {
        Event event;
        
        event = Event.parseFromJson(testJson);
        event = Event.parseFromJson(testJson2);
        
        assert (true);
    }
    
    @Test
    public void challengeTypeReadCorrectly() {
        Event event;
        
        event = Event.parseFromJson(testJson);
        
        assert (event.type == EventType.Challenge);
    }
    
    @Test
    public void gameStartTypeReadCorrectly() {
        Event event;
        
        event = Event.parseFromJson(testJson2);
        
        assert (event.type == EventType.GameStart);
    }
    
    @Test
    public void challengeIdReadCorrectly() {
        Event event;
        
        event = Event.parseFromJson(testJson);
        
        assertEquals(event.id, "7pGLxJ4F");
    }
    
    @Test
    public void gameStartIdReadCorrectly() {
        Event event;
        
        event = Event.parseFromJson(testJson2);
        
        assertEquals(event.id, "1lsvP62l");
    }
}
