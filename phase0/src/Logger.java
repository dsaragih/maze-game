import java.io.FileWriter;
import java.io.IOException;

public class Logger{

    public static void addToLog(User user) throws IOException{

        try {
            FileWriter logWriter = new FileWriter("logins.txt");
            logWriter.write(user.getUserName() + " " + user.getPassword() + " " + user.getUserid() + "\n");
            logWriter.close();
        } catch (IOException e){
            System.out.println("Exception caught.");
        }

    }
}
