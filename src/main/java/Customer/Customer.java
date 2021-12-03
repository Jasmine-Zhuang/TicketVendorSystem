package Customer;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Represents a customer in the system.
 */
public class Customer implements Serializable {
    private String username;
    private String password;
    private String name;
    private int balance;
    private int mileage;
    private boolean membership;
    private int membership_level;
    private Integer redeem_points;
    private PurchaseHistory purchase_history;

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
        this.mileage = 0;
        this.membership = false;
        this.membership_level = 0;
        this.redeem_points = 0;
        this.purchase_history = null;
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
     * The getter function of customer's mileage.
     * @return return the mileage
     */
    public int getMileage(){
        return this.mileage;
    }

    /**
     * The getter function of customer's mileage.
     * @return return the mileage
     */
    public PurchaseHistory getPurchaseHistory(){
        return this.purchase_history;
    }

    /**
     * The getter function of customer's mileage.
     * @return return the mileage
     */
    public Integer getRedeem_points(){
        return this.redeem_points;
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
     * Assign the purchaseHistory to this customer
     * @param purchaseHistory the purchaseHistory for this customer.
     */
    public void setPurchaseHistory(PurchaseHistory purchaseHistory){
        this.purchase_history = purchaseHistory;
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
     * Increase the mileage of this customer
     * @param mileage the mileage to be increase
     */
    public void incrMileage(int mileage){
        this.mileage += mileage;
    }

    public void decrMileage(double redeem_points){
        if (this.membership){
            this.mileage -= redeem_points * 100;}
    }

    /**
     * Check the current membership of this customer
     * @return return true if this customer has membership status
     */
    public boolean checkMembership(){return this.membership;}

    /**
     * Check the current membership of this customer
     * @return return true if this customer has membership status
     */
    public int checkMembershiplevel(){return this.membership_level;}

    /**
     * Change the current membership of this customer
     */
    public void changeMembership(){
        if(!this.membership){
            this.membership = true;
            this.changeMembershiplevel();
        }
    }

    /**
     * Change the current membership of this customer
     */
    public void changeMembershiplevel(){
        if(this.membership){
            if ( this.mileage >=0 && this.mileage <= 1000 ) {
                this.membership_level = 1;
            }
            if (1000 <= this.mileage && this.mileage <= 5000) {
                this.membership_level = 2;
            }
            if (this.mileage > 5000) {
                this.membership_level = 3;
            }
        }
    }

    /**
     * Get Redeem Points for this customer
     */
    public Integer calculateRedeemPoint(){
        if(this.membership){
            this.redeem_points = ((Integer) this.mileage /(Integer) 5);
            return this.redeem_points;
        }
        return this.redeem_points;
    }

    /**
     * Get Redeem Points for this customer
     */
    public void minusRedeemPoint(Integer redeem_points){
        if(this.membership){
            this.redeem_points -= redeem_points;
        }
    }

    /**
     * Print the associated customer's information.
     */
    @Override
    public String toString(){
        return "Username: " + this.username +
                "\nName: " + this.name +
                "\nBalance: " + this.balance +
                "\nMileage: " + this.mileage +
                "\nMembership statues: " + this.membership+
                "\nMembership level: " + this.membership_level+
                "\nRedeemed points: " + this.redeem_points;
    }}