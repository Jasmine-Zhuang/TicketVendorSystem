import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UI {
    private static CustomerManager cm;
    private static  FlightManager fm;
    private static TicketManager tm;
    private static TicketReservationSystem trs = new TicketReservationSystem(cm,fm,tm);


    public static void main(String[] args) {
        fm = new FlightManager();
        //setup flights
        ArrayList<String> dTime = new ArrayList<>(5);
        dTime.add("2021");
        dTime.add("12");
        dTime.add("1");
        dTime.add("8");
        dTime.add("50");
        dTime.add("0");

        ArrayList<String> aTime = new ArrayList<>(5);
        aTime.add("2021");
        aTime.add("12");
        aTime.add("1");
        aTime.add("10");
        aTime.add("45");
        aTime.add("0");
        //initialize seatNumberArray
        ArrayList<String> seatNumArray = new ArrayList<String>();
        seatNumArray.add("1A");
        seatNumArray.add("1B");
        seatNumArray.add("2A");
        seatNumArray.add("2B");
        seatNumArray.add("3A");
        seatNumArray.add("3B");
        seatNumArray.add("4A");
        seatNumArray.add("4B");
        seatNumArray.add("5A");
        seatNumArray.add("5B");

        fm.AddFlight("TV1","Toronto","Vancouver",dTime,aTime,10,
                10,2000,"A1",seatNumArray);
        fm.AddFlight("VT1","Vancouver","Toronto",dTime,aTime,10,
                10,2000,"A1",seatNumArray);

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
        System.out.println("Login succeeds! \n Please type 1 to manage your account first(once finish, we will be " +
                "able to book ticket" +
                "  2 to exit");
       int option1 = scanner.nextInt();
       while(option1 !=1 && option1!=2){
           System.out.println("Sorry, your answer is invalid, please make sure you type either 1 or 2");
           option1 = scanner.nextInt();
       }
       if(option1==1){
           //print customer info:
           System.out.println("Do you want to load balance?\n Please enter 1 for Yes and 2 for No.");
           int option2=scanner.nextInt();
           while(option2 !=1 && option2!=2){
               System.out.println("Please make sure you enter 1 for Yes and 2 for No.");
               option2=scanner.nextInt();
           }
           if(option2 == 1){
               //load balance
               //print customer info


               //book ticket or exit?
               System.out.println("Would you like to 1. book tickets 2. exit? \n please enter 1 or 2.");
               int option3 = scanner.nextInt();
               while(option3 !=1 && option3!=2){
                   System.out.println("Please make sure you enter 1 or 2");
                   option3=scanner.nextInt();}
               if (option3 == 1){
                       //book ticket
                   //shows a list of departure and destination. (1.Vancouver-Toronto 2.Toronto-Vancouver)
                   System.out.println("Please select one of the available routes:\n 1.Vancouver-Toronto \n " +
                           "2.Toronto-Vancouver");
                   int route = scanner.nextInt();
                   while(route !=1 && route!=2){
                       System.out.println("Please make sure you enter 1 or 2");
                       route=scanner.nextInt();}

                   String dep;
                   String des;
                   if(route==1){
                       dep = "Vancouver";
                       des = "Toronto";
                   }
                   else{
                        dep = "Toronto";
                        des = "Vancouver";
                   }
                   //NullPointerexception  List<String> flightlst = trs.matchFlight(dep,des);//list of flight nums
                  // System.out.println(flightlst);+price of each price

                   for (String flightnum:flightlst){
                       System.out.println(trs.printFlightInfo(flightnum));
                   }
                   System.out.println("Do you have any preferred flight?\n please enter the flight number you want to " +
                           "book.");
                   String flightnum = scanner.nextLine();
                   while(!flightlst.contains(flightnum)){
                       System.out.println("Please make sure you enter a valid flight number");
                       flightnum=scanner.nextLine();}
                   //check if balance is sufficient to buy this ticket
                   Flight f =trs.selectFlight(flightnum);




                   //select seat
                   ArrayList<String> seatmap = trs.showAvailableSeatNums(flightnum);
                   System.out.println("Please select a seat from the following available seats shown below by its seat number.\n "+
                           seatmap);
                   String seat_num = scanner.nextLine();
                   while(!seatmap.contains(seat_num)){
                       System.out.println("Please make sure you enter a valid seat number.");
                       seat_num=scanner.nextLine();}
                   //reserve confirmation
                   System.out.println(trs.reserveSeat(seat_num,flightnum));

                   //generate ticket




                   }








                   }




               else{System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you next time.");
                   }


               }
        /*   else {
               //book ticket or exit?
               System.out.println("Would you like to 1. book tickets 2. exit? /n please enter 1 or 2.");


               while(option3 !=1 && option3!=2){
                   System.out.println("Please make sure you enter 1 or 2");
                   option3=scanner.nextInt();
               }
               if (option3 == 1){
                   //book ticket
               }
               else{
                   System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you next time.");
               }

           }*/
       }

     else{
         System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you next time.");
       }
}}



