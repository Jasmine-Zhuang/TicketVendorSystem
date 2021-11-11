package Customer;
/*
This class contains a map of purchase history of all customers regarding tickets and redeemed items.
 */

import java.util.HashMap;

public class PHManager {

    private final HashMap<Customer, PurchaseHistory> phMap;


    /** Construct an empty hashmap of purchase history.
     */
    public PHManager() {
        this.phMap = new HashMap<>();
    }

    /**
     * If a customer is not in the map, add it to this map. Update the purchase history if the customer already exists.
     * @param purchaseHistory A PurchaseHistory that is associated with the given customer.
     */
    public void updateHistory (PurchaseHistory purchaseHistory) {
        Customer customer = purchaseHistory.getOwner();
        phMap.put(customer, purchaseHistory);
    }

}
