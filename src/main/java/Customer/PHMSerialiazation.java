package Customer;

import Ticket.TicketManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class PHMSerialiazation {
    public void savePHM(PHManager phm, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(phm);
            out.close();
            fileOut.close();
            System.out.println("PHM saved.");
            long serialVersionUID = ObjectStreamClass.lookup(phm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID); //id=1 here
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
}
