import java.util.Scanner;

public class Session {
    private User user;
    public Session(){

    }
    public void run () {
        Scanner in = new Scanner(System.in);
        if (user == null) {
            do {
                String username, password;
                //get shit
                System.out.print("Login:\nUsername: ");
                username = in.nextLine();
                System.out.print("Password:");
                password = in.nextLine();
                this.user = UserManager.login(username, password);
            } while (user != null);

        }
        while (true) {
            String cmd = in.nextLine();
            if (cmd == "log") {
                //do stuff
            }
            if (cmd == "") {
                //do stuff
            }

        }
    }
}
