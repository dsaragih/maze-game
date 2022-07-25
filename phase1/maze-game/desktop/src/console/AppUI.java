package console;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class AppUI {
    private static int MIN = 1;//smallest acceptable username/password
    private User user;
    private UserController userController = new UserController();
    private Scanner in = new Scanner(System.in);

    public void run() throws ParseException, IOException {
        while (true) {
            mainMenu();
            if (user == null) {
                //Exits to main.
                //Move the if statement, which serializes the users, to main?
                //but userController is here and not in main. Does main need to know about it?
                if (!userController.saveUserManager()) {
                    System.out.println("Error saving");//writeln
                }
                return;
            }
            writeln("");
            writeln("Welcome " + user.getUserName());

            loggedInMenu();

            user = null; // could also go right before the call to mainMenu()
            writeln("You have been logged out");
            writeln("========================");
        }

    }

    private void mainMenu() {
        int state = -1;
        while (user == null) {
            switch (state) {
                case -1: {
                    displayTitle("Welcome");
                    state = getNumInRange("Exit (0) or Login (1) or Signup (2) or Play Demo (3)", 3);
                    break;
                }
                case 0: {
                    return;
                }
                case 1: {
                    displayTitle("Login");
                    user = userController.login(enter("username"), enter("password"));
                    if (user == null) {
                        writeln("Username or password incorrect (or you're just banned).");
                    }
                    state = -1;
                    break;
                }
                case 2: {
                    displayTitle("Signup");
                    String username = enter("username");
                    String password = enter("password");
                    String outcome = userController.addUser(username, password, false);
                    writeln(outcome);
                    user = userController.login(username, password);
                    state = -1;
                    break;
                }
                case 3: {
                    com.mygdx.game.DesktopLauncher.main(new String[]{});
                    state = -1;
                }
            }
        }
    }

    private void loggedInMenu() {
        while (true) {
            displayTitle("Menu");
            writeln("Choose from the following commands:");
            writeln("0) Log Out");
            writeln("1) Log");
            writeln("2) AddUser");
            if (user.isAdmin()) {
                writeln("3) AddAdminUser (Admin only)");
                writeln("4) DeleteUser (Admin only)");
                writeln("5) BanUser (Admin only)");
                writeln("6) UnbanUser (Admin only)");
            }
            int input = getNumInRange("Please enter a number between ", user.isAdmin() ? 6 : 2);

            switch (input) {
                case 0: return;
                case 1: log(); break;
                case 2: addUser(false); break;
                case 3: addUser(true); break;
                case 4: deleteUser(); break;
                case 5: banUser(); break;
                case 6: unbanUser();
            }
        }
    }

    private void log() {
        displayTitle("Log");
        String outcome = userController.getLogsOf(user.getUserid());
        writeln(outcome);
    }

    private void addUser(boolean admin) {
        if (admin) displayTitle("Add admin user");
        else displayTitle("Add user");
        String outcome = userController.addUser(enter("username"), enter("password"), admin);
        writeln(outcome);
    }

    private void deleteUser() {
        displayTitle("Permanently delete user");
        String outcome = userController.deleteUser(enter("username"));
        writeln(outcome);
    }

    private void banUser() {
        displayTitle("Ban user");
        String outcome = userController.banUser(enter("username"));
        writeln(outcome);
    }

    private void unbanUser() {
        displayTitle("Unban user");
        String outcome = userController.unbanUser(enter("username"));
        writeln(outcome);

    }

    private String enter(String what) {
        String str;
        do {
            writeln("Enter " + what + ": ");
            str = in.nextLine();
        }
        while ((str == null || str.length() < MIN) && tooShort());
        return str;
    }

    private boolean tooShort() {
        writeln("Too short! Must be at least " + MIN + " characters.");
        return true;
    }


    private int getNumInRange(String prompt, int max) {
        String input = getInputFromUser(prompt, s -> isStringANumberInRange(s, 0, max));

        return Integer.parseInt(input);
    }

    private boolean isStringANumberInRange(String text, int min, int max) {
        try {
            int num = Integer.parseInt(text);
            return min <= num && num <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String getInputFromUser(String prompt, Predicate<String> predicate, String errorMessage) {
        while (true) {
            writeln(prompt);
            writeln("Input: ");
            String input = in.nextLine();

            if (predicate.test(input)) {
                return input;
            }

            writeln(errorMessage + "\n");
        }
    }

    private String getInputFromUser(String prompt, Predicate<String> predicate) {
        return getInputFromUser(prompt, predicate, "Invalid input.");
    }


    private void writeln(Object obj) {
        System.out.println(obj);
    }

    private void writeSeparator() {
        writeln("======================================================================");
    }

    private void displayTitle(String text) {
        writeln("");
        writeln(text);
        writeSeparator();
    }

}
