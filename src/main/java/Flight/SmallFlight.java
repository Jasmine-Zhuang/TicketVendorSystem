package Flight;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallFlight extends Flight {
    /**
     * Construct a small Flight.Flight
     */
    public static ArrayList<String> smallSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
            "5A","5B"));
    public SmallFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int numSeatAvailable, int distance_traveled, String boardingGate
                       ){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 10, numSeatAvailable, distance_traveled, boardingGate,smallSeatNumArray);
    }
}
