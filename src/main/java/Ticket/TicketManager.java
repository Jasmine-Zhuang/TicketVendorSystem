package Ticket;
/*
This is the class that manages all sold tickets.
 */

import Customer.Customer;
import Customer.CustomerManager;
import Customer.PurchaseHistory;
import Luggage.LuggageManager;
import Flight.FlightManager;
import Flight.Flight;
import Customer.PHManager;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketManager implements Serializable {


    private ArrayList<Ticket> soldTickets;
    private static final long serialVersionUID = 1;


    /** Construct a TicketManager, giving them an empty list of soldTickets
     */

    public TicketManager() {
        this.soldTickets = new ArrayList<>();
    }

    /**
     * A getter method.
     * @return All tickets in soldTicket.
     */

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    /**
     * A getter method.
     * @return All tickets in soldTicket.
     */
    public Ticket getTicketByID(String ticketID) {
        for (Ticket ticket:soldTickets) {
            if (ticket.getTicket_id().equals(ticketID)) return ticket;
        }
        return null;
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
     * @param lm A LuggageManager instance.
     * @param pm A PHManager instance.
     * @param cm A CustomerManager instance.
     * @param fm A FlightManager instance.
     * @param pc A PriceCalculator instance.
     * @return a string to indicate whether the cancellation is successful.
     */

    public String cancelTickets(Ticket ticket, LuggageManager lm, PHManager pm, CustomerManager cm, FlightManager fm,
                                PriceCalculator pc) {
        String username= ticket.getPassenger_username();
        String luggageId = ticket.getLuggage_id();
        int luggageWeight = lm.getWeightById(luggageId);
        Customer customer = cm.showCustomer(username);
        Flight flight = fm.getFlightByNum(ticket.getFlightNumber());
        int mileage = this.getMileage(ticket,fm);
        int pts_returned = mileage / 5;
        PurchaseHistory ph = pm.getPhMap().get(customer);

        if (soldTickets.contains(ticket)) {
            // remove ticket from list
            soldTickets.remove(ticket);
            // re-add seat to the flight
            flight.CancelOneSeat(ticket.getSeat_number());
            // remove from purchase history
            ph.removePurchasedTickets(ticket);
            pm.updatePurchaseHistory(customer, ph);
            // update balance = price ticket - penalty + luggage penalty
            int price = pc.calculatePrice(flight, customer, ticket.getTicket_class()); // original ticket price
            int lug_penalty = pc.luggagePenalty(luggageWeight, ticket);
            int change_penalty = pc.penaltyPrice(ticket);
            int minus_price = price - change_penalty + lug_penalty;
            cm.decrBalance(minus_price,customer);
            // calculate redeem point
            if (cm.checkMembership(customer)){
                cm.minusRedeemPoint(customer, pts_returned);
            }
            cm.decrMileage(customer, pts_returned); //minus mileage
            //extra penalty if redeem points<0 after above operations
            int negativePointPenalty = pc.pointPenalty(customer);//negative int or 0
            cm.incrMileage(negativePointPenalty,customer);

            return "You have successfully canceled the ticket for flight " + ticket.getFlightNumber() +
                    ". The details are:" + " \n" + ticket;
        }
        return "You have not booked this flight yet, so it cannot be canceled.";
    }

    /**
     * Generate a Ticket instance.
     * @param flightNumber A String that is associated with the flight in this ticket.
     * @param d_city A String that indicates the departure city.
     * @param a_city A String that indicates the arrival city.
     * @param d_time A LocalDateTime instance that indicates the departure time.
     * @param a_time A LocalDateTime instance that indicates the arrival time.
     * @param b_gate A String that represents the boarding gate.
     * @param seat_num A String that represents the seat number.
     * @param price A int that represents the ticket price.
     * @param p_name A String that represents the customer's name associated with this ticket.
     * @param p_user A String that represents the customer's username associated with this ticket.
     * @param Class_tp A String that represents the seat type associated with this ticket.
     * @return a list of tickets that this customer has booked under this username.
     */

    public Ticket generateTicket(String flightNumber, String d_city, String a_city, LocalDateTime d_time,
                                 LocalDateTime a_time, String b_gate, String seat_num, int price,
                                 String p_name, String p_user, String Class_tp) {
        return new Ticket(flightNumber, d_city, a_city, d_time, a_time, b_gate, seat_num, price, p_name, p_user,
                Class_tp);

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

    /**
     * Display the distance traveled of the flight associated with a certain ticket.
     * @param ticket A Ticket instance, a customer's ticket.
     * @param fm A FlightManager instance that contains information of all flights.
     * @return an int represents mileage.
     */
    public int getMileage(Ticket ticket, FlightManager fm) {
        String flightNum = ticket.getFlightNumber();
        Flight flight = fm.getFlightByNum(flightNum);
        return flight.getDistanceTraveled();
    }





}