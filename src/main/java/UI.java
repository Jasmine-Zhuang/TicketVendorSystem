import java.util.Scanner;
public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to U-ticket! \n To start, may I ask do you have an account? \n" +
                "Please enter Yes or No.");
        String option = scanner.nextLine();
        while(!option.equals("Yes") && !option.equals("No")){
            System.out.println("Sorry, your answer is invalid, please make sure you type either Yes or No");
            System.out.println( "Please enter Yes or No.");
            option = scanner.nextLine();
        }
        if(option.equals("Yes")){
          System.out.println("Please enter you username");
          String username = scanner.nextLine();
          //verify if username exists
          System.out.println("Please enter you password");
          String password = scanner.nextLine();
          //verify if password is correct.
        }
       else {
           //create an account
           System.out.println("Now let's register to continue. \n Please enter you username");
            String username = scanner.nextLine();
            // if this id exists.... can use a while loop for this
           // System.out.println("This id has been used. Please type another one.");

            System.out.println("Please enter you password");
            String password = scanner.nextLine();
            //create an account with this info.
    }
       //Once login succeeds:
        System.out.println("Login succeeds! \n Please type 1 to manage your account, 2 to book ticket  3 to exit");
       int option1 = scanner.nextInt();
       while(option1 !=1 && option1!=2 && option1!=3){
           System.out.println("Sorry, your answer is invalid, please make sure you type either 1, 2 or 3");
           option1 = scanner.nextInt();
       }
       if(option1==1){}
       else if(option1==2){}
       else{}
}}



