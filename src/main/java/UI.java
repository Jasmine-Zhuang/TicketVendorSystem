import java.util.ArrayList;
import java.util.Scanner;
public class UI {
    private static final CustomerManager cm = new CustomerManager();
    private static final FlightManager fm = new FlightManager();
    private static final TicketManager tm = new TicketManager();

    private static final TicketReservationSystem trs = new TicketReservationSystem(cm, fm, tm);
    public static void main(String[] args) {

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
        ArrayList<String> seatNumArray = new ArrayList<>();
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

        fm.AddFlight("TV1", "Toronto", "Vancouver", dTime, aTime, 10,
                10, 2000, "A1", seatNumArray);
        fm.AddFlight("VT1", "Vancouver", "Toronto", dTime, aTime, 10,
                10, 2000, "A1", seatNumArray);


        // beginning of CustomerManager Part
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to U-ticket! \n To start, you need to have an account. \n" +
                "Already have an account? \n Please enter 1. Yes 2. No");
        String option = scanner.nextLine();
        while (!option.equals("1") && !option.equals("2")) {
            System.out.println("Sorry, this option is invalid, please make sure you enter 1 or 2");
            System.out.println("Please enter 1 or 2");
            option = scanner.nextLine();
        }

        String username;
        if (option.equals("1")) {
            System.out.println("Please enter you username");
            username = scanner.nextLine();
            //verify if username exists
            while (!trs.checkCustomer(username)) {
                System.out.println("The username does not exist, please re-enter username or enter 1 to exit");
                username = scanner.nextLine();
                if (username.equals("1")){
                    System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you "
                            + "next time.");
                    return;
                }

            }
            //verify if password is correct.
            System.out.println("Please enter you password");
            String password = scanner.nextLine();

            while (!trs.checkPassword(username,password)){
                System.out.println("The password you entered was incorrect, please try again.");
                password = scanner.nextLine();
            }
        } else {
            //create an account
            System.out.println("To create an account, please enter you username");
            username = scanner.nextLine();
            // check if this username exists in customer manager system.
            while (trs.checkCustomer(username)) {
                System.out.println("Sorry, this username already exists, please re-enter a new username");
                username = scanner.nextLine();
            }
            System.out.println("Please enter you password");
            String password = scanner.nextLine();
            System.out.println("Please enter you full name");
            String customerName = scanner.nextLine();

            trs.addCustomer(username,password,customerName);
            //create an account with this info.
        }

        //Once login succeeds:
        System.out.println("Login succeeds! \n Please select 1.manage your account first (once finished, you will be "
                + "able to book ticket)  2.exit");
        int option1 = scanner.nextInt();
        while (option1 != 1 && option1 != 2) {
            System.out.println("Sorry, your option is invalid, please make sure to enter either 1 or 2");
            option1 = scanner.nextInt();
        }
        if (option1 == 1) {
            //print customer info:
            System.out.println(trs.showCustomerInfo(username));
            System.out.println("Would you like to load balance?\n Please enter 1.Yes 2.No");
            int option2 = scanner.nextInt();
            while (option2 != 1 && option2 != 2) {
                System.out.println("Please make sure you enter 1.Yes 2.No");
                option2 = scanner.nextInt();
            }
            if (option2 == 1) {
                //load balance
                System.out.println("How much do you want to load to your current balance?" +
                        "\n (Please enter an integer between 1 and 1000000)");
                int enter_balance = scanner.nextInt();
                while (!(1 <= enter_balance && enter_balance <= 1000000)){
                    System.out.println("Please enter an integer between 1 and 1000000");
                    enter_balance = scanner.nextInt();
                }
                trs.increaseBalance(enter_balance, username);
                //print customer info
                 System.out.println(trs.showCustomerInfo(username));

                //book ticket or exit?
                System.out.println("Would you like to 1. book tickets 2. exit? \n please enter 1 or 2.");
                int option3 = scanner.nextInt();
                while (option3 != 1 && option3 != 2) {
                    System.out.println("Please make sure you enter 1 or 2");
                    option3 = scanner.nextInt();
                }
                if (option3 == 1) {
                    //book ticket
                    //shows a list of departure and destination. (1.Vancouver-Toronto 2.Toronto-Vancouver)
                    System.out.println("Please select one of the available routes:\n 1.Vancouver-Toronto \n " +
                            "2.Toronto-Vancouver");
                    int route = scanner.nextInt();
                    while (route != 1 && route != 2) {
                        System.out.println("Please make sure you enter 1 or 2");
                        route = scanner.nextInt();
                    }

                    String dep;
                    String des;
                    if (route == 1) {
                        dep = "Vancouver";
                        des = "Toronto";
                    } else {
                        dep = "Toronto";
                        des = "Vancouver";
                    }

                    ArrayList<String> flight_lst = trs.matchFlight(dep,des);


                    for (String flight_num : flight_lst) {
                        System.out.println(trs.printFlightInfo(flight_num));
                    }
                    System.out.println("Please enter a preferred flight number you want to " +
                            "book.");
                    String flight_num = scanner.nextLine();
                    while (!flight_lst.contains(flight_num)) {
                        System.out.println("Please make sure you enter a valid flight number");
                        flight_num = scanner.nextLine();
                    }
                    //check if balance is sufficient to buy this ticket
                    Flight f = trs.selectFlight(flight_num);
                    int price = fm.getPriceByFlight(f);
                    if (!trs.decreaseBalance(price, username)){
                        System.out.println("Your balance is not enough, see you next time!" +
                                " Please remember to load some money!");
                        return;
                    }

                    //select seat
                    ArrayList<String> seat_map = trs.showAvailableSeatNums(flight_num);
                    System.out.println("Please select a seat from the following available seats shown below by its seat number.\n " +
                            seat_map);
                    String seat_num = scanner.nextLine();
                    while (!seat_map.contains(seat_num)) {
                        System.out.println("Please make sure you enter a valid seat number.");
                        seat_num = scanner.nextLine();
                    }

                    //reserve confirmation
                    System.out.println(trs.reserveSeat(seat_num, flight_num));

                    //generate ticket
                    Ticket ticket = trs.createTicket(username, seat_num, flight_num);
                    System.out.println(trs.book_ticket(ticket));

                }

            } else {
                System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you next time.");
            }


        } else {
            System.out.println("Thank you for using U-ticket. Hope you enjoy your experience using us! See you next time.");
        }
    }
}




