/*
This class contains a map of purchase history of all customers regarding ticktes and redeemed items.
 */

import java.util.HashMap;

public class PHManager {

    private final HashMap<Customer, PurchaseHistory> phMap;


    /** Construct an empty hashmap of purchase history.
     */
    public PHManager() {
        this.phMap = new HashMap<Customer, PurchaseHistory>();
    }

    /**
     * If a customer is not in the map, add it to this map. Update the purchase history if the customer already exists.
     * @param customer A customer instance.
     * @param purchaseHistory A PurchaseHistory that is associated with the given customer.
     */
    public void updateHistory (Customer customer, PurchaseHistory purchaseHistory) {
            phMap.put(customer, purchaseHistory);
    }
}
