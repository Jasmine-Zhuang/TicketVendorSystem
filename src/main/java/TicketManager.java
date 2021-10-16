/*
This is the class that manages all sold tickets.
 */


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TicketManager {


    private final ArrayList<Ticket> soldTickets;

    /** Construct a TicketManager, giving them an empty list of soldTickets
     */

    public TicketManager() {
        this.soldTickets = new ArrayList<>();
    }

    /**
     * A getter method.
     * @return A list of sold tickets.
     */

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    /**
     * If a customer booked a ticket, add it to soldTicket.
     * @param ticket A Ticket instance.
     * @return a confirmation message confirming if this ticket has been stored, false otherwise.
     */

    public String bookTickets(Ticket ticket) {
        if (!soldTickets.contains(ticket)) {
            soldTickets.add(ticket);
            return "You have successfully booked the ticket for flight " + ticket.getFlightNumber() + "! The" +
                    " details are: \n" + ticket;
        }
        return "Sorry! Please ensure all the information is correct, and try again later!";
    }

    /**
     * Remove a ticket from soldTicket to represent that this ticket has been canceled.
     * @param ticket A Ticket instance.
     * @return true if this ticket has been removed from the list, false otherwise.
     */

    public String cancelTickets(Ticket ticket) {
        if (soldTickets.contains(ticket)) {
            soldTickets.remove(ticket);
            return "You have successfully canceled the ticket for flight " + ticket.getFlightNumber() +
                    "! The details are:" + " \n" + ticket;
        }
        return "You have not booked this flight yet, so it cannot be canceled.";
    }

    public Ticket generateTicket(String flightNumber, String d_city, String a_city, LocalDateTime d_time,
                                 LocalDateTime a_time, String b_gate, String seat_num, int price,
                                 String p_name, String p_user) {
        return new Ticket(flightNumber, d_city, a_city, d_time, a_time, b_gate, seat_num, price, p_name, p_user);

    }
    public static void main (String[] args) {
        TicketManager tm = new TicketManager();
        ArrayList<String> dt = new ArrayList<>(Arrays.asList("2021", "8", "22", "12", "35"));
        ArrayList<String> at = new ArrayList<>(Arrays.asList("2021", "8", "23", "11", "35"));
        int dYear = Integer.parseInt(dt.get(0));
        int dMonth = Integer.parseInt(dt.get(1));
        int dDay = Integer.parseInt(dt.get(2));
        int dHour = Integer.parseInt(dt.get(3));
        int dMinute = Integer.parseInt(dt.get(4));
        int aYear = Integer.parseInt(at.get(0));
        int aMonth = Integer.parseInt(at.get(1));
        int aDay = Integer.parseInt(at.get(2));
        int aHour = Integer.parseInt(at.get(3));
        int aMinute = Integer.parseInt(at.get(4));
        LocalDateTime arrivalTime =  LocalDateTime.of(aYear,aMonth,aDay,aHour,aMinute);
        LocalDateTime departureTime = LocalDateTime.of(dYear,dMonth,dDay,dHour,dMinute);
        Ticket t1 = tm.generateTicket("1234", "Toronto", "Vancouver", departureTime, arrivalTime, "A",
                "5B", 100, "Taylor", "taylorsusername");
//        Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", dt, at, "A",
//                "5B", 100, "Taylor", "taylorsusername");
        Ticket t2 = tm.generateTicket("1234", "Vancouver", "Toronto", departureTime, arrivalTime, "A",
                "5B", 100, "Taylor", "taylorsusername");
//        Ticket t2 = new Ticket("1234", "Vancouver", "Toronto", dt, at, "A",
//                "5B", 100, "Taylor", "taylorsusername");
        System.out.println(tm.bookTickets(t1));
        System.out.println(tm.cancelTickets(t1));
        System.out.println(tm.cancelTickets(t2));
    }



}