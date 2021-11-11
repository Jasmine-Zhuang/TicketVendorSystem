/*
This is the class that manages all sold tickets.
 */


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
     * Remove a ticket from soldTicket to represent that this ticket has been canceled with the
     * time it was cancelled.
     * @param ticket A Ticket instance.
     * @return a string to indicate whether the cancellation is successful.
     */

    public String cancelTickets(Ticket ticket) {
        if (soldTickets.contains(ticket)) {
            soldTickets.remove(ticket);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            return "You have successfully canceled the ticket for flight " + ticket.getFlightNumber() + " on " +
                    dtf.format(now) + ". The details are:" + " \n" + ticket;
        }
        return "You have not booked this flight yet, so it cannot be canceled.";
    }

    public Ticket generateTicket(String flightNumber, String d_city, String a_city, LocalDateTime d_time,
                                 LocalDateTime a_time, String b_gate, String seat_num, int price,
                                 String p_name, String p_user) {
        return new Ticket(flightNumber, d_city, a_city, d_time, a_time, b_gate, seat_num, price, p_name, p_user);

    }

    /**
     * Display ticket info by giving the username of a customer.
     * @param username A customer's username.
     * @return a list of tickets that this customer has booked under this username.
     */

    public List<Ticket> ticketDisplay(String username) {
        List<Ticket> ticketHistory = new ArrayList<>();
        for (Ticket ticket : soldTickets) {
            if (ticket.getPassenger_username().equals(username)) ticketHistory.add(ticket);
        }
        return ticketHistory;
    }




}