package Flight;

import java.util.ArrayList;

public class LargeFlight extends Flight {
    /**
     * Construct a large Flight.Flight
     */
    public LargeFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int numSeatAvailable, int distance_traveled, String boardingGate,
                       ArrayList<String> seatNumberArray){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 30, numSeatAvailable, distance_traveled, boardingGate,seatNumberArray);
    }
}
