import org.junit.*;

import static org.junit.Assert.*;

public class MembershipTest {
    Membership AllMember;
    @Before
    public void setUp() {
        AllMember = new Membership();
    }
    Customer Maggie = new Customer("GoodStudy","1234", "DayStudy");

    @Test(timeout = 50)
    public void test_checkMembership() {
        assertFalse(Maggie.checkMembership());
        AllMember.changeMembership(Maggie);
        AllMember.addCustomer(Maggie);
        assertTrue(AllMember.checkMembership(Maggie));
    }

    @Test(timeout = 50)
    public void test_changeMembership() {
        assertFalse(Maggie.checkMembership());
        AllMember.changeMembership(Maggie);
        AllMember.addCustomer(Maggie);
        assertTrue(AllMember.checkMembership(Maggie));
    }

    @Test(timeout = 50)
    public void test_addCustomer() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertTrue(AllMember.checkCustomer(Maggie.getUsername()));
    }

    @Test(timeout = 50)
    public void test_checkCustomer() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertTrue(AllMember.checkCustomer(Maggie.getUsername()));
    }

    @Test(timeout = 50)
    public void test_showCustomer() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertTrue(AllMember.checkCustomer(Maggie.getUsername()));
        Customer mm = AllMember.showCustomer(Maggie.getUsername());
        assertEquals(Maggie.getName(), mm.getName());
    }

    @Test(timeout = 50)
    public void test_showCustomerBalance() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        if (AllMember.showCustomerBalance(Maggie.getUsername()) == (int)AllMember.showCustomerBalance(Maggie.getUsername())) {
            assertEquals(0, (int)AllMember.showCustomerBalance(Maggie.getUsername()));
    }}

    @Test(timeout = 50)
    public void test_decrMemberBalance() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, (int)AllMember.showCustomerBalance(Maggie.getUsername()));
        int new_balance = 2000;
        Maggie.incrBalance(new_balance);
        int ticket_price = 300;
        assertTrue(AllMember.decrMemberBalance(ticket_price, Maggie));
        assertEquals(1730, (int)AllMember.showCustomerBalance(Maggie.getUsername()));
    }


    @Test(timeout = 50)
    public void test_incrMemberBalance() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, (int)AllMember.showCustomerBalance(Maggie.getUsername()));
        int new_balance = 2000;
        Maggie.incrBalance(new_balance);
        int ticket_price = 300;
        AllMember.incrMemberBalance(ticket_price, Maggie);
        assertEquals(2270, (int)AllMember.showCustomerBalance(Maggie.getUsername()));
    }

    @Test(timeout = 50)
    public void test_incrMillage() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, Maggie.getMillage());
        int new_millage = 500;
        AllMember.incrMillage(new_millage, Maggie);
        assertEquals(500, Maggie.getMillage());
    }


    @Test(timeout = 50)
    public void test_getRedeemPoint() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, Maggie.getMillage());
        int new_millage = 500;
        AllMember.addCustomer(Maggie);
        AllMember.incrMillage(new_millage, Maggie);
        assertEquals(500, Maggie.getMillage());
        AllMember.changeMembership(Maggie);
        double redeem_point = 5.00;
        assertEquals(redeem_point, AllMember.getRedeemPoint(Maggie),0);
    }
    @Test(timeout = 50)
    public void test_decrMillage() {
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, Maggie.getMillage());
        int new_millage = 500;
        AllMember.addCustomer(Maggie);
        AllMember.incrMillage(new_millage, Maggie);
        assertEquals(500, Maggie.getMillage());
        AllMember.changeMembership(Maggie);
        double redeem_point = 5.00;
        assertEquals(redeem_point, Maggie.getRedeemPoint(),0);
        int remain_Millage = 400;
        double redeem_points = 1;
        AllMember.decrMillage(Maggie,redeem_points);
        assertEquals(remain_Millage, Maggie.getMillage(),0);
    }


    @Test(timeout = 1000)
    public void Test_displayInfo(){
        Maggie.changeMembership();
        AllMember.addCustomer(Maggie);
        assertEquals(0, Maggie.getMillage());
        int new_millage = 500;
        AllMember.addCustomer(Maggie);
        AllMember.incrMillage(new_millage, Maggie);
        AllMember.displayInfo(Maggie);
        String a =
                """
                        Username: GoodStudy
                        Name: DayStudy
                        Balance: 0
                        Millage: 500
                        Membership statues: true
                        Redeemed points: 0.0""";
        assertEquals(a, AllMember.displayInfo(Maggie));
    }









}
