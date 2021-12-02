package Luggage;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LuggageTest {

    String id1 = "1";
    int w1 = 23;

    Luggage luggage1 = new Luggage(id1, w1);
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