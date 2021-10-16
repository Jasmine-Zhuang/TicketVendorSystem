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
        this.nameToCustomer.put(newCustomer.getName(), newCustomer);
    }

    /** A method named checkCustomer that takes a String (the name of the customer).
     *       If the name string does not appear as a key
     *       in nameToCustomer, then return there is no customer exsit.
     *       Return true if the name exsit in the nameToCustomer and return the customer information.
     * @param name The name of this customer needed to be checked if exit in nameToCustomer.
     */
    public boolean checkCustomer(String name)
    {
        return nameToCustomer.containsKey(name);
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