/* This is an entity class named Flight.
 * Belows are the information each class instance stores.
 * flight number
 * origin of the flight
 * destination of the flight
 * departure and arrival time of fight
 * distance traveled from departure to destination
 * seat capacity (total seat numbers) and number of available seat
 * boarding gate
 * the array of seat numbers
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class Flight {
    private String flightNumber;
    private String originCity;
    private String destinationCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int distanceTraveled;
    private int totalSeats;
    private String boardingGate;
    private ArrayList<ArrayList<String>> seatArray;
    private int availableSeats;

    /**
     * Build an array list of arraylist of seat number and seat type
     */
    public ArrayList<ArrayList<String>> buildSeatArray(int totalSeats, ArrayList<String> seatNumArray) {
        ArrayList<ArrayList<String>> seatArray = new ArrayList<>();

        if (totalSeats == 10){
            //small flight: 10 first class seats
            CreateClassSeat(seatNumArray, seatArray, 10,"First");
            return seatArray;

        }else if (totalSeats == 20){
            //medium flight: 6 first class,14 business
            CreateClassSeat(seatNumArray, seatArray, 6,"First");
            CreateClassSeat(seatNumArray, seatArray, 14,"Business");
            return seatArray;

        }else if(totalSeats ==30){
            //large flight: 6 first,8 business,16 economy
            CreateClassSeat(seatNumArray, seatArray, 6,"First");
            CreateClassSeat(seatNumArray, seatArray, 8,"Business");
            CreateClassSeat(seatNumArray, seatArray, 16,"Economy");
            return seatArray;

        }else{
            return null;
        }
    }

    private void CreateClassSeat(ArrayList<String> seatNumArray, ArrayList<ArrayList<String>> seatArray, int num,
                                 String C) {
        for(int i = 0; i<num; i++){
            ArrayList<String> seat = new ArrayList<String>();
            seat.add(0,seatNumArray.get(i));
            seat.add(1,C);
            seatArray.add(seat);
        }
    }

    public LocalDateTime buildTime(ArrayList<String> time){
        if (time.size() == 5){
            int dYear = Integer.parseInt(time.get(0));
            int dMonth = Integer.parseInt(time.get(1));
            int dDay = Integer.parseInt(time.get(2));
            int dHour = Integer.parseInt(time.get(3));
            int dMinute = Integer.parseInt(time.get(4));
            return LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
        }
        return null;

    }


    /**
     * Construct a Flight giving it the given flight_number, origin, destination, departureTime, arrivalTime,
     * distance_traveled, totalSeats, availableSeats, and fuel_capacity.
     * @param flightNumber flight_number of this flight
     * @param originCity string of departure
     * @param destinationCity string of destination
     * @param departureTime departure time in the format of [year,month,day,hour,minute]
     * @param arrivalTime arrival time in the format of [year,month,day,hour,minute]
     * @param totalNumSeats the number of seats that this flight can have
     * @param numSeatAvailable number of seats booked
     * @param distance_traveled The flight's length
     * @param boardingGate the boarding gate of this flight
     * @param seatNumberArray    array list of every seat number of this flight
     */
    public Flight(String flightNumber, String originCity, String destinationCity, ArrayList<String> departureTime,
                  ArrayList<String> arrivalTime, int totalNumSeats, int numSeatAvailable, int distance_traveled
            , String boardingGate, ArrayList<String> seatNumberArray){
        this.flightNumber = flightNumber;
        this.distanceTraveled = distance_traveled;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.totalSeats = totalNumSeats;
        this.availableSeats = numSeatAvailable;
        this.boardingGate = boardingGate;
        this.seatArray = buildSeatArray(totalNumSeats,seatNumberArray);

        // set departure and arrival time
/*        int dYear = Integer.parseInt(departureTime.get(0));
        int dMonth = Integer.parseInt(departureTime.get(1));
        int dDay = Integer.parseInt(departureTime.get(2));
        int dHour = Integer.parseInt(departureTime.get(3));
        int dMinute = Integer.parseInt(departureTime.get(4));
        int aYear = Integer.parseInt(arrivalTime.get(0));
        int aMonth = Integer.parseInt(arrivalTime.get(1));
        int aDay = Integer.parseInt(arrivalTime.get(2));
        int aHour = Integer.parseInt(arrivalTime.get(3));
        int aMinute = Integer.parseInt(arrivalTime.get(4));
        this.arrivalTime =  LocalDateTime.of(aYear,aMonth,aDay,aHour,aMinute);
        this.departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);*/
        this.arrivalTime = buildTime(arrivalTime);
        this.departureTime = buildTime(departureTime);
    }


    /**
     * Construct an empty Flight
     */
    public Flight(){}

    /**
     * A getter method.
     * @return flight number.
     */
    public String getFlightNumber() {return flightNumber;}

    /**
     * A getter method.
     * @return the origin city of the fight.
     */
    public String getOriginCity(){return originCity;}

    /**
     * A getter method.
     * @return the destination city of the fight.
     */
    public String getDestinationCity(){return destinationCity;}

    /**
     * A getter method.
     * @return the departure time of the fight.
     */
    public LocalDateTime getDepartureTime(){return departureTime;}

    /**
     * A getter method.
     * @return the arrival time of the fight.
     */
    public LocalDateTime getArrivalTime(){return arrivalTime;}

    /**
     * A getter method.
     * @return the total number of seats of the fight.
     */
    public int getTotalSeats() {return totalSeats;}

    /**
     * A getter method.
     * @return the number of available seats of the fight.
     */
    public int getAvailableSeats() {return availableSeats;}

    /**
     * A getter method.
     * @return the distance traveled of the fight.
     */
    public int getDistanceTraveled() {return distanceTraveled;}

    /**
     * A getter method.
     * @return the boarding gate of the fight.
     */
    public String getBoardingGate() {return boardingGate;}

    /**
     * A getter method.
     * @return the array of seat numbers of the fight. ("x" if the seat is occupied)
     */
    public ArrayList<ArrayList<String>> getSeatArray() {return seatArray;}

    /*
     * Replace the seat number by "X" from seatNumberArray to represent that this seat has been booked.
     * @param seatNumber A String of seat number.
     * @return true if this seat number was seatNumberArray, and now has been replaced by "X" , false otherwise.
     */
    public boolean ReserveOneSeat(String seatNumber){
        for(ArrayList<String> seat: this.getSeatArray()){
            if(seat.contains(seatNumber)){
                int index = seat.indexOf(seatNumber);
                seat.set(index,"X");
                this.availableSeats --;
                return true;
            }
        }
        return false;
    }

    /*
     * Override the toString method
     * @return String of flight information.
     */
    @Override
    public String toString() {
        DateTimeFormatter FormatObj = DateTimeFormatter.ofPattern("yyyy MMM dd  HH:mm:ss");
        String formattedArrivalTime = arrivalTime.format(FormatObj);
        String formattedDepartureTime = departureTime.format(FormatObj);
        return "Flight " + flightNumber +
                " \n from " + originCity + " to " + destinationCity +
                "\n from " + formattedDepartureTime + " to " + formattedArrivalTime +
                "\n boarding gate: " + boardingGate;
        }
    }





