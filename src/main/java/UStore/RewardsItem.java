package UStore;

import Customer.Customer;
import Customer.PurchaseHistory;

import java.io.Serializable;

public class RewardsItem implements Redeemable, Serializable {
    private boolean isRedeemed;
    private final String name;
    private final int points;
    /**
     * Construct a rewards item
     */
    public RewardsItem(String name, int points) {
        this.isRedeemed = false;
        this.name = name;
        this.points = points;
    }
    /**
     * A getter method.
     * @return name of the rewards item
     */
    public String getName() {return name;}

    /**
     * A getter method.
     * @return points needed to redeem the item
     */
    public int getPoints() {return points;}

    /**
     * A getter method.
     * @return true if the item is redeemed, false otherwise.
     */
    public boolean isRedeemed() {return isRedeemed;}
    /**
     * A setter method.
     * set true if the item is redeemed, false otherwise.
     */
    public void setRedeemed(boolean isRedeemed) {this.isRedeemed = isRedeemed;}

    /**
     * Redeem a rewards item if the customer has earned the points needed for the item.
     * @param customer Customer
     */
    public RewardsItem redeemItem(Customer customer) {
        if (customer.getRedeem_points() >= this.getPoints()){
            this.setRedeemed(true);
            PurchaseHistory ph = customer.getPurchaseHistory();
            if(ph.addItemRedeemed(this, customer)){
                customer.minusRedeemPoint(this.getPoints());

            }
            return this;
        }
        return null;

    }
    @Override
    public String toString() {
        return this.getName() +": "+ this.getPoints()+" is needed to redeem.";
    }

}
