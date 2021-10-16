/*
This is the class that manages all scheduled flights information
 */

import java.util.*;

public class FlightManager {
    private final HashMap<String, Flight> idToFlight = new LinkedHashMap<>();

    public FlightManager(){}


    /**
     * Add a New Flight to the manager.
     * @param flightNumber flight_number of this flight
     * @param originCity string of departure
     * @param destinationCity string of destination
     * @param departureTime departure time in the format of [year,month,day,hour,minute]
     * @param arrivalTime arrival time in the format of [year,month,day,hour,minute]
     * @param totalNumSeats the number of seats that this flight can have
     * @param numSeatAvailable number of seats booked
     * @param distance_traveled The flight's length
     * @param boardingGate the boarding gate of this flight
     * @param seatNumberArray    array of all seat numbers of this flight
     */
    public void AddFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                          ArrayList<String> arrivalTime, int totalNumSeats, int numSeatAvailable, int distance_traveled
            , String boardingGate, ArrayList<String> seatNumberArray) {

        Flight newFlight = new Flight(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, totalNumSeats, numSeatAvailable, distance_traveled
                , boardingGate, seatNumberArray);
        this.idToFlight.put(flightNumber, newFlight);
    }

    /**
     * sort the Scheduled_flight list by travel distance, from shorter to longer
     * @return an arraylist of flights in sorted order
     */
    public List<String> sortFlightsDistance(){
        List<String> tempArray = new ArrayList<>(this.idToFlight.keySet());
        int min_dis = 0;
        for (int i = 0; i < tempArray.size(); i++) {
            for (int j = i+1; j < tempArray.size(); j++) {
                if (this.idToFlight.get(tempArray.get(i)).getDistanceTraveled() >
                        this.idToFlight.get(tempArray.get(j)).getDistanceTraveled()) {
                    String tem = tempArray.get(i);
                    tempArray.set(i, tempArray.get(j));
                    tempArray.set(j, tem);
                }
            }
        }
        return tempArray;
    }

    /**
     * get a flight by flight number
     * @return Flight
     */
    public Flight getFlightByNum(String flight_num){
        return idToFlight.get(flight_num);
    }

    /**
     * reserve a flight by providing flight number and seat number
     * @return reservation status
     */
    public String reserveSeat(String flight_num, String seat_num) {
        Flight flight = this.idToFlight.get(flight_num);
        if (flight.ReserveOneSeat(seat_num)){
            return "You have successfully selected this seat "+ seat_num +" of flight " +  flight_num;
        }
        return "This seat has been reserved or does not exist, please select another seat.";
    }

    /**
     * provide verify information for the flight that the user wants to look up
     * return a string of the flight information if the flight is scheduled, otherwise return
     * a string inform the customer that this flight is not scheduled to fly.
     */
    public String verifyYouFlight(String flight_num){
        if (this.idToFlight.containsKey(flight_num)) {
            return this.idToFlight.get(flight_num).toString();
        }
        return "This flight number is invalid or the flight is not scheduled to fly.";
    }

    /**
     * provide user a list of flight nums that with specified city of departure and destination
     * @return Arraylist of flight nums, or empty list if there's no available flight
     */
    public ArrayList<String> getFlightByRoute(String dep, String des) {
        ArrayList<String> lst = new ArrayList<>();
        for (String id: this.idToFlight.keySet()) {
            if (Objects.equals(this.idToFlight.get(id).getOriginCity(), dep) &&
                    Objects.equals(this.idToFlight.get(id).getDestinationCity(), des)) {
                lst.add(id);
            }
        }
        return lst;
    }

    /**
     * @param flight_num flight number
     * @return ArrayList of availableSeat
     */
    public ArrayList<String> printAvailableSeat(String flight_num){
        Flight flight = this.idToFlight.get(flight_num);
        ArrayList<String> availableSeat = new ArrayList<>();
        for(String seat_num:flight.getSeatNumberArray()){
            if(!seat_num.equals("X")){
                availableSeat.add(seat_num);
            }
        }
        return availableSeat;
    }

    public int getPriceByFlight(Flight flight){
        return flight.getPrice();
    }



}