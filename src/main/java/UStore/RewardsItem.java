package UStore;

public class RewardsItem {
    private boolean isRedeemed;
    private final String name;
    private final float points;

    /**
     * Construct a rewards item
     */
    public RewardsItem(String name, float points) {
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
    public float getPoints() {return points;}

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

    public RewardsItem redeemItem(float points) {
        if (points >=this.getPoints()){
            // TODO: subtract these points after redemption from customer's info
            return new RewardsItem(this.getName(),this.getPoints());
            // since it hasn't been redeemed(i.e., add to customer's info), its redeemed attribute is set to false
        }
        return null;
    }

}
