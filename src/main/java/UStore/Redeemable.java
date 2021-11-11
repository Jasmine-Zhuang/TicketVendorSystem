package UStore;

import Customer.Customer;
import Customer.PurchaseHistory;

public interface Redeemable {
    String redeemItem(int points, Customer customer);
}
