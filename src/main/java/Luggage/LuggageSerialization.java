package Luggage;
import Flight.FlightManager;
import Ticket.TicketManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class LuggageSerialization {
    public void saveLM(LuggageManager lm, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(lm);
            out.close();
            fileOut.close();
            System.out.println("LM saved.");
            long serialVersionUID = ObjectStreamClass.lookup(lm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID); //id=?
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
}
