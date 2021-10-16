import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TicketManagerTest {

    TicketManager tm;

    @Before
    public void setUp() { tm = new TicketManager();}

    @Test
    public void TestEmptyConstructor() {
        ArrayList<Ticket> exp = new ArrayList<>();
        assertEquals(exp, tm.getSoldTickets());
        assertEquals(0, tm.getSoldTickets().size());
    }

    @Test
    public void TestGetSoldTickets() {
        ArrayList<String> dt = new ArrayList<>(Arrays.asList("2021", "8", "22", "12", "35"));
        ArrayList<String> at = new ArrayList<>(Arrays.asList("2021", "8", "23", "11", "35"));
        Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
        assertEquals(0, tm.getSoldTickets().size());
        tm.bookTickets(t1);
        assertEquals(1, tm.getSoldTickets().size());
        assertEquals(t1, tm.getSoldTickets().get(0));

    }


    @Test(timeout = 200)
    public void TestBookTickets() {
        ArrayList<String> dt = new ArrayList<>(Arrays.asList("2021", "8", "22", "12", "35"));
        ArrayList<String> at = new ArrayList<>(Arrays.asList("2021", "8", "23", "11", "35"));
        Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
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

    @Test(timeout = 100)
    public void TestCancelTickets() {
        ArrayList<String> dt = new ArrayList<>(Arrays.asList("2021", "8", "22", "12", "35"));
        ArrayList<String> at = new ArrayList<>(Arrays.asList("2021", "8", "23", "11", "35"));
        Ticket t1 = new Ticket("1234", "Toronto", "Vancouver", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
        tm.bookTickets(t1);
        String exp1 = "You have successfully canceled the ticket for flight " + t1.getFlightNumber() +
                "! The details are:" + " \n" + t1;
        assertEquals(exp1, tm.cancelTickets(t1));
        Ticket t2 = new Ticket("1234", "Vancouver", "Toronto", dt, at, "A",
                "5B", 100, "Taylor", "taylorsusername");
        String exp2 = "You have not booked this flight yet, so it cannot be canceled.";
        assertEquals(exp2, tm.cancelTickets(t2));
    }
}
