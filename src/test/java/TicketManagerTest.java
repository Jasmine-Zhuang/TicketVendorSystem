import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

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
            "5B", 100, "Taylor", "taylorsusername");
    Ticket t2 = new Ticket("1234", "Vancouver", "Toronto", departureTime, arrivalTime, "A1",
            "5B", 100, "Taylor", "taylorsusername");

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

    @Test(timeout = 200)
    public void TestCancelTickets() {
        tm.bookTickets(t1);
        String exp1 = "You have successfully canceled the ticket for flight " + t1.getFlightNumber() +
                "! The details are:" + " \n" + t1;
        assertEquals(exp1, tm.cancelTickets(t1));
        String exp2 = "You have not booked this flight yet, so it cannot be canceled.";
        assertEquals(exp2, tm.cancelTickets(t2));
    }
/*
    @Test(timeout = 500)
    public void TestGenerateTicket(){
        Ticket new_t = tm.generateTicket("1234", "Toronto", "Vancouver",
                departureTime, arrivalTime, "A1", "5B", 100, "Taylor",
                "taylorsusername");
        assertEquals(t1, new_t);
    }*/
}
