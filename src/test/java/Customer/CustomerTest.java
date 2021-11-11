package Customer;

import UStore.RewardsItem;
import org.junit.*;

import java.util.ArrayList;

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
        assertEquals(0, Maggie.getMileage());
    }

    @Test(timeout = 50)
    public void getRedeem_points() {
        assertEquals((Integer)0, Maggie.getRedeem_points());
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
        assertEquals(0, Maggie.getMileage());
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        assertEquals(new_Millage, Maggie.getMileage());
    }

    @Test(timeout = 50)
    public void test_checkMembership() {
        assertFalse(Maggie.checkMembership());
    }

    @Test(timeout = 50)
    public void test_checkMembershiplevel() {
        assertEquals(0, Maggie.checkMembershiplevel());
    }

    @Test(timeout = 50)
    public void test_changeMembership() {
        Maggie.changeMembership();
        assertTrue(Maggie.checkMembership());
    }

    @Test(timeout = 50)
    public void test_changeMembershiplevel() {
        Maggie.changeMembership();
        Maggie.changeMembershiplevel();
        Maggie.incrMillage(900);
        assertEquals(1, Maggie.checkMembershiplevel());
    }

    @Test(timeout = 50)
    public void test_getRedeemPoint() {
        Maggie.changeMembership();
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        double redeem_point = 5.0;
        assertEquals(redeem_point, Maggie.calculateRedeemPoint(),0);
    }

    @Test(timeout = 50)
    public void test_getPurchase_History() {
        RewardsItem mug = new RewardsItem("Mug",800);
        Maggie.getPurchaseHistory().addItemRedeemed(mug);
        PurchaseHistory ph = Maggie.getPurchaseHistory();
        assertEquals(Maggie, ph.getOwner());
        ArrayList<RewardsItem> item_list = new ArrayList<>();
        item_list.add(mug);
        assertEquals(Maggie.getPurchaseHistory().getItemRedeemed(), item_list);
    }

    @Test(timeout = 50)
    public void test_calculateRedeemPoint() {
        Maggie.changeMembership();
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        double redeem_point = 5.0;
        Maggie.calculateRedeemPoint();
        assertEquals(redeem_point, Maggie.getRedeem_points(),0);
    }

    @Test(timeout = 50)
    public void test_minusRedeemPoint() {
        Maggie.changeMembership();
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        double redeem_point = 5.0;
        assertEquals(redeem_point, Maggie.calculateRedeemPoint(),0);
        Integer redeemed_points = 1;
        Maggie.minusRedeemPoint(redeemed_points);
        assertEquals(4, Maggie.getRedeem_points(),0);
    }

    @Test(timeout = 50)
    public void test_decrMillage() {
        Maggie.changeMembership();
        int new_Millage = 525;
        Maggie.incrMillage(new_Millage);
        double redeem_point = 5.0;
        assertEquals(redeem_point, Maggie.calculateRedeemPoint(),0);
        int remain_Millage = 425;
        double redeem_points = 1;
        Maggie.decrMillage(redeem_points);
        assertEquals(remain_Millage, Maggie.getMileage(),0);
    }

    @Test(timeout = 1000)
    public void Test_ToString(){
        String a =
                "Username: Happy1203\n" +
                        "Name: MaggieZhang\n" +
                        "Balance: 0\n" +
                        "Millage: 0\n" +
                        "Membership statues: false\n" +
                        "Membership level: 0\n" +
                        "Redeemed points: 0";
        assertEquals(a, Maggie.toString());
    }
}