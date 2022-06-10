import org.w3c.dom.CDATASection;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Session {
    private User user;
    public void run () throws ParseException {
        Scanner in = new Scanner(System.in);
        getUserFromConsole(in);

        System.out.println("");
        System.out.println("Welcome " + user.getUserName());
        System.out.println("Choose from the following commands:");
        System.out.println("log, AddUser, DeleteUser, BanUser, UnbanUser, UnbanUser, Exit");
        while (true) {
            String cmd = in.nextLine();
            if (cmd.equals("log")) {
                System.out.println();
                for(Date logInDate : user.getLoginDates()){
                    System.out.println(logInDate);
                }
            }
            if (cmd.equals("AddUser")) {
                // All users added are never admin
                System.out.println("Enter username: ");
                String userName = in.nextLine();
                System.out.println("Enter password: ");
                String password = in.nextLine();
                UserManager.addUser(userName, password, false);
            }
            if (cmd.equals("DeleteUser")) {
                if (!user.isAdmin()) {
                    System.out.println("Unable to delete users.");
                    continue;
                }
                else {
                    System.out.println("Delete user: ");
                    String userName = in.nextLine();
                    UserManager.delete(userName);
                }
            }
            if (cmd.equals("BanUser")) {
                if (!user.isAdmin()) {
                    System.out.println("Unable to ban users.");
                    continue;
                }
                else {
                    System.out.println("Suspend user: ");
                    String userName = in.nextLine();
                    System.out.println("Suspend until ");
                    String dateString = in.nextLine();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    UserManager.suspend(userName, formatter.parse(dateString));
                }
            }
            if (cmd.equals("UnbanUser")) {
                if (!user.isAdmin()) {
                    System.out.println("Unable to delete users.");
                    continue;
                }
                else {
                    System.out.println("Unban user: ");
                    String userName = in.nextLine();
                    UserManager.unban(userName);
                }
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

                if(!UserManager.addUser(username, password,true)){
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
