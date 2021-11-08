import java.util.ArrayList;

public class SmallFlight extends Flight{
    /**
     * Construct a small Flight
     */
    public SmallFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                       ArrayList<String> arrivalTime, int numSeatAvailable, int distance_traveled, String boardingGate,
                       ArrayList<String> seatNumberArray){
        super(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, 10, numSeatAvailable, distance_traveled, boardingGate,seatNumberArray);
    }
}
