
import java.util.*;

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
     */
    public boolean checkCustomer(String name)
    {
        return nameToCustomer.containsKey(name);

    }

    /** Modify this customer's name
     */
    public static void changename(String newName, Customer customer){
        customer.changeName(newName);}

    /** Modify this customer's password
     */
    public static String changepassword(String original, String newpassword, Customer A){
        if (A.changePassword(original,newpassword)){
        return "Success";}
        else{
            return "Failed";
        }
    }

    /** Modify this customer's username
     */
    public static void changeusername(String newusername, Customer A){
        A.changeUsername(newusername);}

    /** Modify this customer's current balance
     */
    public static void incrBalance(int balanceupdate, Customer A){
        A.incrBalance(balanceupdate);}

    /** Modify this customer's current millage
     */
    public static void updateMillage(int millageupdate, Customer A){
        A.incrMillage(millageupdate);}


}