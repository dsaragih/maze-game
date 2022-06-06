import java.util.Scanner;

public class Session {
    private User user;
    public Session(){
    }
    public void run () {
        Scanner in = new Scanner(System.in);

        do {
            String username = "", password = "";
            //get shit
            System.out.println("Login (1) or Sign Up (2)");
            String input = in.nextLine();
            if(input.equals("1")){
                System.out.print("Login:\nUsername: ");
                username = in.nextLine();
                System.out.print("Password:");
                password = in.nextLine();
                if(!UserManager.addUser(username, password,false)){
                    System.out.println("Username Already Taken");
                }
            }else if (input.equals("2")){
                System.out.print("Login:\nUsername: ");
                username = in.nextLine();
                System.out.print("Password:");
                password = in.nextLine();
            }
            this.user = UserManager.login(username, password);
        } while (user == null);
        System.out.println("Logged In");
        while (true) {
            String cmd = in.nextLine();
            if (cmd == "log") {
                //do stuff
            }
            if (cmd == "AddUser") {

            }
            if (cmd == "DeleteUser") {

            }
            if (cmd == "BanUser") {

            }
            if (cmd == "UnbanUser") {

            }
            if (cmd.equals("Exit")){
                return;
            }

        }
    }
}
