package UStore;

import java.io.Serializable;

public class TVoucher extends RewardsItem implements Redeemable, Serializable {
    /**
     * Construct a T-card $20 voucher
     */
    public TVoucher() {
        super("T-card $20 voucher",1000);
    }

}
