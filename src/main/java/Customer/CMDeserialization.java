package Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class CMDeserialization {

    public CustomerManager restoreCM(String filePath){
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            CustomerManager cm = (CustomerManager) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Restored CM");
            long serialVersionUID = ObjectStreamClass.lookup(cm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);
            return cm;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
