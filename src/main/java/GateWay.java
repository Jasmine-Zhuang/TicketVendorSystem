package gateWay;

import java.io.*;
import java.util.Objects;

public class GateWay<T> {
    protected String filePath;

    public GateWay(String type) {
        if (type.equals("flight")) {
            filePath = "data/flightData.ser";
        } else if (type.equals("customer")) {
            filePath = "data/flightData.ser";
        } else if (type.equals("ticket")) {
            filePath = "data/ticketData.ser";
        }

        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean write(T obj) {
        File file = new File(this.filePath);
        try {
            if (file.createNewFile() || file.delete()) {
                FileOutputStream fileOut = new FileOutputStream(filePath);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(obj);
                objectOut.close();
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public T read() {
        File file = new File(filePath);
        try {
            if (file.createNewFile() && file.delete()) {
                return null;
            }
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            T obj = (T) objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
