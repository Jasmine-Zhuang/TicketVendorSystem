package Luggage;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LuggageManagerTest {
    LuggageManager lm = new LuggageManager();

    String flightNum1 = "CA237";
    String flightNum2 = "CA207";
    String flightNum3 = "CA101";

    String seatNum1 = "A1";
    String seatNum2 = "A2";
    String seatNum3 = "G1";

    int overW = 40;
    int w1 = 24;
    int w2 = 20;


    @Test(timeout = 50)
    public void TestgetWeightById(){
        lm.generateLuggage(w1, flightNum1, seatNum1);
        assertEquals(w1, lm.getWeightById("CA237A1"));
    }

    @Test(timeout = 50)
    public void TestcheckWeight(){
        assertEquals(-1, lm.checkWeight(overW));
        assertEquals(1, lm.checkWeight(w2));
        assertEquals(0, lm.checkWeight(w1));
    }

    @Test(timeout = 100)
    public void TestDisplayLuggageInfo(){
        lm.generateLuggage(w1, flightNum1, seatNum1);
        lm.generateLuggage(w2, flightNum2, seatNum2);
        lm.generateLuggage(overW, flightNum3, seatNum3);
        String S = "CA237A1" + ": " + w1 + "; " + "CA207A2" + ": " + w2 + "; ";
        ArrayList<String> A = new ArrayList<>();
        A.add("CA237A1");
        A.add("CA207A2");
        assertEquals(S, lm.displayLuggageInfo(A));
    }







}
