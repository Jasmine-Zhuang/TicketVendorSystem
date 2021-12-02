

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
/*       Customer c = new Customer("amy","12","Amy");
        CustomerManager cm = new CustomerManager();
        cm.addCustomer(c);
        TicketManager tm=new TicketManager();
        FlightManager fm=new FlightManager();
        PHManager phm=new PHManager();*/
        TicketDeserialization ticketDeserialization =new TicketDeserialization();
        TicketManager tm = ticketDeserialization.restoreTM("TicketManager.ser");
        FlightDeserialization flightDeserialization = new FlightDeserialization();
        FlightManager fm = flightDeserialization.restoreFM("FlightManager.ser");
        CMDeserialization cmDeserialization=new CMDeserialization();
        CustomerManager cm =  cmDeserialization.restoreCM("CMManager.ser");
        PHMDeserialiazation phmDeserialiazation = new PHMDeserialiazation();
        PHManager phm = phmDeserialiazation.restorePHM("PHManager.ser");

        try {
            cm = cm.PutUsersInCM("users.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        GUI gui = new GUI(fm,cm,tm,phm,lm);

        //Generate Flights
        //Route1 Toronto-Vancouver
        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
        fm.AddFlight("CZ311", "Toronto", "Vancouver", dTime, aTime,"Small",
                3600, "10A");

        ArrayList<String> dTime1 = new ArrayList<>(Arrays.asList("2021","12","2","8","50","0"));
        ArrayList<String> aTime1 = new ArrayList<>(Arrays.asList("2021","12","2","10","45","0"));
        fm.AddFlight("CZ312", "Toronto", "Vancouver", dTime1, aTime1, "Medium",
                3600, "10B");

        ArrayList<String> dTime2 = new ArrayList<>(Arrays.asList("2021","12","3","8","50","0"));
        ArrayList<String> aTime2 = new ArrayList<>(Arrays.asList("2021","12","3","10","45","0"));
        fm.AddFlight("CZ313", "Toronto", "Vancouver", dTime2, aTime2, "Large",
                3600, "10A");

        //Route2 Vancouver-Toronto
        ArrayList<String> dTime3 = new ArrayList<>(Arrays.asList("2021","12","4","8","50","0"));
        ArrayList<String> aTime3 = new ArrayList<>(Arrays.asList("2021","12","4","10","45","0"));
        fm.AddFlight("CZ315", "Vancouver","Toronto",  dTime3, aTime3,"Small",
                3600, "10A");

        ArrayList<String> dTime4 = new ArrayList<>(Arrays.asList("2021","12","5","8","50","0"));
        ArrayList<String> aTime4 = new ArrayList<>(Arrays.asList("2021","12","5","10","45","0"));
        fm.AddFlight("CZ316", "Vancouver","Toronto", dTime4, aTime4, "Medium",
                3600, "10B");

        ArrayList<String> dTime5 = new ArrayList<>(Arrays.asList("2021","12","6","8","50","0"));
        ArrayList<String> aTime5 = new ArrayList<>(Arrays.asList("2021","12","6","10","45","0"));
        fm.AddFlight("CZ317", "Vancouver", "Toronto", dTime5, aTime5, "Large",
                3600, "10A");

        //Route3 Toronto-Montreal

        ArrayList<String> dTime6 = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        ArrayList<String> aTime6 = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
        fm.AddFlight("CZ318", "Toronto", "Montreal", dTime6, aTime6,"Small",
                540, "10A");

        ArrayList<String> dTime7 = new ArrayList<>(Arrays.asList("2021","12","2","8","50","0"));
        ArrayList<String> aTime7 = new ArrayList<>(Arrays.asList("2021","12","2","10","45","0"));
        fm.AddFlight("CZ319", "Toronto", "Montreal", dTime7, aTime7, "Medium",
                540, "10B");

        ArrayList<String> dTime8 = new ArrayList<>(Arrays.asList("2021","12","3","8","50","0"));
        ArrayList<String> aTime8 = new ArrayList<>(Arrays.asList("2021","12","3","10","45","0"));
        fm.AddFlight("CZ320", "Toronto", "Montreal", dTime8, aTime8, "Large",
                540, "10A");

        //Route 4 Montreal - Toronto
        ArrayList<String> dTime9 = new ArrayList<>(Arrays.asList("2021","12","4","8","50","0"));
        ArrayList<String> aTime9 = new ArrayList<>(Arrays.asList("2021","12","4","10","45","0"));
        fm.AddFlight("CZ321", "Montreal", "Toronto", dTime9, aTime9,"Small",
                540, "10A");

        ArrayList<String> dTime10 = new ArrayList<>(Arrays.asList("2021","12","5","8","50","0"));
        ArrayList<String> aTime10 = new ArrayList<>(Arrays.asList("2021","12","5","10","45","0"));
        fm.AddFlight("CZ322","Montreal", "Toronto",  dTime10, aTime10, "Medium",
                540, "10B");

        ArrayList<String> dTime11 = new ArrayList<>(Arrays.asList("2021","12","6","8","50","0"));
        ArrayList<String> aTime11 = new ArrayList<>(Arrays.asList("2021","12","6","10","45","0"));
        fm.AddFlight("CZ323", "Montreal" , "Toronto", dTime11, aTime11, "Large",
                540, "10C");

        //Route 5 Toronto-Ottawa
        fm.AddFlight("CZ324", "Toronto", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","7","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","7","10","45","0"),"Small", 450, "10A");

        fm.AddFlight("CZ325", "Toronto", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","8","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","8","10","45","0"),"Medium", 450, "10A");

        fm.AddFlight("CZ326", "Toronto", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Large", 450, "10A");

        //Route 6 Ottawa - Toronto
        fm.AddFlight("CZ327", "Toronto", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Small", 450, "10A");

        fm.AddFlight("CZ328","Ottawa", "Toronto",
                (ArrayList<String>) Arrays.asList("2021","12","10","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","10","10","45","0"),"Medium", 450, "10A");

        fm.AddFlight("CZ329", "Ottawa","Toronto",
                (ArrayList<String>) Arrays.asList("2021","12","11","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","11","10","45","0"),"Large", 450, "10A");


        //Route 7 Vancouver-Ottawa
        fm.AddFlight("CZ330", "Vancouver", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","7","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","7","10","45","0"),"Small", 4363, "10A");

        fm.AddFlight("CZ331", "Vancouver", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","8","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","8","10","45","0"),"Medium", 4363, "10A");

        fm.AddFlight("CZ332", "Vancouver", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Large", 4363, "10A");

        //Route 8 Ottawa - Vancouver
        fm.AddFlight("CZ333", "Ottawa","Vancouver",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Small", 4363, "10F");

        fm.AddFlight("CZ334","Ottawa", "Vancouver",
                (ArrayList<String>) Arrays.asList("2021","12","10","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","10","10","45","0"),"Medium", 4363, "10G");

        fm.AddFlight("CZ335", "Ottawa", "Vancouver",
                (ArrayList<String>) Arrays.asList("2021","12","11","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","11","10","45","0"),"Large", 4363, "10C");

        //Route 9 Montreal-Ottawa
        fm.AddFlight("CZ336", "Montreal", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","7","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","7","10","45","0"),"Small", 199, "10A");

        fm.AddFlight("CZ337", "Montreal", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","8","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","8","10","45","0"),"Medium", 199, "10A");

        fm.AddFlight("CZ338", "Montreal", "Ottawa",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Large", 199, "10A");

        //Route 10 Ottawa - Montreal
        fm.AddFlight("CZ339", "Ottawa","Montreal",
                (ArrayList<String>) Arrays.asList("2021","12","9","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","9","10","45","0"),"Small", 199, "10W");

        fm.AddFlight("CZ340","Ottawa", "Montreal",
                (ArrayList<String>) Arrays.asList("2021","12","10","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","10","10","45","0"),"Medium", 199, "10L");

        fm.AddFlight("CZ341", "Ottawa", "Montreal",
                (ArrayList<String>) Arrays.asList("2021","12","11","8","50","0"),
                (ArrayList<String>)Arrays.asList("2021","12","11","10","45","0"),"Large", 199, "10P");

    }
}




