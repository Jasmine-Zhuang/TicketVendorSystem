package UStore;

import Customer.Customer;
import Customer.PurchaseHistory;

import java.io.Serializable;

public class GiftCard extends RewardsItem implements Redeemable, Serializable {
    /**
     * Construct a Starbucks $20 gift card
     */
    public GiftCard() {
        super("Starbucks $20 gift card", 2000);
    }
}
