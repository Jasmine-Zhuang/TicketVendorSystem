package UStore;

import Customer.Customer;
import Customer.PurchaseHistory;

public class RewardsItem implements Redeemable{
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
     * @param points redeem points that the customer has
     */
    public String redeemItem(int points, Customer customer) {
        if (points >= this.getPoints()){
            RewardsItem rewardsItem =  new RewardsItem(this.getName(),this.getPoints());
            rewardsItem.setRedeemed(true);
            PurchaseHistory ph = customer.getPurchaseHistory();
            if(ph.addItemRedeemed(rewardsItem)){
                customer.minusRedeemPoint(rewardsItem.getPoints());
                return "A "+rewardsItem.getName()+ "is redeemed successfully. You can see it on your purchase history.";
            }
        }
        return "Fail to redeem since your points are insufficient.";

    }
    @Override
    public String toString() {
        return this.getName() +":"+ this.getPoints()+" is needed to redeem.";
    }

}
