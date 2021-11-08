package UStore;

public class Mug implements RewardsItem {
    private boolean redeemed;
    private final String name;
    /**
     * Construct a mug
     */
    public Mug() {
        this.name="Mug";
        this.redeemed = false;
    }
    /**
     * Construct a mug if the customer has earned at least 800 points.
     * @param points redeem points that the customer has
     */
    @Override
    public Object createItem(float points) {
        if (points >=800){
            // TODO: subtract these points after redemption from customer's info
            return new Mug();
            // since it hasn't been redeemed(i.e., add to customer's info), its redeemed attribute is set to false
        }
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
