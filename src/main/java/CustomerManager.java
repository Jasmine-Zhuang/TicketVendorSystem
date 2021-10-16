/* This is the class that manages all registered customer information
 */
import java.util.*;

public class CustomerManager{
    private final HashMap<String, Customer> nameToCustomer = new LinkedHashMap<>();
    public CustomerManager(){
    }
    /**
     * Add a New Customer to the CustomerManager.
     * @param name the name of this customer.
     * @param password the password for this customer.
     * @param username the username of this customer.
     * @param balance the current balance of this customer.
     * @param millage the current millage of this customer.
     * @param membership the current membership status of this customer.
     */
    public void AddCustomer(String name, String password, String username,
                            int balance, int millage, boolean membership) {
        Customer newCustomer = new Customer(name, password, username, balance, millage, membership);
        this.idToFlight.put(name, newCustomer);
    }

    /* A method named checkCustomer that takes a String (the name of the customer).
     *       If the name string does not appear as a key
     *       in nameToCustomer, then return there is no customer exsit.
     *       Return true if the name exsit in the nameToCustomer and return the customer information.
     */
    public boolean checkCustomer(String name){
        if (nameToCustomer.get(name) == null) {
            return false;
        }
        else {
            // Key might be present...
            if (nameToCustomer.containsKey(name))
                return true;
            }

        }

    /* Modify this customer's name
     */
    public static void changename(String newname, Customer A){
        A.name = newname;}

    /* Modify this customer's password
     */
    public static void changepassword(String newpassword, Customer A){
        A.password = newpassword;}

    /* Modify this customer's username
     */
    public static void changeusername(String newusername, Customer A){
        A.username = newusername;}

    /* Modify this customer's current balance
     */
    public static void updatebalance(int balanceupdata, Customer A){
        A.balance += balanceupdata;}

    /* Modify this customer's current millage
     */
    public static void updatemillage(int millageupdata, Customer A){
        A.millage += millageupdata;}

    /* Modify this customer's current membership status
     */
    public static void updatemembership(Customer A){
        if (A.membership == false)
            A.membership = true;}

}