package UStore;
import Customer.Customer;
import Customer.PurchaseHistory;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RewardsItemTest {
    RewardsItem mug;
    @Before
    public void setUp() {
        mug = new RewardsItem("Mug",800);
    }

    @Test(timeout = 50)
    public void TestConstructor() {
        assertEquals(mug.getName(), "Mug");
        assertEquals(mug.getPoints(),800);
    }
    @Test(timeout = 50)
    public void TestGetName(){
        assertEquals(mug.getName(), "Mug");
    }
    @Test(timeout = 50)
    public void TestGetPoints(){
        assertEquals(mug.getPoints(), 800);
    }
    @Test(timeout = 50)
    public void TestIsRedeemed(){
        assertFalse(mug.isRedeemed());
    }
    @Test(timeout = 50)
    public void TestToString(){
        assertEquals(mug.getName() +":"+ mug.getPoints()+" is needed to redeem.",mug.toString());
    }
    @Test(timeout = 50)
    public void TestRedeemItem(){
        String new_username = "Haaa";
        String new_password = "1203";
        String new_name = "MXY";
        Customer C = new Customer(new_username,new_password,new_name);
        C.incrMillage(70000);
        C.changeMembership();
        C.calculateRedeemPoint();
        assertEquals((int)C.getRedeem_points(),700);
        assertEquals(mug.redeemItem(C), "Fail to redeem since your points are insufficient.");

        C.incrMillage(10000);
        C.calculateRedeemPoint();
        assertEquals((int)C.getRedeem_points(),800);
        assertEquals(mug.redeemItem(C),"A Mug is redeemed successfully. You can see it on your purchase history.");
        assertEquals((int)C.getRedeem_points(),0);

        PurchaseHistory ph = C.getPurchaseHistory();
        assertTrue(ph.getItemRedeemed().get(0) instanceof Mug);
        assertTrue(mug.isRedeemed());


 /*       assertTrue(mug1.isRedeemed());
        assertEquals(mug1.getName(),"Mug");
        assertEquals(mug1.getPoints(),800);*/
    }
    @Test(timeout = 50)
    public void TestSetRedeemed(){
        if(! mug.isRedeemed()){
            mug.setRedeemed(true);
            assertTrue(mug.isRedeemed());
        }else {
            mug.setRedeemed(false);
            assertFalse(mug.isRedeemed());
        }
    }

}