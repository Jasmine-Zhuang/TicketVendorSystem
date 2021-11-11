package Customer;

import Ticket.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PHManagerTest {

    Customer c1;
    Customer c2;
    PurchaseHistory ph1 = new PurchaseHistory(c1);
    PurchaseHistory ph2 = new PurchaseHistory(c2);
    Ticket t1;
    PHManager phm = new PHManager();

    @Before
    public void setUp() {
    }

    @Test (timeout = 500)
    public void TestEmptyUpdateHistory() {
        // empty map
        HashMap<Customer, PurchaseHistory> hm1 = new HashMap<>();
        assertTrue(hm1.equals(phm.getPhMap()));

    }

    @Test (timeout = 500)
    public void TestUpdateHistory1() {
        phm.updateHistory(ph1);
        phm.updateHistory(ph2);
        HashMap<Customer, PurchaseHistory> hm2 = new HashMap<>();
        hm2.put(c1, ph1);
        hm2.put(c2, ph2);
        assertEquals(hm2, phm.getPhMap());
    }

    @Test (timeout = 500)
    public void TestUpdateHistory2() {
        HashMap<Customer, PurchaseHistory> hm3 = new HashMap<>();
        hm3.put(c1, ph1);
        hm3.put(c2, ph2);
        phm.updateHistory(ph1);
        phm.updateHistory(ph2);
        ph1.addPurchasedTickets(t1);
        phm.updateHistory(ph1);
        hm3.put(c1, ph1);
        assertEquals(hm3, phm.getPhMap());
    }
}
