package UStore;
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
        assertNull(mug.redeemItem(700));
        RewardsItem mug1=mug.redeemItem(900);
        assertTrue(mug1.isRedeemed());
        assertEquals(mug1.getName(),"Mug");
        assertEquals(mug1.getPoints(),800);
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