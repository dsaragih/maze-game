import java.io.FileWriter;
import java.io.IOException;

public class Logger{

    public static FileWriter logWriter;

    static {
        try {
            logWriter = new FileWriter("logins.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Logger() throws IOException {
    }

    public static void addToLog(User user) throws IOException{

        try {
            logWriter.write(user.getUserName() + " " + user.getPassword() + " " + user.getUserid());
            logWriter.write("\r\n");
            logWriter.flush();
        } catch (IOException e){
            System.out.println("Exception caught.");
        }

    }
}
