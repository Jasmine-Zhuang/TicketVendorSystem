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

    //CustomerManager
    /**
     * Ask one customer to create an account is this customer does not exit in the customer system.
     * @param username the username of this customer
     * @param password the password of this customer
     * @param name the name of this customer
     */
    public void findCustomer(String username,String password,String name){
        if (!cm.checkCustomer(name)){
        Customer new_customer = new Customer(username,password, name);
        cm.addCustomer(new_customer);}
    }

    /**
     * match name with customer and return to correspond customer
     * @param name the name of this customer
     * @return Customer The corresponding customer with this customer's name.
     */
    public Customer findCustomer(String name){
        return cm.showCustomer(name);
    }

    /**
     * Show the current balance with to correspond customer
     * @param name the name of this customer
     * @return int The corresponding customer's balance with this customer's name.
     */
    public int showCustomerBalance(String name){
        return cm.showCustomerBalance(name);
    }

    /**
     * Show the current balance with to correspond customer
     * @param name the customer name of this customer
     * @return new_balance The corresponding customer's new balance with this customer's name.
     */
    public int increaseBalance(int new_balance, String name){
         cm.incrBalance(new_balance, cm.showCustomer(name));
         return cm.showCustomer(name).getBalance();
    }

    /**
     * Show the current balance with to correspond customer
     * @param name the customer name of this customer
     * @return new_balance The corresponding customer's new balance with this customer's name.
     */
    public int decreaseBalance(int dec_balance, String name){
        cm.incrBalance(dec_balance, cm.showCustomer(name));
        return cm.showCustomer(name).getBalance();
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
