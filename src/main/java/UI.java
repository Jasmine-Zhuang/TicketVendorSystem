import java.util.Objects;
import java.util.Scanner;
public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to U-ticket! \n To start, may I ask do you have an account? \n" +
                "Please enter Yes or No.");
        String option = scanner.nextLine();
        if(!option.equals("Yes") && !option.equals("No")){
            System.out.println("Sorry, your answer is invalid, please make sure you type either Yes or No");
            //process back?
        }
        else if(Objects.equals(option, "Yes")){
          System.out.println("Please enter you username");
          String username = scanner.nextLine();
          //verify if username exists
          System.out.println("Please enter you password");
          String password = scanner.nextLine();
          //verify if password is correct.
        }

       else if(Objects.equals(option, "No")){

    }}}



