import org.junit.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightTest {
    Flight flight;
    Flight emptyFlight;


    @Before
    public void setUp() {
        //initialize departure time
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

        //initialize seatNumberArray
        ArrayList<String> seatNumArray = new ArrayList<String>();
        seatNumArray.add("1A");
        seatNumArray.add("1B");
        seatNumArray.add("2A");
        seatNumArray.add("2B");
        seatNumArray.add("3A");
        seatNumArray.add("3B");
        seatNumArray.add("4A");
        seatNumArray.add("4B");
        seatNumArray.add("5A");
        seatNumArray.add("5B");

        flight = new Flight("CZ311", "Toronto", "Vancouver",dTime,aTime,
                10, 10, 3600,"10A", seatNumArray);

        emptyFlight = new Flight();

    }
    @Test(timeout = 50)
    public void TestEmptyConstructor(){
        assertNull(emptyFlight.getFlightNumber());
        assertNull(emptyFlight.getOriginCity());
        assertNull(emptyFlight.getDestinationCity());
        assertNull(emptyFlight.getDepartureTime());
        assertNull(emptyFlight.getArrivalTime());
        assertEquals(0,emptyFlight.getTotalSeats());
        assertEquals(0,emptyFlight.getAvailableSeats());
        assertEquals(0,emptyFlight.getDistanceTraveled());
        assertNull(emptyFlight.getBoardingGate());
    }

    @Test(timeout = 50)
    public void TestConstructor() {
        assertEquals("CZ311", flight.getFlightNumber());
        assertEquals("Toronto",flight.getOriginCity());
        assertEquals("Vancouver",flight.getDestinationCity());
        assertEquals(LocalDateTime.of(2021,12,1,8,50,0),
                flight.getDepartureTime());
        assertEquals(LocalDateTime.of(2021,12,1,10,45,0),
                flight.getArrivalTime());
        assertEquals(10,flight.getTotalSeats());
        assertEquals(10,flight.getAvailableSeats());
        assertEquals(3600,flight.getDistanceTraveled());
        assertEquals("10A",flight.getBoardingGate());
    }

    @Test(timeout = 50)
    public void TestReserveOneSeat() {
        if (flight.ReserveOneSeat("1A")) {
            assertEquals(9, flight.getAvailableSeats());
            assertEquals("X", flight.getSeatNumberArray().get(0));
        }
        assertFalse(flight.ReserveOneSeat("10A"));
    }


}
