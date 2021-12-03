package Customer;

import Ticket.Ticket;
import UStore.RewardsItem;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class PHManagerTest {

    PHManager phm;

    @Before
    public void setUp() { phm = new PHManager();
    }
    Customer c1 = new Customer("Name1203", "1203", "RyanMaggie");
    Customer c2 = new Customer("abc123", "sdhj27", "Olivia");
    PurchaseHistory ph1 = new PurchaseHistory(c1);
    PurchaseHistory ph2 = new PurchaseHistory(c2);
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
    RewardsItem rw1 = new RewardsItem("Mug", 800);
    RewardsItem rw2 = new RewardsItem("TVoucher", 1200);
    Customer olivia = new Customer("taylorsusername", "abcdef", "Taylor");
    PurchaseHistory ph = new PurchaseHistory(olivia);

    @Test (timeout = 500)
    public void TestEmptyUpdateHistory() {
        // empty map
        HashMap<Customer, PurchaseHistory> hm1 = new HashMap<>();
        assertEquals(hm1, phm.getPhMap());

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
        ph1.addPurchasedTickets(t1, c1);
        phm.updateHistory(ph1);
        hm3.put(c1, ph1);
        assertEquals(hm3, phm.getPhMap());
    }

    @Test (timeout = 500)
    public void TestGetTickets() {
        ph1.addPurchasedTickets(t1);
        ph2.addPurchasedTickets(t2);
        ph2.addPurchasedTickets(t3);
        phm.updateHistory(ph1);
        phm.updateHistory(ph2);
        ArrayList<Ticket> t1Array = new ArrayList<>(List.of(t1));
        ArrayList<Ticket> t2Array = new ArrayList<>(Arrays.asList(t2, t3));
        assertEquals(t1Array, phm.getTickets(c1));
        assertEquals(t2Array, phm.getTickets(c2));
    }

    @Test (timeout = 500)
    public void TestGetRewardsItems() {
        ph1.addItemRedeemed(rw1, c1);
        ph2.addItemRedeemed(rw2, c2);
        phm.updateHistory(ph1);
        phm.updateHistory(ph2);
        ArrayList<RewardsItem> r1Array = new ArrayList<>(List.of(rw1));
        ArrayList<RewardsItem> r2Array = new ArrayList<>(List.of(rw2));
        assertEquals(r1Array, phm.getRewardsItems(c1));
        assertEquals(r2Array, phm.getRewardsItems(c2));
    }

    @Test (timeout = 500)
    public void TestUpdatePurchaseHistory() {
        ph.addPurchasedTickets(t1);
        ph.addPurchasedTickets(t2);
        ph.addItemRedeemed(rw1);
        phm.updateHistory(ph);
        ph.removePurchasedTickets(t2, olivia);
        phm.updatePurchaseHistory(olivia, ph);

        assertFalse(phm.getTickets(olivia).contains(t2));
    }
}
