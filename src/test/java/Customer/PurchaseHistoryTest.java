package Customer;

import Ticket.Ticket;
import UStore.RewardsItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PurchaseHistoryTest {

    PurchaseHistory ph;
    Customer Olivia;
    RewardsItem item1 = new RewardsItem("Mug",800);
    RewardsItem item2 = new RewardsItem("UofT bookstore $20 coupon",1000);
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

    @Before
    public void setUp() {
        ph = new PurchaseHistory(Olivia);
    }

    @Test (timeout = 500)
    public void addPurchasedTickets() {
    ph.addPurchasedTickets(t1);
        ph.addPurchasedTickets(t2);
        ArrayList<Ticket> tickets = new ArrayList<>(Arrays.asList(t1, t2));
        assertEquals(tickets, ph.getPurchasedTickets());
    }

    @Test (timeout = 500)
    public void addItemRedeemed() {
        ph.addItemRedeemed(item1);
        ph.addItemRedeemed(item2);
        ArrayList<RewardsItem> items = new ArrayList<>(Arrays.asList(item1, item2));
        assertEquals(items, ph.getItemRedeemed());
    }

    @Test (timeout = 500)
    public void getPurchasedTickets() {
        assertEquals(0, ph.getPurchasedTickets().size());
        ph.addPurchasedTickets(t1);
        ph.addPurchasedTickets(t2);
        assertEquals(2, ph.getPurchasedTickets().size());
    }

    @Test (timeout = 500)
    public void getItemRedeemed() {
        assertEquals(0, ph.getItemRedeemed().size());
        ph.addItemRedeemed(item1);
        ph.addItemRedeemed(item2);
        assertEquals(2, ph.getItemRedeemed().size());
    }

    @Test
    public void getOwner() {
        assertEquals(Olivia, ph.getOwner());
    }

    @Test
    public void TestRemovePurchasedTicket() {
        ph.addPurchasedTickets(t1);
        ph.addPurchasedTickets(t2);
        ph.removePurchasedTickets(t1);
        assertFalse(ph.getPurchasedTickets().contains(t1));
        assertTrue(ph.getPurchasedTickets().contains(t2));
    }

    @Test
    public void TestRemoveItemRedeemed() {
        ph.addItemRedeemed(item1);
        ph.addItemRedeemed(item2);
        ph.removeItemRedeemed(item2);
        assertFalse(ph.getItemRedeemed().contains(item2));
        assertTrue(ph.getItemRedeemed().contains(item1));
    }

}
