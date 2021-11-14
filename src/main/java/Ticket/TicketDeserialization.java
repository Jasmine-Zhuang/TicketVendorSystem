package Ticket;

import Flight.FlightManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class TicketDeserialization {
    public TicketManager restoreTM(String filePath){
        try {

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            TicketManager tm = (TicketManager) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Restored TM");
            long serialVersionUID = ObjectStreamClass.lookup(tm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);//id=1 here
            return tm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
