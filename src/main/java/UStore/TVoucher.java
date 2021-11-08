package UStore;

public class TVoucher implements RewardsItem{
    private boolean redeemed;
    private final String name;
    /**
     * Construct a T-card $20 voucher
     */
    public TVoucher() {
        this.name="T-card $20 voucher";
        this.redeemed = false;
    }
    /**
     * Construct a T-card $20 voucher if the customer has earned at least 1000 points.
     * @param points redeem points that the customer has
     */
    @Override
    public Object createItem(float points) {
        if(points >= 1000){
            // subtract these points after redemption from customer's info
            return new TVoucher();}
        return null;
    }
    /**
     * Redeem a UofT limited edition backpack if the customer has earned at least 3500 points.
     * @return a String of confirmation of the redemption
     */
    public String redeem() {
        this.redeemed = true;
        return "You have successfully redeemed a "+ this.getName();
    }

    /**
     * A getter method.
     * @return name of the rewards item
     */
    public String getName() {
        return name;
    }
}
