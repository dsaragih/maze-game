import java.io.IOException;
import java.text.ParseException;
public class Main {
    public static void main(String[]args){
        Session s = new Session();
        try {
            s.run();
        } catch (ParseException | IOException e) {
            System.out.println("Exception caught:, " + e.getMessage());
        }
    }
}


