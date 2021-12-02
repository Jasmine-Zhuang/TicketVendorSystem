package Flight;

import java.util.ArrayList;

public class MediumFlight extends Flight {
    /**
     * Construct a medium Flight.Flight
     */
    public MediumFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int numSeatAvailable, int distance_traveled, String boardingGate,
                       ArrayList<String> seatNumberArray){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 20, numSeatAvailable, distance_traveled, boardingGate,seatNumberArray);
    }
}
