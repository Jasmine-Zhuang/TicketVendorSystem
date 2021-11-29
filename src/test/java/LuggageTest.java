package Luggage;

import org.junit.*;import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import static org.junit.Assert.*;

public class LuggageTest {

    String id1 = "1";
    String id2 = "2";
    String id3 = "3";

    int overW = 40;
    int w1 = 23;
    int w2 = 20;
    int w3 = 30;

    Luggage luggage1 = new Luggage(id1, w1);
    Luggage luggage2 = new Luggage(id2, w2);
    Luggage luggage3 = new Luggage(id3, w3);
    Luggage emptyLuggage = new Luggage();



    /**
     * test empty constructor
     */
    @Test(timeout = 50)
    public void TestEmptyConstructor(){
        assertNull(emptyLuggage.getLuggageId());
        assertEquals(0, emptyLuggage.getLuggageWeight());
    }

    /**
     * test constructor
     */
    @Test(timeout = 50)
    public void TestConstructor(){
        assertEquals(id1, luggage1.getLuggageId());
        assertEquals(w1, luggage1.getLuggageWeight());
    }

    @Test(timeout = 50)
    public void TestToString(){
        String S = id1 + ": " + w1 + "; ";
        assertEquals(S, luggage1.toString());
    }


}
