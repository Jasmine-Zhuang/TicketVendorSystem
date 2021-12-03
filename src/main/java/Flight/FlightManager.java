package Flight;
/*
This is the class that manages all scheduled flights information
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightManager implements Serializable {
    private HashMap<String, Flight> idToFlight = new LinkedHashMap<>();
    private static final long serialVersionUID = 2;

/*
    public void saveFM(FlightManager fm,String filePath){
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject((FlightManager)fm);
            out.close();
            fileOut.close();
            System.out.println("FM saved!");
            long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }*/
   /* public FlightManager restoreFM(String filePath){
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            FlightManager fm = (FlightManager) in.readObject();
            System.out.println(fm.sortFlightsDistance());
            in.close();
            fileIn.close();
            System.out.println("Restored FM");
            long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);
            return fm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }*/

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
     * @param flightType the type of the flight, small: 10 seats, median: 20 seats, large: 30 seats;
     * @param distance_traveled The flight's length
     * @param boardingGate the boarding gate of this flight

     */
    public void AddFlight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                          ArrayList<String> arrivalTime, String flightType, int distance_traveled
            , String boardingGate) {

       /* int numSeatAvailable = seatNumchecker(flightType);
        int totalNumSeats = seatNumchecker(flightType);
        Flight newFlight = new Flight(flightNumber, originCity, destinationCity, departureTime,
                arrivalTime, totalNumSeats, numSeatAvailable, distance_traveled
                , boardingGate, seatNumberArray);*/
        switch (flightType) {
            case "Small": {
                Flight newFlight = new SmallFlight(flightNumber, originCity, destinationCity, departureTime,
                        arrivalTime, distance_traveled, boardingGate);
                this.idToFlight.put(flightNumber, newFlight);
                break;
            }
            case "Medium": {
                Flight newFlight = new MediumFlight(flightNumber, originCity, destinationCity, departureTime,
                        arrivalTime, distance_traveled, boardingGate);
                this.idToFlight.put(flightNumber, newFlight);
                break;
            }
            case "Large": {
                Flight newFlight = new LargeFlight(flightNumber, originCity, destinationCity, departureTime,
                        arrivalTime, distance_traveled, boardingGate);
                this.idToFlight.put(flightNumber, newFlight);
                break;
            }
        }
        }





    /*public int FlightTypechecker(String flightType) {
        if (Objects.equals(flightType, "Small")) {
            return 10;
        } else if (Objects.equals(flightType, "Medium")) {
            return 20;
        } else if (Objects.equals(flightType, "Large")) {
            return 30;
        }
        else return -1;
    }*/


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
     * Cancel reserved seat
     */
    public String cancelSeat(String flightNum, String seatNum) {
        Flight flight = this.idToFlight.get(flightNum);
        if (flight.CancelOneSeat(seatNum)) {
            return "You have successfully canceled seat" + seatNum +" of flight " + flightNum;
        }
        return "This seat has not been reserved or does not exist.";
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
            if(!thisSeatNum.contains("X")){
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
            if(!thisSeatNum.contains("X") && thisSeatClass.equals(seatClass)){
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
    /**
     * @param flightNum a flight number
     * @return a string of the information of flight, that will be shown as formatted in GUI
     */
    public String displayFlightInfoInGUI(String flightNum) {
        if (this.idToFlight.containsKey(flightNum)) {
            Flight f =getFlightByNum(flightNum);
            DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy MMM dd  HH:mm:ss");
            String formattedArrivalTime = f.getArrivalTime().format(FormatObj);
            String formattedDepartureTime = f.getDepartureTime().format(FormatObj);

            return "<html> Flight " + flightNum +
                    " <br/> from " + f.getOriginCity() + " to " + f.getDestinationCity() +
                    "<br/> from " + formattedDepartureTime + " to " + formattedArrivalTime +
                    "<br/> distance travelled: "+f.getDistanceTraveled()+
                    "<br/> boarding gate: " + f.getBoardingGate()+ "<html>";
        }
        else{return null;}

    }
    /**
     * @param flightNum a flight number
     * @return a string of the departure city of flight
     */

    public String getDCity(String flightNum){
        return getFlightByNum(flightNum).getOriginCity();
    }


    /**
     *
     * @param flightNum a flight number
     * @return a string of the arrival city of flight
     */
    public String getACity(String flightNum){
        return this.getFlightByNum(flightNum).getDestinationCity();
    }
}