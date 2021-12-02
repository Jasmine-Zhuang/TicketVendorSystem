package Customer;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class CustomerManager implements Serializable {

    Membership AllMember = new Membership();
    private static final long serialVersionUID = 3;
    private final HashMap<String, Customer> nameToCustomer = new LinkedHashMap<>();
    public CustomerManager(){
    }

    /**
     * Add a New Customer to the CustomerManager.
     * @param newCustomer This customer needed to add to this nameToCustomer.
     */
    public void addCustomer(Customer newCustomer) {
        this.nameToCustomer.put(newCustomer.getUsername(), newCustomer);
        if (newCustomer.checkMembership()){
            AllMember.addCustomer(newCustomer);
        }
    }

    /** A method named checkCustomer that takes a String (the name of the customer).
     *  Return true if username exists in the nameToCustomer, return false otherwise.
     * @param name The name of this customer needed to be checked if exit in nameToCustomer.
     */
    public boolean checkCustomername(String name) {
        for(Customer customer : nameToCustomer.values()) {
            if (Objects.equals(customer.getName(), name)){
                return true;
            }
        }
        return false;
    }


    /** A method named checkCustomer that takes a String (the name of the customer).
     *  Return true if username exists in the nameToCustomer, return false otherwise.
     * @param username The name of this customer needed to be checked if exit in nameToCustomer.
     */
    public boolean checkCustomer(String username) {
        return nameToCustomer.containsKey(username);
    }

    /** A method named checkPassword that takes a String username (the username of the customer).
     *  And another String password (the password of the customer).
     *  If the given password does not match the correct, return false.
     * @param username The username of this customer needed to be checked if exit in nameToCustomer.
     * @param password The password of this customer needed to be checked if exit in nameToCustomer.
     */
    public boolean checkPassword(String username, String password){
        return this.nameToCustomer.get(username).checkPassword(password);
    }

    /** A method named showCustomer that takes a String (the username of the customer).
     *       Return Customer with corresponding username.
     * @param username The username of this customer needed to be checked if exit in nameToCustomer.
     * @return Customer The corresponding customer with this customer's username.
     */
    public Customer showCustomer(String username) {
        if (AllMember.checkCustomer(username)){
            return AllMember.showCustomer(username);
        }
        return nameToCustomer.get(username);
    }

    /** A method named showCustomer that takes a String (the name of the customer).
     *       If the name string does not appear as a key
     *       in nameToCustomer, then return there is no customer exsit.
     *       Return true if the name exsit in the nameToCustomer and return the customer information.
     * @param username The name of this customer needed to be checked if exit in nameToCustomer.
     * @return int The corresponding customer's balance with this customer's name.
     */
    public int showCustomerBalance(String username)
    {
        if (AllMember.checkCustomer(username)){
            AllMember.showCustomerBalance(username);
        }
        return nameToCustomer.get(username).getBalance();
    }

    /** A method named showCustomer that takes a String (the name of the customer).
     *       If the name string does not appear as a key
     *       in nameToCustomer, then return there is no customer exsit.
     *       Return true if the name exsit in the nameToCustomer and return the customer information.
     * @param customer The customer of this customer needed to be checked if exit in nameToCustomer.
     * @return int The corresponding customer's balance with this customer's name.
     */
    public PurchaseHistory getPurchaseHistory(Customer customer)
    {
        return customer.getPurchaseHistory();
    }

    /** Modify this customer's current name.
     * @param customer The customer needed to change name.
     * @param new_name The new name of this customer needed to be changed.
     */
    public void changeName(String new_name, Customer customer){
        customer.changeName(new_name);}

    /** Modify this customer's current password.
     * @param customer The customer needed to change name.
     * @param original The original password of this customer needed to be changed.
     * @param new_password The new password of this customer.
     * @return return the associated string related to the password changed or not. Return "Success" if the password
     * has changed, and "Failed" if the password did not change successfully.
     */
    public String changePassword(String original, String new_password, Customer customer){
        if (customer.changePassword(original,new_password)){
            return "Success";}
        else{
            return "Failed";
        }
    }

    /** Modify this customer's username.
     * @param customer The customer needed to change name.
     * @param new_username The new username of this customer.
     */
    public void changeUsername(String new_username, Customer customer){
        Customer new_data = this.nameToCustomer.get(customer.getUsername());
        this.nameToCustomer.put(new_username,new_data);
        this.nameToCustomer.remove(customer.getUsername());
        customer.changeUsername(new_username);}

    /** Modify this customer's current balance.
     * @param customer The customer needed to change name.
     * @param balance_update The new balance of this customer to be added to this customer's current balance.
     */
    public void incrBalance(int balance_update, Customer customer){
        customer.incrBalance(balance_update);}

    /** Modify this customer's current balance.
     * @param customer The customer needed to change name.
     * @param balance_update The new balance of this customer to be added to this customer's current balance.
     */
    public boolean decrBalance(int balance_update, Customer customer){
        return customer.decrBalance(balance_update);}

    /** Modify this customer's current balance.
     * @param customer The customer needed to change name.
     * @param ticket_price The new balance of this customer to be added to this customer's current balance.
     */
    public void incrMemberBalance(int ticket_price, Customer customer){
        if (AllMember.checkCustomer(customer.getUsername())){
            AllMember.incrMemberBalance(ticket_price,customer);}}

    /** Modify this customer's current balance.
     * @param customer The customer needed to change name.
     * @param ticket_price The new balance of this customer to be added to this customer's current balance.
     */
    public void decrMemberBalance(int ticket_price, Customer customer){
        if (AllMember.checkCustomer(customer.getUsername())){
            AllMember.decrMemberBalance(ticket_price,customer);}}


    /** Modify this customer's current mileage
     * @param customer The customer needed to Modify current mileage.
     * @param mileage_update The new mileage of this customer to be added to this customer's current mileage.
     */
    public void incrMileage(int mileage_update, Customer customer){
        if (AllMember.checkCustomer(customer.getUsername())){
            customer.incrMileage(mileage_update);}
        customer.incrMileage(mileage_update);
    }


    /** Check this customer's current membership status
     * @param customer The customer needed to Check current membership status.
     */
    public boolean checkMembership(Customer customer){
        return AllMember.checkMembership(customer);
    }

    /**
     * Change the current membership of this customer
     */
    public void changeMembership(Customer customer){
        if(!AllMember.checkMembership(customer)){
            AllMember.changeMembership(customer);
        }

    }


    /**
     * Change the current membership of this customer
     */
    public void changeMembershiplevel(Customer customer){
        if(AllMember.checkMembership(customer)){
            AllMember.changeMembershiplevel(customer);
        }

    }

    /** Check this customer's current membership status
     * @param customer The customer needed to Check current membership status.
     */
    public int checkMembershiplevel(Customer customer){
        return AllMember.checkMembershiplevel(customer);
    }

    /**
     * Get Reedem Points for this customer
     */

    public Integer getRedeem_points(Customer customer){
        if(AllMember.checkCustomer(customer.getUsername())){
            return AllMember.getRedeem_points(customer);
        }
        else{
            return AllMember.getRedeem_points(customer);}
    }


    /**
     * Get Reedem Points for this customer
     */

    public Integer calculateRedeemPoint(Customer customer){
        if(AllMember.checkCustomer(customer.getUsername())){
            return AllMember.calculateRedeemPoint(customer);
        }
        else{
            return AllMember.calculateRedeemPoint(customer);}
    }

    /**
     * Get Reedem Points for this customer
     */

    public void minusRedeemPoint(Customer customer, Integer redeem_points){
        if(AllMember.checkCustomer(customer.getUsername())){
            AllMember.minusRedeemPoint(customer, redeem_points);
        }
    }

    /**
     * Get Redeem mileage for this customer
     */

    public void decrMileage(Customer customer, double redeem_points){
        if(AllMember.checkCustomer(customer.getUsername())){
            AllMember.decrMileage(customer, redeem_points);
        }
    }

    /** Return this customer's current information
     * @param customer The customer.
     */
    public String displayInfo(Customer customer){
        if (this.nameToCustomer.containsKey(customer.getUsername())) {
            return this.nameToCustomer.get(customer.getUsername()).toString();
        }
        return "This customer is not in system.";
    }

    public CustomerManager PutUsersInCM(String path) throws IOException {
        CustomerManager CM = new CustomerManager();

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            CMSerialization cmSerialization = new CMSerialization();
            CM.addCustomer(new Customer(data[0],data[1],data[2]));
            cmSerialization.saveCM(CM, "CMManager.ser");

        }
        return CM;
    }

}