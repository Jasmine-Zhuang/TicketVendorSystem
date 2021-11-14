package Flight;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class FlightSerialization {

    public void saveFM(FlightManager fm,String filePath){
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject((FlightManager)fm);
            out.close();
            fileOut.close();
            System.out.println("FM saved!");
            long serialVersionUID = ObjectStreamClass.lookup(fm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);//id=2 here
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
