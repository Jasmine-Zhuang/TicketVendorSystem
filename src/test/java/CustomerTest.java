import org.junit.*;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer Maggie;

    @Before
    public void setUp() {
        String new_username = "Happy1203";
        String new_password = "1203";
        String new_name = "MaggieZhang";
        Maggie = new Customer(new_username,new_password,new_name);
    }

    @Test(timeout = 50)
    public void test_getName() {
        assertEquals("MaggieZhang", Maggie.getName());
    }

    @Test(timeout = 50)
    public void test_getUsername() {
        assertEquals("Happy1203", Maggie.getUsername());
    }

    @Test(timeout = 50)
    public void test_getBalance() {
        assertEquals(0, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_getMillage() {
        assertEquals(0, Maggie.getMillage());
    }

    @Test(timeout = 50)
    public void test_checkPassword() {
        assertTrue(Maggie.checkPassword("1203"));
    }

    @Test(timeout = 50)
    public void test_changePassword() {
        String changed_password = "12030422";
        assertTrue(Maggie.changePassword("1203",changed_password));
    }

    @Test(timeout = 50)
    public void test_changeName() {
        String changed_name = "OliverJiang";
        Maggie.changeName(changed_name);
        assertEquals(changed_name, Maggie.getName());
    }

    @Test(timeout = 50)
    public void test_changeUsername() {
        String changed_username = "Happy04237978947";
        Maggie.changeUsername(changed_username);
        assertEquals(changed_username, Maggie.getUsername());
    }

    @Test(timeout = 50)
    public void test_incrBalance() {
        int new_balance = 100;
        Maggie.incrBalance(new_balance);
        assertEquals(100, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_successful_decrBalance() {
        int new_balance = 100;
        Maggie.incrBalance(new_balance);
        assertEquals(100, Maggie.getBalance());
        int decreased_balance = 50;
        assertTrue(Maggie.decrBalance(decreased_balance));
        assertEquals(50, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_filed_decrBalance() {
        int new_balance = 100;
        Maggie.incrBalance(new_balance);
        assertEquals(100, Maggie.getBalance());
        int decreased_balance = 1000;
        assertFalse(Maggie.decrBalance(decreased_balance));
        assertEquals(100, Maggie.getBalance());
    }

    @Test(timeout = 50)
    public void test_incrMillage() {
        assertEquals(0, Maggie.getMillage());
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        assertEquals(new_Millage, Maggie.getMillage());
    }

    @Test(timeout = 50)
    public void test_checkMembership() {
        assertFalse(Maggie.checkMembership());
    }

    @Test(timeout = 50)
    public void test_changeMembership() {
        Maggie.changeMembership();
        assertTrue(Maggie.checkMembership());
    }

    @Test(timeout = 1000)
    public void Test_ToString(){
        String a =
                "Username: Happy1203\n" +
                "Name: MaggieZhang\n" +
                "Balance: 0\n" +
                "Millage: 0\n" +
                "Membership statues: false";
        assertEquals(a, Maggie.toString());
    }
}