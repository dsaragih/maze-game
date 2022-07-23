import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class Session {
    private User user;
    private final InputController inputController = new InputController();
    private final Scanner in = new Scanner(System.in);

    public void run() throws ParseException, IOException {

        loginOrSignupFromConsole();
        if (user == null) {
            return;
        }
        writeln("");
        writeln("Welcome " + user.getUserName());

        boolean shouldExit = false;
        while (!shouldExit) {
            displayTitle("Menu");
            writeln("Choose from the following commands:");
            writeln("1) Log");
            writeln("2) AddUser");
            writeln("3) AddAdminUser");
            writeln("4) DeleteUser");
            writeln("5) BanUser");
            writeln("6) UnbanUser");
            writeln("7) Exit");
            int input = getNumInRange("Please enter a number between ", 7);

            switch (input) {
                case 1 -> log();
                case 2 -> addUser();
                case 3 -> addAdminUser();
                case 4 -> removeUser();
                case 5 -> banUser();
                case 6 -> unbanUser();
                case 7 -> shouldExit = true;
            }
        }
        writeln("You have been logged out");
        writeln("========================");
        if (!inputController.saveUserManager()) {
            System.out.println("Error saving");
        }

    }

    private void log() {
        displayTitle("Log");
        for (Date logInDate : user.getLoginDates()) {
            writeln(logInDate);
        }
    }

    private void addUser() {
        displayTitle("Add user");

        String prompt = "Enter username (or type 'cancel' to cancel)";
        Predicate<String> predicate = s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s);
        String errorMessage = "Input cannot be empty or an existing username";
        String userName = getInputFromUser(prompt, predicate, errorMessage);

        if (userName.equalsIgnoreCase("cancel")) {
            System.out.println("CANCELED");
            return;
        }

        prompt = "Enter password";
        predicate = this::isStringNotNullOrEmpty;
        errorMessage = "The password cannot be empty";
        String password = getInputFromUser(prompt, predicate, errorMessage);

        if (inputController.addUser(userName, password)) {
            writeln("User added");
            return;
        }
        writeln("Unable to add user");
    }

    private void addAdminUser() {
        displayTitle("Add admin user");

        if (!user.isAdmin()) {
            writeln("You do not have admin status");
            return;
        }

        String prompt = "Enter username (or type 'cancel' to cancel)";
        Predicate<String> predicate = s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s);
        String errorMessage = "Input cannot be empty or an existing username";
        String userName = getInputFromUser(prompt, predicate, errorMessage);

        if (userName.equalsIgnoreCase("cancel")) {
            System.out.println("CANCELED");
            return;
        }

        prompt = "Enter password";
        predicate = this::isStringNotNullOrEmpty;
        errorMessage = "The password cannot be empty";
        String password = getInputFromUser(prompt, predicate, errorMessage);

        if (inputController.addAdminUser(userName, password, user)) {
            writeln("User added");
            return;
        }
        writeln("Unable to add user");
    }

    private void removeUser() {
        displayTitle("Delete user");

        if (!user.isAdmin()) {
            writeln("You do not have admin status");
            return;
        }

        String prompt = "Enter the username of the user you would like to delete (or type 'cancel' to cancel)";
        Predicate<String> predicate = s -> isStringNotNullOrEmpty(s)
                && (inputController.doesUserExist(s) || s.equalsIgnoreCase("cancel"));
        String errorMessage = "Input must be an existing username or 'cancel'";

        String userName = getInputFromUser(prompt, predicate, errorMessage);

        if (userName.equalsIgnoreCase("cancel")) {
            System.out.println("CANCELED");
            return;
        }

        if (inputController.removeUser(userName, user)) {
            writeln("The user " + userName + " is deleted.");
            return;
        }
        writeln("Unable to delete " + userName);
    }

    private void banUser() {
        displayTitle("Ban user");

        if (!user.isAdmin()) {
            writeln("You do not have admin status");
            return;
        }
        String prompt = "Enter the username of the user you would like to ban (or type 'cancel' to cancel)";
        Predicate<String> predicate = s -> isStringNotNullOrEmpty(s)
                && (inputController.doesUserExist(s) || s.equalsIgnoreCase("cancel"))
                && !s.equals(user.getUserName());
        String errorMessage = "Input must be an existing username or 'cancel'. You also cannot ban yourself.";

        String userName = getInputFromUser(prompt, predicate, errorMessage);

        if (userName.equalsIgnoreCase("cancel")) {
            System.out.println("CANCELED");
            return;
        }

        if (inputController.banUser(userName, user)) {
            writeln("The user " + userName + " has been banned");
            return;
        }
        writeln("Unable to ban " + userName);
    }

    private void unbanUser() {
        displayTitle("Unban user");
        if (!user.isAdmin()) {
            writeln("Unable to delete users.");
        }

        String prompt = "Enter the username of the user you would like to unban (or type 'cancel' to cancel)";
        Predicate<String> predicate = s -> isStringNotNullOrEmpty(s)
                && (inputController.doesUserExist(s) || s.equalsIgnoreCase("cancel"));
        String errorMessage = "Input must be an existing username or 'cancel'";

        String userName = getInputFromUser(prompt, predicate, errorMessage);

        if (userName.equalsIgnoreCase("cancel")) {
            System.out.println("CANCELED");
            return;
        }

        if (inputController.unbanUser(userName, user)) {
            writeln("The user " + userName + " has been unbanned.");
            return;
        }
        writeln("Unable to unban " + userName);
    }

    private boolean isStringNotNullOrEmpty(String text) {
        return !(text == null || text.length() == 0);
    }

    private void writeSeparator() {
        writeln("======================================================================");
    }

    private boolean isStringANumberInRange(String text, int min, int max) {
        try {
            int num = Integer.parseInt(text);
            return min <= num && num <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int getNumInRange(String prompt, int max) {
        String input = getInputFromUser(prompt, s -> isStringANumberInRange(s, 1, max));

        return Integer.parseInt(input);
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

    private void displayTitle(String text) {
        writeln("");
        writeln(text);
        writeSeparator();
    }

    private void loginOrSignupFromConsole() {
        String username, password;
        int state = 0;
        while (user == null) {
            switch (state) {
                case 0 -> {
                    displayTitle("Welcome");
                    state = getNumInRange("Login (1) or signup (2) or exit (3) or Demo4 (4) or Demo5 (5)", 5);
                }
                case 1 -> {
                    displayTitle("Login");
                    username = getInputFromUser("Enter username", this::isStringNotNullOrEmpty, "Username cannot be empty");
                    password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
                    user = inputController.login(username, password);

                    if (user == null) {
                        writeln("Username or password incorrect");
                    }
                    state = 0;
                }
                case 2 -> {
                    displayTitle("Signup");
                    username = getInputFromUser("Enter username (or type 'cancel' to cancel)", s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s), "This username is already taken");
                    if (username.equalsIgnoreCase("cancel")) {
                        state = 0;
                        break;
                    }

                    password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
                    if (inputController.addUser(username, password)) {
                        writeln("User added");
                    } else {
                        writeln("Unable to signup");
                    }
                    state = 0;
                }

                case 3 -> {
                    return;
                }

                case 4 -> {
                    DisplayGraphics.main();
                    state = 0;
                }
                case 5 -> {
                    AnimatorApplicationTimer.main(10);
                    state = 0;
                }
            }
        }
    }
}
