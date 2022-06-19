import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class Session {
    private User user;
    private final InputController inputController = new InputController();
    private final Scanner in = new Scanner(System.in);

    public void run () throws ParseException, IOException {
        getUserFromConsole();

        writeln("");
        writeln("Welcome " + user.getUserName());

        while (true) {
            displayTitle("Menu");
            writeln("Choose from the following commands:");
            writeln("1) Log");
            writeln("2) AddUser");
            writeln("3) AddAdminUser");
            writeln("4) DeleteUser");
            writeln("5) BanUser");
            writeln("6) UnbanUser");
            writeln("7) Exit");
            int input = getNumInRange("Please enter a number between ", 1, 7);

            switch (input) {
                case 1 -> {
                    displayTitle("Log");
                    for (Date logInDate : user.getLoginDates()) {
                        writeln(logInDate);
                    }
                }
                case 2 -> addUser();
                case 3 -> addAdminUser();
                case 4 -> removeUser();
                case 5 -> banUser();
                case 6 -> unbanUser();
                case 7 -> {
                    user = null;
                    writeln("You have been logged out");
                    writeln("========================");
                    if(!inputController.saveUserManager()){
                        System.out.println("Error saving");
                    }
                    return;
                }
            }
        }


    }
    private void addUser(){
        displayTitle("Add user");
        String userName = getInputFromUser("Enter username", s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s), "This username is already taken");
        String password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
        if (inputController.addUser(userName, password)) {
            writeln("User added");
        } else {
            writeln("Unable to add user");
        }
    }

    private void addAdminUser(){
        displayTitle("Add admin user");
        String userName = getInputFromUser("Enter username", s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s), "This username is already taken");
        String password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
        if (inputController.addAdminUser(userName, password, user)) {
            writeln("User added");
        } else {
            writeln("Unable to add user");
        }
    }

    private void removeUser(){
        displayTitle("Delete user");
        if (!user.isAdmin()) {
            writeln("Unable to delete users.");
        } else {
            String userName = getInputFromUser("Enter the username of the user you would like to delete",
                    s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s),
                    "This user does not exist.");
            if (inputController.removeUser(userName, user)) {
                writeln("The user " + userName + " is deleted.");
            } else {
                writeln("Unable to delete " + userName);
            }
        }
    }

    private void banUser() throws ParseException {
        displayTitle("Ban user");
        if (!user.isAdmin()) {
            writeln("Unable to ban users.");
        } else {
            String userName = getInputFromUser("Enter is the username of the user you would like to ban", s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s), "This user does not exist.");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = getInputFromUser("Suspend until", s -> isValidDate(s, formatter), "This user does not exist.");
            if (inputController.banUser(userName, formatter.parse(dateString), user)) {
                writeln("The user " + userName + " is suspended until " + formatter.parse(dateString));
            } else {
                writeln("Unable to suspend " + userName);
            }
        }
    }

    private void unbanUser(){
        displayTitle("Unban user");
        if (!user.isAdmin()) {
            writeln("Unable to delete users.");
        } else {
            String userName = getInputFromUser(
                    "Enter is the username of the user you would like to ban",
                    s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s),
                    "This user does not exist.");
            if (inputController.unbanUser(userName, user)) {
                writeln("The user " + userName + " has been unbanned.");
            } else {
                writeln("Unable to unban " + userName);
            }
        }
    }



    private boolean isValidDate(String text, SimpleDateFormat formatter){
        try{
            formatter.parse(text);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isStringNotNullOrEmpty(String text){
        return !(text == null || text.length() == 0);
    }

    private void writeSeparator(){
        writeln("======================================================================");
    }
    private boolean isStringANumberInRange(String text, int min, int max){
        try {
            int num = Integer.parseInt(text);
            return min <= num && num <= max;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private int getNumInRange(String prompt, int min, int max){
        String input = getInputFromUser(prompt,
                s -> isStringANumberInRange(s, min, max));

        return Integer.parseInt(input);
    }

    private String getInputFromUser(String prompt, Predicate<String> predicate, String errorMessage){
        while(true){
            writeln(prompt);
            writeln("Input: ");
            String input = in.nextLine();

            if(predicate.test(input)){
                return input;
            }

            writeln(errorMessage + "\n");
        }
    }
    private String getInputFromUser(String prompt, Predicate<String> predicate){
        return getInputFromUser(prompt, predicate, "Invalid input.");
    }

    private void writeln(Object obj){
        System.out.println(obj);
    }

    private void displayTitle(String text){
        writeln("");
        writeln(text);
        writeSeparator();
    }

    private void getUserFromConsole(){
        String username, password;
        int state = 0;
        while(user == null){
            switch (state){
                case 0 -> {
                    displayTitle("Welcome");
                    state = getNumInRange("Login (1) or signup (2)", 1, 2);
                }
                case 1 -> {
                    displayTitle("Login");
                    username = getInputFromUser("Enter username", this::isStringNotNullOrEmpty, "Username cannot be empty");
                    password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
                    user = inputController.login(username, password);

                    if(user == null){
                        writeln("Username or password incorrect");
                    }
                    state = 0;
                }
                case 2 -> {
                    displayTitle("Signup");
                    username = getInputFromUser("Enter username", s -> isStringNotNullOrEmpty(s) && !inputController.doesUserExist(s), "This username is already taken");
                    password = getInputFromUser("Enter password", this::isStringNotNullOrEmpty, "The password cannot be empty");
                    if (inputController.addUser(username, password)) {
                        writeln("User added");
                    } else {
                        writeln("Unable to signup");
                    }
                    state = 0;
                }
            }
        }
    }
}
