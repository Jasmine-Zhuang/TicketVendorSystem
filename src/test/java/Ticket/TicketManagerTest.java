package Ticket;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Flight.FlightManager;
import Flight.Flight;
import Customer.Customer;
import Customer.CustomerManager;
import Customer.PHManager;
import Customer.PurchaseHistory;
import Luggage.LuggageManager;
import Meal.*;

import static org.junit.Assert.*;

public class TicketManagerTest {

    TicketManager tm;

    @Before
    public void setUp() { tm = new TicketManager();}
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
    Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", departureTime, arrivalTime, "A1",
            "5B", 100, "Taylor", "taylorsusername","First");
    Ticket t2 = new Ticket("4567", "Vancouver", "Toronto", departureTime, arrivalTime, "A1",
            "12A", 100, "Taylor", "taylorsusername","Economy");
    Ticket t3 = new Ticket("1463", "Toronto", "Vancouver", departureTime, arrivalTime, "A1",
            "3C", 100, "Mark", "mark123","Business");
    ArrayList<String> seatArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
    Flight f1 = new Flight("1234", "Toronto", "Vancouver", dt, at, 10,
            10, 3600, "10A", seatArray);
    FlightManager fm = new FlightManager();
    LuggageManager lm = new LuggageManager();
    PHManager phm = new PHManager();
    CustomerManager cm = new CustomerManager();
    PriceCalculator pc = new PriceCalculator();
    Customer olivia = new Customer("oliviaj", "abcdef", "OLIVIAJ");
    PurchaseHistory ph = new PurchaseHistory(olivia);
    diabetic diabetic = new diabetic();

    @Test(timeout = 200)
    public void TestEmptyConstructor() {
        ArrayList<Ticket> exp = new ArrayList<>();
        assertEquals(exp, tm.getSoldTickets());
        assertEquals(0, tm.getSoldTickets().size());
    }

    @Test(timeout = 1000)
    public void TestGetSoldTickets() {
        assertEquals(0, tm.getSoldTickets().size());
        tm.bookTickets(t1);
        assertEquals(1, tm.getSoldTickets().size());
        assertEquals(t1, tm.getSoldTickets().get(0));

    }

    @Test(timeout = 1000)
    public void TestGetTicketByID() {
        tm.bookTickets(t1);
        tm.bookTickets(t2);
        tm.bookTickets(t3);
        String ticketID = "1234,5B";
        assertEquals(tm.getTicketByID(ticketID), t1);
        assertEquals(tm.getTicketByID("4567,12A"), t2);
    }


    @Test(timeout = 200)
    public void TestBookTickets() {
        ArrayList<Ticket> exp = new ArrayList<>();
        assertEquals(exp, tm.getSoldTickets());
        String exp1 = "You have successfully booked the ticket for flight " + t1.getFlightNumber() + "! The" +
                " details are: \n" + t1;
        assertEquals(exp1, tm.bookTickets(t1));
        assertEquals(1, tm.getSoldTickets().size());
        tm.bookTickets(t1);
        String exp2 = "Sorry! Please ensure all the information is correct, and try again later!";
        assertEquals(exp2, tm.bookTickets(t1));

    }

   /* @Test(timeout = 200)
    public void TestCancelTickets() {
        tm.bookTickets(t1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String exp1 = "You have successfully canceled the ticket for flight " + t1.getFlightNumber() + " on " +
                dtf.format(now) +
                ". The details are:" + " \n" + t1;
        assertEquals(exp1, tm.cancelTickets(t1));
        String exp2 = "You have not booked this flight yet, so it cannot be canceled.";
        assertEquals(exp2, tm.cancelTickets(t2));
    }*/
   @Test(timeout = 200)
   public void TestCancelTickets() {
       // set up
       tm.bookTickets(t1);
       fm.AddFlight("1234", "Toronto", "Vancouver", dt, at, "Small",
               10, "3600");
       ph.addPurchasedTickets(t1);
       phm.updateHistory(ph);
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDateTime now = LocalDateTime.now();
       String exp1 = "You have successfully canceled the ticket for flight " + t1.getFlightNumber() + " on " +
               dtf.format(now) +
               ". The details are:" + " \n" + t1;
       //assertEquals(cm.showCustomer("taylorsusername"), t1.getPassenger_username());
       assertEquals(exp1, tm.cancelTickets(t1, lm, phm, cm, fm, pc));
       String exp2 = "You have not booked this flight yet, so it cannot be canceled.";
       assertEquals(exp2, tm.cancelTickets(t2, lm, phm, cm, fm, pc));

       // test if this ticket is not in tm anymore
       ArrayList<Ticket> soldTickets = tm.getSoldTickets();
       assertFalse(soldTickets.contains(t1));
       assertFalse(soldTickets.contains(t2));
       assertFalse(ph.getPurchasedTickets().contains(t1)); // t1 is removed from olivia's purchase history
   }

    @Test(timeout = 500)
    public void TestGenerateTicket(){
        Ticket new_t = tm.generateTicket("1234", "Toronto", "Vancouver", departureTime, arrivalTime, "A1",
                "5B", 100, "Taylor", "taylorsusername", "First");
        assertEquals(new_t.toString(), t1.toString());
    }

    @Test(timeout = 500)
    public void TestGetMileage() {
        fm.AddFlight("1234", "Toronto", "Vancouver", dt, at, "Small",
                 3600, "10A");
        assertEquals(tm.getMileage(t1, fm), 3600);

    }

    @Test(timeout = 500)
    public void TestTicketDisplay() {
        tm.bookTickets(t1);
        tm.bookTickets(t2);
        tm.bookTickets(t3);
        List<Ticket> taylorsTicketInfo = tm.ticketDisplay("taylorsusername");
        List<Ticket> res = new ArrayList<>(Arrays.asList(t1, t2));
        assertEquals(res, taylorsTicketInfo);
        List<Ticket> marksTicketInfo = tm.ticketDisplay("mark123");
        List<Ticket> res2 = new ArrayList<>(List.of(t3));
        assertEquals(res2, marksTicketInfo);
    }


    @Test(timeout = 500)
    public void TestgetTicket_Meal() {
        assertNull(tm.getTicket_Meal(t1));
    }

    @Test(timeout = 500)
    public void TestsetMeall() {
        assertNull(tm.getTicket_Meal(t1));
        tm.setMeal(t1, diabetic);
        assertEquals(tm.getTicket_Meal(t1).getName(),"Diabetic");
    }
}