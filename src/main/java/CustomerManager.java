import java.util.HashMap;
import java.util.LinkedHashMap;

public class CustomerManager{
    private final HashMap<String, Customer> nameToCustomer = new LinkedHashMap<>();
    public CustomerManager(){
    }
    /**
     * Add a New Customer to the CustomerManager.
     * @param newCustomer This customer needed to add to this nameToCustomer.
     */
    public void addCustomer(Customer newCustomer) {
        this.nameToCustomer.put(newCustomer.getUsername(), newCustomer);
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


    /** A method named showCustomer that takes a String (the name of the customer).
     *       Return Customer with corresponding name.
     * @param username The name of this customer needed to be checked if exit in nameToCustomer.
     * @return Customer The corresponding customer with this customer's name.
     */
    public Customer showCustomer(String username) {
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
        return nameToCustomer.get(username).getBalance();
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

    /** Modify this customer's current millage
     * @param customer The customer needed to change name.
     * @param millage_update The new millage of this customer to be added to this customer's current millage.
     */
    public void updateMillage(int millage_update, Customer customer){
        customer.incrMillage(millage_update);}

    /** Change this customer's current membership status
     * @param customer The customer needed to change name.
     */
    public void checkMembership(Customer customer){
        if(!customer.checkMembership()){
            customer.changeMembership();
        }
    }
}