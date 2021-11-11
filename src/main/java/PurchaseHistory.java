/*
This class is a record of purchase history of a customer regarding ticktes and redeemed items.
 */

import java.util.ArrayList;

public class PurchaseHistory {

    private final Customer phCustomer;
    private final ArrayList<Ticket> purchasedTickets;
    private final ArrayList<RewardsItem> itemRedeemed;


    /** Construct a PurchaseHistory, giving them the customer it belongs to, an empty list of purchased tickets and
     * item redeemed.
     */
    public PurchaseHistory(Customer customer) {
        this.phCustomer = customer;
        this.purchasedTickets = new ArrayList<>();
        this.itemRedeemed = new ArrayList<>();
    }

    /**
     * A getter method.
     * @return A list of tickets this customer has purchased.
     */
    public ArrayList<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    /**
     * A getter method.
     * @return A list of items redeemed by this customer using his/her points.
     */
    public ArrayList<RewardsItem> getItemRedeemed() {
        return itemRedeemed;
    }

    /**
     * A getter method.
     * @return The customer associated with this purchase history.
     */
    public Customer getOwner() { return phCustomer; }

    /**
     * Add a new ticket to the list of purchasedTickets and return true.
     * @param ticket A ticket instance.
     * @return true if the ticket has been successfully added.
     */
    public boolean addPurchasedTickets (Ticket ticket) {
        purchasedTickets.add(ticket);
        return true;
    }

    /**
     * Add a new item to the list of itemRedeemed and return true.
     * @param item A RewardsItem instance that were redeemed by points from the U-store.
     * @return true if the item has been successfully added.
     */

    public boolean addItemRedeemed(RewardsItem item) {
        itemRedeemed.add(item);
        return true;
    }
}
