package console;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TextFileLogger {
    private final String filePath;
    public TextFileLogger(String filePath){
        this.filePath = filePath;
    }

    public boolean logToFile(Serializable obj) {
        try{
            FileOutputStream fileOut  = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public Object readFromFile() {
        try{
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object item = in.readObject();
            in.close();
            fileIn.close();
            return item;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }
}
