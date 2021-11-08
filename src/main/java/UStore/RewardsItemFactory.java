package UStore;

public class RewardsItemFactory {
    /**
     * Get an object of type RewardsItem
     * @param itemType type of rewards item to be redeemed
     */

    public RewardsItem getItem(String itemType){
        return switch (itemType) {
            case "Backpack" -> new Backpack();
            case "BookstoreCoupon" -> new BookstoreCoupon();
            case "GiftCard" -> new GiftCard();
            case "Mug" -> new Mug();
            case "TVoucher" -> new TVoucher();
            default -> null;
        };

    }

}
