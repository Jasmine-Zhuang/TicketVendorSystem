package GUI;

import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Ticket.TicketManager;
public class GUI {

    GUI(FlightManager fm, CustomerManager cm, TicketManager tm, PHManager phm){

        new GreetingFrame1(fm,cm,tm,phm);
        //save managers' state

    }

}
