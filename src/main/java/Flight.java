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
    private ArrayList<String> seatNumberArray;
    private int availableSeats;
    private int price;



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
     * @param seatNumberArray    array of all seat numbers of this flight
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
        this.seatNumberArray = seatNumberArray;

        this.price = (int) (distanceTraveled * 0.2 + 100);


        // set departure and arrival time
        int dYear = Integer.parseInt(departureTime.get(0));
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
        this.departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
    }

    /**
     * Construct an empty Flight
     */
    public Flight(){}

    /**
     * A getter method.
     * @return price of this flight
     */
    public int getPrice(){return this.price;}


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
    public ArrayList<String> getSeatNumberArray() {return seatNumberArray;}

    /*
     * Replace the seat number by "X" from seatNumberArray to represent that this seat has been booked.
     * @param seatNumber A String of seat number.
     * @return true if this seat number was seatNumberArray, and now has been replaced by "X" , false otherwise.
     */
    public boolean ReserveOneSeat(String seatNumber){
        if(seatNumberArray.contains(seatNumber)){
            int index = seatNumberArray.indexOf(seatNumber);
            seatNumberArray.set(index,"X");
            this.availableSeats --;
            return true;
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
        return "Flight number: " + flightNumber +
                " \n from " + originCity + " to " + destinationCity +
                "\n from " + formattedDepartureTime + " to " + formattedArrivalTime +
                "\n boarding gate: " + boardingGate+
                "\n price:" +price;
        }

    }





