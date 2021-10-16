
/**
 * Represents a customer in the system.
 */
public class Customer {
    private String username;
    private String password;
    private String name;
    private int balance;
    private int millage;
    private boolean membership;

    /**
     * Create one Customer giving it the given username, password, name
     * @param username the username of this customer.
     * @param password the password of this customer.
     * @param name the name of this customer.
     */
    public Customer(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
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
     * The getter function of customer's balance.
     * @return return the balance
     */
    public int getBalance(){
        return this.balance;
    }

    /**
     * The getter function of customer's millage.
     * @return return the millage
     */
    public int getMillage(){
        return this.millage;
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
    public boolean changePassword(String original, String password){
        if(original.equals(this.password)){
            this.password = password;
            return true;
        } return false;
    }

    public void changeName(String newName){ this.name = newName;}

    public void changeUsername(String newUsername){ this.username = newUsername;}

    /**
     * Increase the balance of this customer
     * @param balance the balance to be increased
     */
    public void incrBalance(int balance){
        this.balance += balance;
    }

    /**
     * Decrease the balance of this customer
     * @param balance the balance to be decreased
     * @return return whether the balance decreased successfully or not
     */
    public boolean decrBalance(int balance){
        if (balance <= this.balance){
            this.balance -= balance;
            return true;
        }
        return false;
    }

    /**
     * Increase the millage of this customer
     * @param millage the millage to be increase
     */
    public void incrMillage(int millage){
        this.millage += millage;
    }


    /**
     * Check the current membership of this customer
     * @return return true if this customer has membership status
     */
    public boolean checkMembership(){return this.membership;}

    /**
     * Change the current membership of this customer
     */
    public void changeMembership(){
        if(!this.membership){
            this.membership = true;
        }
        }
}
