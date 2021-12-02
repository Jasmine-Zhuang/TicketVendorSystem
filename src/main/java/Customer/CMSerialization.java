package Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class CMSerialization {
    public void saveCM(CustomerManager cm, String filePath){
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject((CustomerManager)cm);
            out.close();
            fileOut.close();
            System.out.println("CM saved!");
            long serialVersionUID = ObjectStreamClass.lookup(cm.getClass()).getSerialVersionUID();
            System.out.println("serialVersionUID: "+serialVersionUID);//id=3 here
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
