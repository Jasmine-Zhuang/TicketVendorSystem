package UStore;

import java.io.Serializable;

public class BookstoreCoupon extends RewardsItem implements Redeemable, Serializable {

    /**
     * Construct a UofT bookstore $20 coupon
     */
    public BookstoreCoupon() {
       super("UofT bookstore $20 coupon",1000);

    }


}
