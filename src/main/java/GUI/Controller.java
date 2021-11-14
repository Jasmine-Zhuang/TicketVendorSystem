package GUI;

import Customer.Customer;
import Customer.CustomerManager;
import Customer.PHManager;
import Flight.FlightManager;
import Ticket.TicketManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class Controller {

    public static CustomerManager PutUsersInCM(String path) throws IOException {
        CustomerManager CM = new CustomerManager();

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            CM.addCustomer(new Customer(data[0],data[1],data[2]));
        }
        return CM;
    }
/*    public static void restoreFM(FlightManager fm, String filePath){
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            fm = (FlightManager) in.readObject();
            System.out.println(fm.sortFlightsDistance());
            in.close();
            fileIn.close();
            System.out.println("Restored FM");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID: "+serialVersionUID);
    }*/

    public static void main(String[] args) {
        FlightManager fm = new FlightManager();
        TicketManager tm = new TicketManager();
        CustomerManager cm =  new CustomerManager();
        PHManager phm = new PHManager();
//        Customer customer = new Customer("amy","12","Amy");
//        cm.addCustomer(customer);
        try {
            cm = PutUsersInCM("users.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO:restore managers' state
        String filePath = "FlightManager.ser";
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            fm = (FlightManager) in.readObject();
            System.out.println(fm.sortFlightsDistance());
            in.close();
            fileIn.close();
            System.out.println("Restored FM");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID: "+serialVersionUID);

      /*  *//*restoreFM(fm,"FlightManager.ser");*//*
        long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID: "+serialVersionUID);*/


        /*this.restoreFM(fm,"FlightManager.ser");
        long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
        System.out.println("serialVersionUID: "+serialVersionUID);*/


/*
        ArrayList<String> dTime = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        ArrayList<String> aTime = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
        ArrayList<String> seatNumArray = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
        fm.AddFlight("CZ311", "Toronto", "Vancouver", dTime, aTime,10,
                10, 3600, "10A", seatNumArray);
        ArrayList<String> dTime1 = new ArrayList<>(Arrays.asList("2021","12","1","8","50","0"));
        ArrayList<String> aTime1 = new ArrayList<>(Arrays.asList("2021","12","1","10","45","0"));
        ArrayList<String> seatNumArray1 = new ArrayList<>(Arrays.asList("1A","1B","2A","2B","3A","3B","4A","4B","5A","5B"));
        fm.AddFlight("CZ312", "Montreal", "Vancouver", dTime1, aTime1,10,
                10, 3600, "10A", seatNumArray1);*/


        GUI gui = new GUI(fm,cm,tm,phm);
    }
}





