import java.io.*;
import java.util.ArrayList;

public class Logger{

    public void logToFile(ArrayList<User> users) throws IOException {
        FileOutputStream fileOut  = new FileOutputStream("/usersData.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(users);
        out.close();
        fileOut.close();
    }

    public ArrayList<User> readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("/usersData.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<User> users = (ArrayList<User>) in.readObject();
        in.close();
        fileIn.close();
        return users;
    }
}
