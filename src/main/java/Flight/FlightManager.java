package Flight;
/*
This is the class that manages all scheduled flights information
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class FlightManager implements Serializable {
    private final HashMap<String, Flight> idToFlight = new LinkedHashMap<>();

    public boolean saveFM(FlightManager fm, String fileName){
        try{
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(fm);
            objectOut.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public FlightManager restoreFM(String fileName){
        FlightManager fm = null;
        try{
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            fm = (FlightManager) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
        return fm;

    }

    public FlightManager(){}
/*
    public FlightManager(HashMap<String, Flight>idToFlight){
        this.idToFlight = idToFlight;
    }*/

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
    public String verifyYourFlight(String flight_num){
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
     * provide user a list of flight which departure and arrive at specific local time
     * @return Arraylist of flight nums, or empty list if there's no available flight
     */
    public ArrayList<String> getFlightByLocalTime(LocalDateTime departureTime,
                                                  LocalDateTime arrivalTime) {
        ArrayList<String> lst = new ArrayList<>();
        for (String id: this.idToFlight.keySet()) {
            if (Objects.equals(this.idToFlight.get(id).getDepartureTime(), departureTime) &&
                    Objects.equals(this.idToFlight.get(id).getArrivalTime(), arrivalTime)) {
                lst.add(id);
            }
        }
        return lst;
    }

    /**
     * @param flightNum flight number
     * @return ArrayList of availableSeat which looks like {{“1A”, "First"}, {"2A", "First"}, {"3G", "Economic"}}
     */
    public ArrayList<ArrayList<String>> printAvailableSeat(String flightNum){
        Flight flight = this.idToFlight.get(flightNum);
        ArrayList<ArrayList<String>> availableSeat = new ArrayList<>();
        for(ArrayList<String> seat: flight.getSeatArray()){
            String thisSeatNum = seat.get(0);
            if(!thisSeatNum.equals("X")){
                availableSeat.add(seat);
            }
        }
        return availableSeat;
    }

    /**
     * @param flightNum flight number
     * @param seatClass the class of the seat number
     * @return ArrayList of availableSeat which looks like {{“1A”, "First"}, {"2A", "First"}}
     */
    public ArrayList<ArrayList<String>> printAvailableSeatByClass(String flightNum, String seatClass){
        Flight flight = this.idToFlight.get(flightNum);
        ArrayList<ArrayList<String>> availableSeat = new ArrayList<>();
        for(ArrayList<String> seat: flight.getSeatArray()){
            String thisSeatNum = seat.get(0);
            String thisSeatClass = seat.get(1);
            if(!thisSeatNum.equals("X") && thisSeatClass.equals(seatClass)){
                availableSeat.add(seat);
            }
        }
        return availableSeat;
    }


    /**
     * @param flightNumLs a list of flight number
     * @return a string of all the information of flight numbers in the list
     */
    public String displayFlightInfo(ArrayList<String> flightNumLs) {
        StringBuilder infoString = new StringBuilder();
        for(String flightNum: flightNumLs){
            if (this.idToFlight.containsKey(flightNum)) {
                infoString.append(this.idToFlight.get(flightNum).toString());
            }
        }
        return infoString.toString();
    }


}