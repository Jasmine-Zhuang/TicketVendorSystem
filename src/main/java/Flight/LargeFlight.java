package Flight;

import java.util.ArrayList;
import java.util.Arrays;

public class LargeFlight extends Flight {
    /**
     * Construct a large Flight.Flight
     */
    public static ArrayList<String> largeSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
            "5A","5B","6A","6B","7A","7B","8A","8B","9A","9B","10A","10B","11A","11B","12A","12B","13A","13B","14A",
            "14B","15A","15B"));
    public LargeFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int numSeatAvailable, int distance_traveled, String boardingGate){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 30, numSeatAvailable, distance_traveled, boardingGate,largeSeatNumArray);
    }
}
