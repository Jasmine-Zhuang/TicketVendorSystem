package UStore;

public class BookstoreCoupon implements RewardsItem{
    private boolean redeemed;
    private final String name;
    /**
     * Construct a UofT bookstore $20 coupon
     */
    public BookstoreCoupon() {
        this.name = "UofT bookstore $20 coupon";
        this.redeemed = false;
    }

    /**
     * Construct a UofT bookstore $20 coupon if the customer has earned at least 1000 points.
     * @param points redeem points that the customer has
     */
    @Override
    public Object createItem(float points) {
        if(points >= 1000){
            // TODO:subtract 1000 points after redemption from customer's info
            return new BookstoreCoupon();
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
