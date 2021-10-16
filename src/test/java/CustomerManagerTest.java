import org.junit.*;

import static org.junit.Assert.*;

public class CustomerManagerTest {
    CustomerManager Ryan;
    @Before
    public void setUp() {
        Ryan = new CustomerManager();
    }
    Customer Maggie = new Customer("Name1203","1203", "RyanMaggie");

    @Test(timeout = 50)
    public void test_addCustomer() {
        Ryan.addCustomer(Maggie);
        assertTrue(Ryan.checkCustomer("Name1203"));
    }

    @Test(timeout = 50)
    public void test_checkPassword() {
        Ryan.addCustomer(Maggie);
        assertTrue(Ryan.checkPassword("Name1203","1203"));
    }

    @Test(timeout = 50)
    public void test_showCustomer() {
        Ryan.addCustomer(Maggie);
        assertEquals(Maggie, Ryan.showCustomer("Name1203"));
    }

    @Test(timeout = 50)
    public void test_showCustomerBalance() {
        Ryan.addCustomer(Maggie);
        assertEquals(0, Ryan.showCustomerBalance("Name1203"));
    }

    @Test(timeout = 50)
    public void test_changeName() {
        assertEquals("RyanMaggie", Maggie.getName());
        String newname = "OliverJiang";
        Ryan.addCustomer(Maggie);
        Ryan.changeName(newname, Maggie);
        assertEquals("OliverJiang", Maggie.getName());
    }

    @Test(timeout = 50)
    public void test_changePassword() {
        assertTrue(Maggie.checkPassword("1203"));
        String new_password = "04123456789";
        Ryan.addCustomer(Maggie);
        assertEquals("Success", Ryan.changePassword("1203", new_password, Maggie));
        assertTrue(Maggie.checkPassword(new_password));
    }

    @Test(timeout = 50)
    public void test_changeUsername() {
        assertEquals("Name1203", Maggie.getUsername());
        String new_username = "Name0422";
        Ryan.addCustomer(Maggie);
        Ryan.changeUsername(new_username, Maggie);
        assertEquals("Name0422", Maggie.getUsername());
    }

    @Test(timeout = 50)
    public void test_incrBalance() {
        assertEquals(0, Maggie.getBalance());
        int new_balance = 1000;
        Ryan.addCustomer(Maggie);
        Ryan.incrBalance(new_balance, Maggie);
        assertEquals(1000, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_decrBalance() {
        assertEquals(0, Maggie.getBalance());
        int new_balance = 1000;
        Ryan.addCustomer(Maggie);
        Ryan.incrBalance(new_balance, Maggie);
        assertEquals(1000, Maggie.getBalance());
        int dec_balance1 = 10000;
        Ryan.decrBalance(dec_balance1, Maggie);
        assertEquals(1000, Maggie.getBalance());
        int dec_balance2 = 10;
        Ryan.decrBalance(dec_balance2, Maggie);
        assertEquals(990, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_updateMillage() {
        assertEquals(0, Maggie.getMillage());
        int new_millage = 500;
        Ryan.addCustomer(Maggie);
        Ryan.updateMillage(new_millage, Maggie);
        assertEquals(500, Maggie.getMillage());
    }

    @Test(timeout = 50)
    public void test_checkMembership() {
        assertFalse(Maggie.checkMembership());
        Ryan.addCustomer(Maggie);
        Ryan.checkMembership(Maggie);
        assertTrue(Maggie.checkMembership());
    }

}