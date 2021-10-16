import java.time.LocalDateTime;
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
    public void addCustomer(String username,String password,String name){
        if (!cm.checkCustomer(username)){
            Customer new_customer = new Customer(username,password, name);
            cm.addCustomer(new_customer);}
    }

    /**
     * Check if the customer with given username exit in the customer system or not.
     * @param username the name of this customer
     */
    public boolean checkCustomer(String username){
        return cm.checkCustomer(username);
    }

    /**
     * Check the password of the customer with given username.
     * @param username the name of this customer
     * @param password the password to be checked
     */
    public boolean checkPassword(String username, String password){
        return cm.checkPassword(username,password);}

    /**
     * match name with customer and return to correspond customer
     * @param username the name of this customer
     * @return Customer The corresponding customer with this customer's name.
     */
    public Customer showCustomer(String username){
        return cm.showCustomer(username);
    }


    /**
     * match name with customer and return to correspond customer
     * @param username the name of this customer
     * @return String The corresponding customer information with this customer's name.
     */
    public String showCustomerInfo(String username){
        return cm.showCustomer(username).toString();
    }

    /**
     * Show the current balance with to correspond customer
     * @param username the name of this customer
     * @return int The corresponding customer's balance with this customer's name.
     */
    public int showCustomerBalance(String username){
        return cm.showCustomerBalance(username);
    }

    /**
     * Increase the current balance with to correspond customer.
     * @param username the customer name of this customer.
     */
    public void increaseBalance(int new_balance, String username){
        cm.incrBalance(new_balance, cm.showCustomer(username));
    }

    /**
     * Decrease the current balance with to correspond customer
     * @param username the customer name of this customer
     */
    public boolean decreaseBalance(int dec_balance, String username){
        return cm.decrBalance(dec_balance, cm.showCustomer(username));
    }

    //FlightManager

    /**
     * match routes with flight and return list of flight nums
     * @param dep departure
     * @param des destination
     * @return lst List of flight numbers; empty if no flight available.
     */
    public ArrayList<String> matchFlight(String dep, String des){
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


    public Ticket createTicket(String username, String seat_num, String flight_num){
        String name = showCustomer(username).getName();
        String dep_city = selectFlight(flight_num).getDestinationCity();
        String arr_city = selectFlight(flight_num).getDestinationCity();
        LocalDateTime d_time = selectFlight(flight_num).getDepartureTime();
        LocalDateTime a_time = selectFlight(flight_num).getArrivalTime();
        String gate = selectFlight(flight_num).getBoardingGate();
        int price = (int) selectFlight(flight_num).getPrice();
        return tm.generateTicket(flight_num, dep_city, arr_city,
                d_time, a_time, gate, seat_num, price, name, username);
    }

    public String book_ticket(Ticket t){
        return tm.bookTickets(t);
    }



}
