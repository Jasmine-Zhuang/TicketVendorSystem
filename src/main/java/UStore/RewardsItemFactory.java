package UStore;

public class RewardsItemFactory {
    /*public RewardsItemFactory(){};*/

    /**
     * Get an object of type RewardsItem
     * @param itemType type of rewards item to be redeemed
     */
    public Redeemable getItem(String itemType){
        if ("Backpack".equals(itemType)) {
            return new Backpack();
        } else if ("BookstoreCoupon".equals(itemType)) {
            return new BookstoreCoupon();
        } else if ("GiftCard".equals(itemType)) {
            return new GiftCard();
        } else if ("Mug".equals(itemType)) {
            return new Mug();
        } else if ("TVoucher".equals(itemType)) {
            return new TVoucher();
        }
        return null;
    }

}
