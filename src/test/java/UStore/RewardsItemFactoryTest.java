package UStore;
import org.junit.*;
import static org.junit.Assert.*;
public class RewardsItemFactoryTest {
    RewardsItemFactory factory = new RewardsItemFactory();

    @Test(timeout = 50)
    public void TestGetItem() {
        assertTrue(factory.getItem("Backpack") instanceof Backpack);
        assertTrue(factory.getItem("BookstoreCoupon") instanceof BookstoreCoupon);
        assertTrue(factory.getItem("GiftCard") instanceof GiftCard);
        assertTrue(factory.getItem("Mug") instanceof Mug);
        assertTrue(factory.getItem("TVoucher") instanceof TVoucher);
        assertNull(factory.getItem(" "));
       }
}
