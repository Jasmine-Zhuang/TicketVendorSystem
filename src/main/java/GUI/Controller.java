

package GUI;


import Customer.*;
import Flight.FlightDeserialization;
import Flight.FlightManager;
import Luggage.LuggageDeserialization;
import Luggage.LuggageManager;
import Ticket.TicketManager;
import Ticket.TicketDeserialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.util.List;


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
    /*    CustomerManager cm = new CustomerManager();
        Customer c = new Customer("1","12","123");

        cm.addCustomer(c);
        c.incrBalance(6000);*/
     /*   TicketManager tm=new TicketManager();
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
        LuggageDeserialization lmDeserialiazation = new LuggageDeserialization();
        LuggageManager lm =lmDeserialiazation.restoreLM("LuggageManager.ser");

    /*    LuggageManager lm=new LuggageManager();
        TicketManager tm=new TicketManager();
        FlightManager fm=new FlightManager();
        PHManager phm=new PHManager();*/



//        try {
//            cm = cm.PutUsersInCM("users.csv");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



/*
//Generate Flights
        //Route1 Toronto-Vancouver
        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","11","8","50","0"));
        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","11","10","45","0"));
        fm.AddFlight("CZ311", "Toronto", "Vancouver", dTime, aTime,"Small",
                3600, "10A");

        ArrayList<String> dTime1 = new ArrayList<>(Arrays.asList("2021","12","12","8","50","0"));
        ArrayList<String> aTime1 = new ArrayList<>(Arrays.asList("2021","12","12","10","45","0"));
        fm.AddFlight("CZ312", "Toronto", "Vancouver", dTime1, aTime1, "Medium",
                3600, "10B");

        ArrayList<String> dTime2 = new ArrayList<>(Arrays.asList("2021","12","13","8","50","0"));
        ArrayList<String> aTime2 = new ArrayList<>(Arrays.asList("2021","12","13","10","45","0"));
        fm.AddFlight("CZ313", "Toronto", "Vancouver", dTime2, aTime2, "Large",
                3600, "10A");

        //Route2 Vancouver-Toronto
        ArrayList<String> dTime3 = new ArrayList<>(Arrays.asList("2021","12","14","8","50","0"));
        ArrayList<String> aTime3 = new ArrayList<>(Arrays.asList("2021","12","14","10","45","0"));
        fm.AddFlight("CZ315", "Vancouver","Toronto",  dTime3, aTime3,"Small",
                3600, "10A");

        ArrayList<String> dTime4 = new ArrayList<>(Arrays.asList("2021","12","15","8","50","0"));
        ArrayList<String> aTime4 = new ArrayList<>(Arrays.asList("2021","12","15","10","45","0"));
        fm.AddFlight("CZ316", "Vancouver","Toronto", dTime4, aTime4, "Medium",
                3600, "10B");

        ArrayList<String> dTime5 = new ArrayList<>(Arrays.asList("2021","12","16","8","50","0"));
        ArrayList<String> aTime5 = new ArrayList<>(Arrays.asList("2021","12","16","10","45","0"));
        fm.AddFlight("CZ317", "Vancouver", "Toronto", dTime5, aTime5, "Large",
                3600, "10A");

        //Route3 Toronto-Montreal

        ArrayList<String> dTime6 = new ArrayList<>(Arrays.asList("2021","12","30","8","50","0"));
        ArrayList<String> aTime6 = new ArrayList<>(Arrays.asList("2021","12","30","10","45","0"));
        fm.AddFlight("CZ318", "Toronto", "Montreal", dTime6, aTime6,"Small",
                540, "10A");

        ArrayList<String> dTime7 = new ArrayList<>(Arrays.asList("2021","12","12","8","50","0"));
        ArrayList<String> aTime7 = new ArrayList<>(Arrays.asList("2021","12","12","10","45","0"));
        fm.AddFlight("CZ319", "Toronto", "Montreal", dTime7, aTime7, "Medium",
                540, "10B");

        ArrayList<String> dTime8 = new ArrayList<>(Arrays.asList("2021","12","13","8","50","0"));
        ArrayList<String> aTime8 = new ArrayList<>(Arrays.asList("2021","12","13","10","45","0"));
        fm.AddFlight("CZ320", "Toronto", "Montreal", dTime8, aTime8, "Large",
                540, "10A");

        //Route 4 Montreal - Toronto
        ArrayList<String> dTime9 = new ArrayList<>(Arrays.asList("2021","12","14","8","50","0"));
        ArrayList<String> aTime9 = new ArrayList<>(Arrays.asList("2021","12","14","10","45","0"));
        fm.AddFlight("CZ321", "Montreal", "Toronto", dTime9, aTime9,"Small",
                540, "10A");

        ArrayList<String> dTime10 = new ArrayList<>(Arrays.asList("2021","12","15","8","50","0"));
        ArrayList<String> aTime10 = new ArrayList<>(Arrays.asList("2021","12","15","10","45","0"));
        fm.AddFlight("CZ322","Montreal", "Toronto",  dTime10, aTime10, "Medium",
                540, "10B");

        ArrayList<String> dTime11 = new ArrayList<>(Arrays.asList("2021","12","16","8","50","0"));
        ArrayList<String> aTime11 = new ArrayList<>(Arrays.asList("2021","12","16","10","45","0"));
        fm.AddFlight("CZ323", "Montreal" , "Toronto", dTime11, aTime11, "Large",
                540, "10C");

        //Route 5 Toronto-Ottawa
        ArrayList<String> dTime12 = new ArrayList<>(Arrays.asList("2021","12","12","8","50","0"));
        ArrayList<String> aTime12 = new ArrayList<>(Arrays.asList("2021","12","12","10","45","0"));
        fm.AddFlight("CZ324", "Toronto", "Ottawa", dTime12, aTime12,"Small",
                3600, "10A");

        ArrayList<String> dTime13 = new ArrayList<>(Arrays.asList("2021","12","13","8","50","0"));
        ArrayList<String> aTime13 = new ArrayList<>(Arrays.asList("2021","12","13","10","45","0"));
        fm.AddFlight("CZ325", "Toronto", "Ottawa", dTime13, aTime13, "Medium",
                3600, "10B");

        ArrayList<String> dTime14 = new ArrayList<>(Arrays.asList("2021","12","13","8","50","0"));
        ArrayList<String> aTime14 = new ArrayList<>(Arrays.asList("2021","12","13","10","45","0"));
        fm.AddFlight("CZ367", "Toronto", "Ottawa", dTime14, aTime14, "Large",
                3600, "10A");

        //Route 6 Ottawa - Toronto
        ArrayList<String> dTime15 = new ArrayList<>(Arrays.asList("2021","12","14","8","50","0"));
        ArrayList<String> aTime15 = new ArrayList<>(Arrays.asList("2021","12","14","10","45","0"));
        fm.AddFlight("CZ390", "Ottawa","Toronto",  dTime15, aTime15,"Small",
                3600, "10A");

        ArrayList<String> dTime16 = new ArrayList<>(Arrays.asList("2021","12","15","8","50","0"));
        ArrayList<String> aTime16 = new ArrayList<>(Arrays.asList("2021","12","15","10","45","0"));
        fm.AddFlight("CZ345", "Ottawa","Toronto", dTime16, aTime16, "Medium",
                3600, "10B");

        fm.AddFlight("CZ300", "Ottawa", "Toronto", dTime15, aTime15, "Large",
                3600, "10A");

        //Route 7 Vancouver-Ottawa
        ArrayList<String> dTime17 = new ArrayList<>(Arrays.asList("2021","12","30","8","50","0"));
        ArrayList<String> aTime17 = new ArrayList<>(Arrays.asList("2021","12","30","10","45","0"));
        fm.AddFlight("CZ318", "Vancouver", "Ottawa", dTime17, aTime17,"Small",
                4295, "10A");


        fm.AddFlight("CZ377", "Vancouver", "Ottawa", dTime17, aTime17, "Medium", 4295, "10B");

        fm.AddFlight("CZ388", "Vancouver", "Ottawa",  dTime17, aTime8, "Large",
                4295, "10A");

        //Route 8 Ottawa - Vancouver
        ArrayList<String> dTime18 = new ArrayList<>(Arrays.asList("2021","12","28","8","50","0"));
        ArrayList<String> aTime18 = new ArrayList<>(Arrays.asList("2021","12","28","10","45","0"));
        fm.AddFlight("CZ309", "Ottawa", "Vancouver", dTime18, aTime18,"Small",
                4295, "10A");


        fm.AddFlight("CZ322", "Ottawa", "Vancouver", dTime18, aTime18, "Medium", 4295, "10B");

        fm.AddFlight("CZ355","Ottawa", "Vancouver", dTime18, aTime18, "Large",
                4295, "10A");

        //Route 10 Montreal - Ottawa
        ArrayList<String> dTime19 = new ArrayList<>(Arrays.asList("2021","12","14","8","50","0"));
        ArrayList<String> aTime19 = new ArrayList<>(Arrays.asList("2021","12","14","10","45","0"));
        fm.AddFlight("CZ421", "Montreal", "Ottawa", dTime19, aTime19,"Small",
                199, "10A");

        fm.AddFlight("CZ422","Montreal", "Ottawa", dTime19, aTime19, "Medium",
                199, "10B");

        fm.AddFlight("CZ423", "Montreal" , "Ottawa", dTime19, aTime19, "Large",
                199, "10C");

        //Route 10 Ottawa - Montreal
        ArrayList<String> dTime20 = new ArrayList<>(Arrays.asList("2021","12","14","8","50","0"));
        ArrayList<String> aTime20 = new ArrayList<>(Arrays.asList("2021","12","14","10","45","0"));
        fm.AddFlight("CZ521", "Ottawa", "Montreal", dTime20, aTime20,"Small",
                199, "10A");

        fm.AddFlight("CZ522","Ottawa", "Montreal",  dTime20, aTime20, "Medium",
                199, "10B");

        fm.AddFlight("CZ523", "Ottawa", "Montreal" , dTime20, aTime20, "Large",
                199, "10C");


*/



        GUI gui = new GUI(fm,cm,tm,phm,lm);


    }
}




