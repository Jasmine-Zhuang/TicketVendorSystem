package Flight;

import Flight.Flight;
import org.junit.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FlightTest {
    Flight flight;
    Flight emptyFlight;

    @Before
    public void setUp() {
        //initialize departure time
        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
       /* ArrayList<String> dTime = new ArrayList<>(5);
        dTime.add("2021");
        dTime.add("12");
        dTime.add("1");
        dTime.add("8");
        dTime.add("50");
        dTime.add("0");
*/
        //initialize arrival time
        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
/*        ArrayList<String> aTime = new ArrayList<>(5);
        aTime.add("2021");
        aTime.add("12");
        aTime.add("1");
        aTime.add("10");
        aTime.add("45");
        aTime.add("0");*/

        //initialize seatNumberArray
        ArrayList<String> seatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
        /*ArrayList<String> seatNumArray = new ArrayList<>();
        seatNumArray.add("1A");
        seatNumArray.add("1B");
        seatNumArray.add("2A");
        seatNumArray.add("2B");
        seatNumArray.add("3A");
        seatNumArray.add("3B");
        seatNumArray.add("4A");
        seatNumArray.add("4B");
        seatNumArray.add("5A");
        seatNumArray.add("5B");*/

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
            assertEquals("X", flight.getSeatArray().get(0).get(0));
        }
        assertFalse(flight.ReserveOneSeat("10A"));
    }

    @Test(timeout = 50)
    public void TestBuildTime(){
        ArrayList<String> t= new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        assertNotNull(flight.buildTime(t));
        assertEquals(flight.buildTime(t), LocalDateTime.of(2021,12,1,8,50,0));
    }

    @Test(timeout = 50)
    public void TestBuildSeatArray(){
        //set up
        ArrayList<String> smallSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
                "5A","5B"));
        ArrayList<String> mediumSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
                "5A","5B","6A","6B","7A","7B","8A","8B","9A","9B","10A","10B"));
        ArrayList<String> largeSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
                "5A","5B","6A","6B","7A","7B","8A","8B","9A","9B","10A","10B","11A","11B","12A","12B","13A","13B","14A",
                "14B","15A","15B"));
        // test null cases
        assertNull(flight.buildSeatArray(11,smallSeatNumArray));
        assertNull(flight.buildSeatArray(22,smallSeatNumArray));
        // test small flight's case
        ArrayList<ArrayList<String>> smallSeatArray = new ArrayList<>();
        for(int i = 0; i<10; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,smallSeatNumArray.get(i));
            seat.add(1,"First");
            smallSeatArray.add(seat);
        }
        assertEquals(flight.buildSeatArray(10,smallSeatNumArray),smallSeatArray);
        // test medium flight's case
        ArrayList<ArrayList<String>> mediumSeatArray = new ArrayList<>();
        for(int i = 0; i<6; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,mediumSeatNumArray.get(i));
            seat.add(1,"First");
            mediumSeatArray.add(seat);
        }
        for(int i = 6; i<20; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,mediumSeatNumArray.get(i));
            seat.add(1,"Business");
            mediumSeatArray.add(seat);
        }
        assertEquals(flight.buildSeatArray(20,mediumSeatNumArray),mediumSeatArray);
        // test large flight's case
        ArrayList<ArrayList<String>> largeSeatArray = new ArrayList<>();
        for(int i = 0; i<6; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,largeSeatNumArray.get(i));
            seat.add(1,"First");
            largeSeatArray.add(seat);
        }
        for(int i = 6; i<14; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,largeSeatNumArray.get(i));
            seat.add(1,"Business");
            largeSeatArray.add(seat);
        }
        for(int i = 14; i<30; i++){
            ArrayList<String> seat = new ArrayList<>();
            seat.add(0,largeSeatNumArray.get(i));
            seat.add(1,"Economy");
            largeSeatArray.add(seat);
        }
        assertEquals(flight.buildSeatArray(30,largeSeatNumArray),largeSeatArray);


    }


}
