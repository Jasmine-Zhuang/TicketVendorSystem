package Customer;
/*
This class contains a map of purchase history of all customers regarding tickets and redeemed items.
 */

/*
This class contains a map of purchase history of all customers regarding tickets and redeemed items.
 */

import java.util.*;
import Ticket.Ticket;
import UStore.RewardsItem;


public class PHManager {

    private HashMap<Customer, PurchaseHistory> phMap;


    /** Construct an empty hashmap of purchase history.
     */
    public PHManager() {
        this.phMap = new HashMap<>();
    }

    /** A getter method.
     */
    public HashMap<Customer, PurchaseHistory> getPhMap() {
        return this.phMap;
    }

    /**
     * If a customer is not in the map, add it to this map. Update the purchase history if the customer already exists.
     * @param purchaseHistory A PurchaseHistory that is associated with the given customer.
     */

    public void updateHistory (PurchaseHistory purchaseHistory) {
        Customer customer = purchaseHistory.getOwner();
        this.phMap.put(customer, purchaseHistory);
    }

    public ArrayList<Ticket> getTickets (Customer client) {
        for (Customer c:phMap.keySet())
            if (c.getUsername().equals(client.getUsername())) {
                return phMap.get(c).getPurchasedTickets();
            }
        return null;
    }

    public ArrayList<RewardsItem> getRewardsItems (Customer client) {
        for (Customer c:phMap.keySet())
            if (c.getUsername().equals(client.getUsername())) {
                return phMap.get(c).getItemRedeemed();
            }
        return null;
    }

}
