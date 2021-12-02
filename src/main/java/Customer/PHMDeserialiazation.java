package Customer;

import Flight.FlightManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class PHMDeserialiazation {
    public PHManager restorePHM(String filePath){
        try {

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            PHManager phm = (PHManager) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Restored PHM");
            long serialVersionUID = ObjectStreamClass.lookup(phm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);
            return phm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
