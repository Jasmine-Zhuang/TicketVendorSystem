
/**
 * Represents a customer in the system.
 */
public class Customer {
    private String name;
    private String password;
    private String username;
    private int balance;
    private int millage;
    private boolean membership;



    public Customer(String username, String password){
        this.username = username;
        this.password = password;
        this.name = null;
        this.balance = 0;
        this.millage = 0;
        this.membership = false;
    }

    /**
     * The getter function of customer's real name.
     * @return return the name
     */
    public String getName(){
        return this.name;
    }


    /**
     * The getter function of customer's username.
     * @return return the username
     */
    public String getUsername(){
        return this.username;
    }


    /**
     * Return whether the password parameter matches this user's password.
     * @param password the password guess
     * @return whether the guess matches the real password.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


    /**
     * Change the password of this customer.
     * @param original the original password (needs to be checked)
     * @param password the new password
     * @return return whether the change succeeded or not
     */
    public boolean ChangePassword(String original, String password){
        if(original.equals(this.password)){
            this.password = password;
            return true;
        } return false;
    }

    /**
     * Increase the balance of this customer
     * @param balance the balance to be increased
     */
    public void incrBalance(int balance){
        this.balance += balance;
    }

    /**
     * Decrease the balance of this customer
     * @param balance the balance to be decrease
     */
    public void decrBalance(int balance){
        this.balance += balance;
    }
}
