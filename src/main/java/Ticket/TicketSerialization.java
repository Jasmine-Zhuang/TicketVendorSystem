package Ticket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class TicketSerialization {
    public void saveTM(TicketManager tm, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tm);
            out.close();
            fileOut.close();
            System.out.println("TM saved.");
            long serialVersionUID = ObjectStreamClass.lookup(tm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID); //id=1 here
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
}
