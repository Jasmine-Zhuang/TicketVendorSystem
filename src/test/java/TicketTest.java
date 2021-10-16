import org.junit.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
public class TicketTest {
    Ticket t;
    Ticket emp;
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
        int dYear = Integer.parseInt(dTime.get(0));
        int dMonth = Integer.parseInt(dTime.get(1));
        int dDay = Integer.parseInt(dTime.get(2));
        int dHour = Integer.parseInt(dTime.get(3));
        int dMinute = Integer.parseInt(dTime.get(4));
        int aYear = Integer.parseInt(aTime.get(0));
        int aMonth = Integer.parseInt(aTime.get(1));
        int aDay = Integer.parseInt(aTime.get(2));
        int aHour = Integer.parseInt(aTime.get(3));
        int aMinute = Integer.parseInt(aTime.get(4));
        LocalDateTime departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
        LocalDateTime arrivalTime =  LocalDateTime.of(aYear,aMonth,aDay,aHour,aMinute);
        t = new Ticket("A00100", "Beijing", "Toronto", departureTime, arrivalTime,
                "C4", "15P", 1500, "James", "J52000");
        emp = new Ticket();
    }

    @Test(timeout = 100)
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
        assertEquals(1500, t.getPrice());
        assertEquals("James",t.getPassenger_name());
        assertEquals("J52000", t.getPassenger_username());
        assertEquals("A00100,15P", t.getTicket_id());
    }

    @Test(timeout = 100)
    public void TestEmptyConstructor(){
        assertNull(emp.getFlightNumber());
        assertNull(emp.getDeparture_city());
        assertNull(emp.getArrival_city());
        assertNull(emp.getDepartureTime());
        assertNull(emp.getArrivalTime());
        assertNull(emp.getBoardingGate());
        assertNull(emp.getSeat_number());
        assertEquals(0, emp.getPrice());
        assertNull(emp.getPassenger_name());
        assertNull(emp.getPassenger_username());
        assertNull(emp.getTicket_id());
    }


}
