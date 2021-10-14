/*
This file defines a class called TicketManager that stores all sold tickets.
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

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    public void addToSoldTickets(Ticket ticket) {
        soldTickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket) {
        soldTickets.remove(ticket);
    }



}
