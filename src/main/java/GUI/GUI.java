package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Luggage.LuggageManager;
import Ticket.TicketManager;
public class GUI {

    GUI(FlightManager fm, CustomerManager cm, TicketManager tm, PHManager phm, LuggageManager lm){

        new GreetingFrame(fm,cm,tm,phm, lm);
        //save managers' state

    }

}
