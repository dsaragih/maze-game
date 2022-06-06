import java.util.Date;
import java.util.Scanner;

public class Session {
    private User user;
    public void run () {
        Scanner in = new Scanner(System.in);
        getUserFromConsole(in);

        System.out.println("");
        System.out.println("Welcome " + user.getUserName());
        System.out.println("Choose from the following commands:");
        System.out.println("log, AddUser, DeleteUser, BanUser, UnbanUser, UnbanUser, Exit");
        while (true) {
            String cmd = in.nextLine();
            if (cmd == "log") {
                System.out.println();
                for(Date logInDate : user.getLoginDates()){
                    System.out.println(logInDate);
                }
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
                user = null;
                System.out.println("You have been logged out");
                System.out.println("========================");

                getUserFromConsole(in);
            }

        }
    }

    private void getUserFromConsole(Scanner in) {
        String username = "", password = "";

        while(user == null)
        {
            System.out.println("Login (1) or Sign Up (2)");
            String input = in.nextLine();

            if(input.equals("1"))
            {
                System.out.println("Login");
                System.out.println("=====");

                System.out.print("Username: ");
                username = in.nextLine();
                System.out.print("Password: ");
                password = in.nextLine();
                user = UserManager.login(username, password);

                if(user == null){
                    System.out.println("Username or password incorrect");
                }
            }
            else if(input.equals("2"))
            {
                System.out.println("Sign up");
                System.out.println("=====");

                System.out.print("Username: ");
                username = in.nextLine();

                System.out.print("Password: ");
                password = in.nextLine();

                if(!UserManager.addUser(username, password,false)){
                    System.out.println("The username " + username + " is already taken.");
                }
                else
                {
                    System.out.println("User added!");
                }
            }
        }
    }
}
