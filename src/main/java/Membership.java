import java.util.HashMap;
import java.util.LinkedHashMap;

public class Membership {
    private final HashMap<String, Customer> MembershipCustomer = new LinkedHashMap<>();

    public Membership() {
    }

    /**
     * Check this customer's current membership status
     *
     * @param customer The customer needed to Check current membership status.
     */
    public boolean checkMembership(Customer customer) {
        if (customer.checkMembership()){
            if (this.MembershipCustomer.containsKey(customer.getUsername())) {
                return customer.checkMembership();}
            else{
            this.MembershipCustomer.put(customer.getUsername(), customer);
            return customer.checkMembership();}
        }
        return customer.checkMembership();
    }
    /**
     * Check this customer's current membership status
     *
     * @param customer The customer needed to Check current membership status.
     */
    public int checkMembershiplevel(Customer customer) {
        if (customer.checkMembership()){
            if (this.MembershipCustomer.containsKey(customer.getUsername())) {
                return customer.checkMembershiplevel();}
            else{
                this.MembershipCustomer.put(customer.getUsername(), customer);
                return customer.checkMembershiplevel();}
        }
        return customer.checkMembershiplevel();
    }

    /**
     * Change the current membership of this customer
     */
    public void changeMembership(Customer customer) {
        if (!customer.checkMembership()) {
            customer.changeMembership();
            this.MembershipCustomer.put(customer.getUsername(), customer);
        }
    }

    /**
     * Change the current membership of this customer
     */
    public void changeMembershiplevel(Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            customer.changeMembershiplevel();
        }
    }

    /**
     * Add a New Customer to the CustomerManager.
     *
     * @param newCustomer This customer needed to add to this nameToCustomer.
     */
    public void addCustomer(Customer newCustomer) {
        if (newCustomer.checkMembership()) {
            this.MembershipCustomer.put(newCustomer.getUsername(), newCustomer);
        }
    }

    /**
     * A method named checkCustomer that takes a String (the name of the customer).
     * Return true if username exists in the nameToCustomer, return false otherwise.
     *
     * @param username This customer username needed to check.
     */
    public boolean checkCustomer(String username) {
        return MembershipCustomer.containsKey(username);
    }

    /**
     * A method named showCustomer that takes a String (the name of the customer).
     * Return Customer with corresponding name.
     *
     * @param username This customer username needed to add to this nameToCustomer.
     * @return Customer The corresponding customer with this customer's username.
     */
    public Customer showCustomer(String username) {
        if (this.MembershipCustomer.containsKey(username)) {
            return MembershipCustomer.get(username);
        } else {
            return null;
        }
    }

    /**
     * A method named showCustomer that takes a String (the name of the customer).
     * If the name string does not appear as a key
     * in nameToCustomer, then return there is no customer exsit.
     * Return true if the name exsit in the nameToCustomer and return the customer information.
     *
     * @param username This customer username needed to add to this nameToCustomer.
     * @return int The corresponding customer's balance with this customer's name.
     */
    public Integer showCustomerBalance(String username) {
        if (this.MembershipCustomer.containsKey(username)) {
            return MembershipCustomer.get(username).getBalance();
        }
        return null;
    }

    /**
     * Modify this customer's current balance.
     *
     * @param customer       The customer needed to change name.
     * @param ticket_price The new ticket_price of this customer to be added to this customer's current balance.
     */
    public void incrMemberBalance(int ticket_price, Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.getBalance() <= 1000) {
                customer.incrBalance((int) (ticket_price * (1-0.05)));
            }
            if (customer.getBalance() <= 5000) {
                customer.incrBalance((int) (ticket_price * (1-0.1)));
            }
            if (customer.getBalance() > 5000) {
                customer.incrBalance((int) (ticket_price * (1-0.2)));
            }}}

    /**
     * Modify this customer's current balance.
     *
     * @param customer     The customer needed to change name.
     * @param ticket_price The new balance of this customer to be added to this customer's current balance.
     */
    public boolean decrMemberBalance(int ticket_price, Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.getBalance() <= 1000) {
                return customer.decrBalance((int) (ticket_price * (1-0.05)));
            }
            if (customer.getBalance() <= 5000) {
                return customer.decrBalance((int) (ticket_price * (1-0.1)));
            }
            if (customer.getBalance() > 5000) {
                return customer.decrBalance((int) (ticket_price * (1-0.2)));
            }
        }
        return false;
    }

    /**
     * Modify this customer's current millage
     *
     * @param customer       The customer needed to Modify current millage.
     * @param millage_update The new millage of this customer to be added to this customer's current millage.
     */
    public void incrMillage(int millage_update, Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            customer.incrMillage(millage_update);
        }
    }

    /**
     * Get Reedem Points for this customer
     */

    public void decrMillage(Customer customer, double redeem_points) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.checkMembership()) {
                customer.decrMillage(redeem_points);
            }
        }
    }

    /**
     * Calculate Reedem Points for this customer
     */

    public Integer calculateRedeemPoint(Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.checkMembership()) {
                return customer.calculateRedeemPoint();
            }
        }
        return customer.calculateRedeemPoint();
    }

    /**
     * Get Reedem Points for this customer
     */

    public Integer getRedeem_points(Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.checkMembership()) {
                Integer result = customer.getRedeem_points();
                return customer.getRedeem_points();
            }
        }
        return customer.getRedeem_points();
    }

    /**
     * Get Redeem Points for this customer
     */
    public void minusRedeemPoint(Customer customer, Integer redeem_points){
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            if (customer.checkMembership()) {
                customer.calculateRedeemPoint();
                customer.minusRedeemPoint(redeem_points);
            }
        }}

    /**
     * Return this customer's current information
     *
     * @param customer The customer.
     */
    public String displayInfo(Customer customer) {
        if (this.MembershipCustomer.containsKey(customer.getUsername())) {
            return this.MembershipCustomer.get(customer.getUsername()).toString();
        }
        return "This customer is not in system.";
    }
}