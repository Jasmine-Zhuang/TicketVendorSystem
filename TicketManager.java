/*
This is the class that manages all sold tickets.
 */


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

    public String addToSoldTickets(Ticket ticket) {
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

    public String removeFromSoldTickets(Ticket ticket) {
        if (soldTickets.contains(ticket)) {
            soldTickets.remove(ticket);
            return "You have successfully canceled the ticket for flight " + ticket.getFlightNumber() +
                    "! The details are:" + " \n" + ticket;
        }
        return "You have not booked this flight yet, so it cannot be canceled.";
    }

    public static void main (String[] args) {
        TicketManager tm = new TicketManager();
        ArrayList<String> dt = new ArrayList<>(Arrays.asList("2021", "8", "22", "12", "35"));
        ArrayList<String> at = new ArrayList<>(Arrays.asList("2021", "8", "23", "11", "35"));
        Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
        Ticket t2 = new Ticket("1234", "Vancouver", "Toronto", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
        System.out.println(tm.addToSoldTickets(t1));
        System.out.println(tm.removeFromSoldTickets(t2));
    }



}
