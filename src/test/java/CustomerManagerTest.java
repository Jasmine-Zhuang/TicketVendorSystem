import org.junit.*;

import static org.junit.Assert.assertTrue;

public class CustomerManagerTest {
    CustomerManager Haha;

    @Before
    public void setUp() {
        Haha = new CustomerManager();
    }

    @Test(timeout = 50)
    public void testcheckCustomer() {
        Customer h = new Customer("Name","123", "RyanMaggie");
        Haha.addCustomer(h);
        assertTrue(Haha.checkCustomer("RyanMaggie"));
    }
}