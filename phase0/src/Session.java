import java.util.Scanner;

public class Session {
    private User user;
    public Session(){
    }
    public void run () {
        Scanner in = new Scanner(System.in);
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
                System.out.print("Password:");
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

                System.out.print("Password:");
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


        System.out.println("Welcome " + user.getUserName());
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
