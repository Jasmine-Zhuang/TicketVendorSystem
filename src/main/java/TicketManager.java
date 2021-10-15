/*
This is the class that manages all sold tickets.
 */


import java.util.ArrayList;

public class TicketManager {


    private ArrayList<Ticket> soldTickets;

    /** Construct a TicketManager, giving them an empty list of soldTickets
     *
     * @param soldTickets a List of Tickets that have been sold to customers.
     */

    public TicketManager() {
        this.soldTickets = new ArrayList<Ticket>();
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
            return "You have successfully booked the ticket for" + ticket.getFlightNumber() + "! The" +
                    "details are \n" + ticket.toString();
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
            return "You have successfully canceled the ticket for" + ticket.getFlightNumber() + "! The details are \n" +
                    ticket.toString();
        }
        return "You have not booked this flight yet, so it cannot be cancelled.";
    }



}
