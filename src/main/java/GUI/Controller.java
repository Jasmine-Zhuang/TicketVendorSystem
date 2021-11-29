
package GUI;


import Customer.CustomerManager;
import Customer.CMDeserialization;
import Customer.PHManager;
import Customer.PHMDeserialiazation;
import Flight.FlightDeserialization;
import Flight.FlightManager;
import Ticket.TicketManager;
import Ticket.TicketDeserialization;

import java.util.ArrayList;
import java.util.Arrays;


public class Controller {

/*    public static CustomerManager PutUsersInCM(String path) throws IOException {
        CustomerManager CM = new CustomerManager();

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            CM.addCustomer(new Customer(data[0],data[1],data[2]));
        }
        return CM;
    }*/

    public static void main(String[] args) {
//        Customer c = new Customer("amy","12","Amy");
//        CustomerManager cm = new CustomerManager();
//        cm.addCustomer(c);
//        TicketManager tm=new TicketManager();
//        FlightManager fm=new FlightManager();
//        PHManager phm=new PHManager();
        TicketDeserialization ticketDeserialization =new TicketDeserialization();
        TicketManager tm = ticketDeserialization.restoreTM("TicketManager.ser");
        FlightDeserialization flightDeserialization = new FlightDeserialization();
        FlightManager fm = flightDeserialization.restoreFM("FlightManager.ser");
        CMDeserialization cmDeserialization=new CMDeserialization();
        CustomerManager cm =  cmDeserialization.restoreCM("CMManager.ser");
        PHMDeserialiazation phmDeserialiazation = new PHMDeserialiazation();
        PHManager phm = phmDeserialiazation.restorePHM("PHManager.ser");
/*
        try {
            cm = PutUsersInCM("users.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
*/



//        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
//        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
//        ArrayList<String> seatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
//        fm.AddFlight("CZ311", "Toronto", "Vancouver", dTime, aTime,10,
//                10, 3600, "10A", seatNumArray);
//        ArrayList<String> dTime1 = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
//        ArrayList<String> aTime1 = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
//        ArrayList<String> seatNumArray1 = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
//        fm.AddFlight("CZ312", "Montreal", "Vancouver", dTime1, aTime1,10,
//                10, 3600, "10A", seatNumArray1);

        GUI gui = new GUI(fm,cm,tm,phm);
    }
}




