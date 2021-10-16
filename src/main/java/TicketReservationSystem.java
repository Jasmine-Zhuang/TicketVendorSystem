import java.util.ArrayList;
import java.util.List;

public class TicketReservationSystem {
    private CustomerManager cm;
    private FlightManager fm;
    private TicketManager tm;

    public TicketReservationSystem(CustomerManager cm, FlightManager fm, TicketManager tm){
        this.cm = cm;
        this.fm = fm;
        this.tm = tm;
    }

    //FlightManager
    // 1. match routes with flight and return list of flight nums
    public List<String> matchFlight(String dep, String des){
        List <String> lst = fm.getFlightByRoute(dep, des);
        //add some formating stuff
        return lst;
    }

    //2. print flight info by flight nums
    public String printFlightInfo(String flightnum){
        return fm.getFlightByNum(flightnum).toString();
    }

    //3.select flight by flight num
    public Flight selectFlight(String flightnum){
        return fm.getFlightByNum(flightnum);
    }

    //4. show a map of seats in this flight by Flight
    public ArrayList<String> showAvailableSeatNums(String flight_num){
        return fm.printAvailableSeatArray(flight_num);
    }


    //5. reserve seat and return seat_num
    public String reserveSeat(String seat_num, String flight_num){
       return fm.reserveSeat(flight_num,seat_num);
    }





}
