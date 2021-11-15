package Flight;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class FlightDeserialization {
    public FlightManager restoreFM(String filePath){
        try {

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            FlightManager fm = (FlightManager) in.readObject();
            System.out.println(fm.sortFlightsDistance());
            in.close();
            fileIn.close();
            System.out.println("Restored FM");
            long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);
            return fm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
