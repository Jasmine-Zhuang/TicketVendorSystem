package Customer;
/*
This class contains a map of purchase history of all customers regarding tickets and redeemed items.
 */

/*
This class contains a map of purchase history of all customers regarding tickets and redeemed items.
 */

import java.io.Serializable;
import java.util.*;
import Ticket.Ticket;
import UStore.RewardsItem;


public class PHManager implements Serializable {
    private static final long serialVersionUID =4;

    private HashMap<String, PurchaseHistory> phMap;


    /** Construct an empty hashmap of purchase history.
     */
    public PHManager() {
        this.phMap = new HashMap<>();
    }

    /** A getter method.
     */
    public HashMap<String, PurchaseHistory> getPhMap() {
        return this.phMap;
    }

    /**
     * If a customer is not in the map, add it to this map. Update the purchase history if the customer already exists.
     * @param purchaseHistory A PurchaseHistory that is associated with the given customer.
     */

    public void updateHistory (PurchaseHistory purchaseHistory) {
        Customer customer = purchaseHistory.getOwner();
        this.phMap.put(customer.getUsername(), purchaseHistory);
        customer.setPurchaseHistory(purchaseHistory);
    }

    /**
     * Return the list of tickets purchased stored in a customer's purchase history.
     * @param client A Customer instance.
     * @return An Arraylist of Tickets.
     */
    public ArrayList<Ticket> getTickets (Customer client) {
        for (String c:phMap.keySet())
            if (c.equals(client.getUsername())) {
                return phMap.get(c).getPurchasedTickets();
            }
        return null;
    }

    /**
     * Return the list of items redeemed stored in a customer's purchase history.
     * @param client A Customer instance.
     * @return An Arraylist of RewardItems.
     */
    public ArrayList<RewardsItem> getRewardsItems (Customer client) {
        for (String c:phMap.keySet())
            if (c.equals(client.getUsername())) {
                return phMap.get(c).getItemRedeemed();
            }
        return null;
    }

    /**
     * Return true if a customer's purchase history is updated. False otherwise.
     * @param customer A Customer instance.
     * @param newPH A new purchase history.
     * @return boolean.
     */
    public boolean updatePurchaseHistory (Customer customer, PurchaseHistory newPH) {
        phMap.replace(customer.getUsername(), newPH);
        return true;
    }
}
