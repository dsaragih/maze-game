import java.text.ParseException;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Session s = new Session();
        try {
            s.run();
        } catch (ParseException e) {
            System.out.println("Exception caught");
        }
    }
}


