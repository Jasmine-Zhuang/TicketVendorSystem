package Luggage;

import Ticket.TicketManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;


public class LuggageDeserialization {

    public LuggageManager restoreLM(String filePath){
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LuggageManager lm = (LuggageManager) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Restored LM");
            long serialVersionUID = ObjectStreamClass.lookup(lm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);//id=?
            return lm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

