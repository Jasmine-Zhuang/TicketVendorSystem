import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PurchaseHistoryTest {

    PurchaseHistory ph;
    Customer Olivia;
    RewardsItem item1;
    RewardsItem item2;
    Ticket t1;
    Ticket t2;

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

}