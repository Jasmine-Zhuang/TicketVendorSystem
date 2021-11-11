/*
This class contains all error messages.
 */
public class Exceptions {

    // error messages associated with account sign-up and sign-in.

    public final static String INVALD_USERNAME = "Please enter a valid username.";
    public final static String USERNAME_ALREADY_EXISTS = "This username already exists. Please " +
            "enter a new one.";
    public final static String INVALID_LEGAL_NAME = "Please enter a valid name. A name can only" +
            "contain letters (A-Z) and (a-z).";
    public final static String INVALID_PASSWORD = "Please enter a valid password.";
    public final static String INVALID_LOGIN_INFO = "Invalid username or password. Please check your" +
            "username and try again.";
    public final static String ACCOUNT_NOT_FOUND = "Account is not found. Please create an " +
            "account.";

    // error messages associated with loading balance and payment.

    public final static String INVALID_AMOUNT = "Please enter a valid integer between 1 and 1000000.";
    public final static String INSUFFICIENT_BALANCE = "Insufficient balance. Please load first.";
    
    // error messages associated with point redemption.
    
    public final static String INSUFFICIENT_POINTS = "Insufficient points to redeem.";

    // error messages associated with selecting seats.

    public final static String SEAT_ALREADY_OCCUPIED = "The seat selected has been occupied. Please enter a seat number" +
            "that has not been selected yet.";
    public final static String INVALID_SEAT_NUM = "Please enter a valid seat number. Eg. 10A.";

    // error messages associated with selecting given options in UI.
    public final static String INVALID_OPTION = "Please enter a valid option.";


}

