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

    /**
     * Show tickets purchased by a customer.
     * @param client A Customer instance.
     * @return a list of tickets client purchased.
     */

    public ArrayList<Ticket> getTickets (Customer client) {
        for (Customer c:phMap.keySet())
            if (c.getUsername().equals(client.getUsername())) {
                return phMap.get(c).getPurchasedTickets();
            }
        return null;
    }

    /**
     * Show items redeemed by a customer.
     * @param client A Customer instance.
     * @return a list of items client redeemed.
     */

    public ArrayList<RewardsItem> getRewardsItems (Customer client) {
        for (Customer c:phMap.keySet())
            if (c.getUsername().equals(client.getUsername())) {
                return phMap.get(c).getItemRedeemed();
            }
        return null;
    }



}
