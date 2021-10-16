import java.util.ArrayList;
import java.util.List;

public class TicketReservationSystem {
    private CustomerManager cm;
    private FlightManager fm;
    private TicketManager tm;

    /**
     * Construct a System with 3 managers.
     */
    public TicketReservationSystem(CustomerManager cm, FlightManager fm, TicketManager tm){
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
    }

    //FlightManager

    /**
     * match routes with flight and return list of flight nums
     * @param dep departure
     * @param des destination
     * @return lst List of flight numbers; empty if no flight available.
     */
    public List<String> matchFlight(String dep, String des){
        return fm.getFlightByRoute(dep, des);
    }

    /**
     * print flight info by flight number
     * @param flight_num flight number
     * @return String of flight information
     */
    public String printFlightInfo(String flight_num){
        return fm.getFlightByNum(flight_num).toString();
    }

    /**
     * select flight by flight num
     * @param flight_num flight number
     * @return Flight
     */
    public Flight selectFlight(String flight_num){
        return fm.getFlightByNum(flight_num);
    }

    /**
     * @param flight_num flight number
     * @return ArrayList of seats in this flight by flight number
     */
    public ArrayList<String> showAvailableSeatNums(String flight_num){
        return fm.printAvailableSeat(flight_num);
    }

    /**
     * reserve seat and return seat_num
     * @param seat_num seat number
     * @param flight_num flight number
     * @return String of reservation status
     * ("You have successfully selected this seat"+ seat_num+" of flight" +  flight_num   or
     * "This seat has been reserved, please select another seat.")
     *
     */
    public String reserveSeat(String seat_num, String flight_num){
       return fm.reserveSeat(flight_num,seat_num);
    }





}
