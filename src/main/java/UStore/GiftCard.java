package UStore;

import Customer.Customer;
import Customer.PurchaseHistory;

public class GiftCard extends RewardsItem implements Redeemable {
    /**
     * Construct a Starbucks $20 gift card
     */
    public GiftCard() {
        super("Starbucks $20 gift card", 2000);
    }
}
