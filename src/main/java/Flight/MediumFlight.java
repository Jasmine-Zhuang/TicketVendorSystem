package Flight;

import java.util.ArrayList;
import java.util.Arrays;

public class MediumFlight extends Flight {
    /**
     * Construct a medium Flight with no seat booked
     */
    public static ArrayList<String> mediumSeatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B",
            "5A","5B","6A","6B","7A","7B","8A","8B","9A","9B","10A","10B"));
    public MediumFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int distance_traveled, String boardingGate
                       ){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 20, 20, distance_traveled, boardingGate,mediumSeatNumArray);
    }
}
