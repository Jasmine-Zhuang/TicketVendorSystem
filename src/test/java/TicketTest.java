import org.junit.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class TicketTest {
    Ticket t;
    @Before
    public void setUp(){
        ArrayList<String> dTime = new ArrayList<>(5);
        dTime.add("2021");
        dTime.add("12");
        dTime.add("1");
        dTime.add("8");
        dTime.add("50");
        dTime.add("0");

        //initialize arrival time
        ArrayList<String> aTime = new ArrayList<>(5);
        aTime.add("2021");
        aTime.add("12");
        aTime.add("1");
        aTime.add("10");
        aTime.add("45");
        aTime.add("0");
        t = new Ticket("A00100", "Beijing", "Toronto", dTime, aTime,
                "C4", "15P", 15000, "James", "J52000");
    }

    @Test(timeout = 50)
    public void TestConstructor() {
        assertEquals("A00100", t.getFlightNumber());
        assertEquals("Beijing", t.getDeparture_city());
        assertEquals("Toronto", t.getArrival_city());
        assertEquals(LocalDateTime.of(2021,12,1,8,50,0),
                t.getDepartureTime());
        assertEquals(LocalDateTime.of(2021,12,1,10,45,0),
                t.getArrivalTime());
        assertEquals("C4", t.getBoardingGate());
        assertEquals("15P", t.getSeat_number());
        assertEquals(3100, t.getPrice());
        assertEquals("James",t.getPassenger_name());
        assertEquals("J52000", t.getPassenger_username());
        assertEquals("A00100,15P", t.getTicket_id());
    }

    @Test
    public void TestToString(){
        String a = "--------Air Ticket-------- \n" +
                "Name of Passenger: James\n" +
                "Flight: A00100  Seat: 15P\n" +
                "From Beijing to Toronto\n" +
                "Departure time: 2021 12月 01  08:50:00\n" +
                "Estimate arrival time: 2021 12月 01  10:45:00\n" +
                "Boarding Gate: C4\n" +
                "Price: $3100\n" +
                "Boarding time will be one hour before departure.\n" +
                "And gate closes 20 minutes before departure.\n" +
                "Have a nice trip!\n" +
                "-----------------------";
        assertEquals(a, t.toString());
    }

}
