package UStore;
import Customer.Customer;
import org.junit.*;
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
    public void TestRedeemItem(){

        String new_username = "Haaa";
        String new_password = "1203";
        String new_name = "MXY";
        Customer C = new Customer(new_username,new_password,new_name);
        assertEquals(mug.redeemItem(700, C), "Fail to redeem since your points are insufficient.");
        assertEquals(mug.redeemItem(900, C),"A Mug is redeemed successfully. You can see it on your purchase history now.");
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