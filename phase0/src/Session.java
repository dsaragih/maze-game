import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class Session {
    private User user;
    Scanner in = new Scanner(System.in);

    public void run () throws ParseException, IOException {

        getUserFromConsole(in);

        writeln("");
        writeln("Welcome " + user.getUserName());

        while(true){
            displayTitle("Menu");
            writeln("Choose from the following commands:");
            writeln("1) Log");
            writeln("2) AddUser");
            writeln("3) DeleteUser");
            writeln("4) BanUser");
            writeln("5) UnbanUser");
            writeln("6) Exit");
            int input = getNumInRange(1, 6);
            switch (input) {
                case 1 -> {
                    displayTitle("Log");
                    for (Date logInDate : user.getLoginDates()) {
                        writeln(logInDate);
                    }
                }
                case 2 -> {
                    displayTitle("Add user");
                    String userName = getInputFromUser("Enter username", s -> isStringNullOrEmpty(s) && !UserManager.doesUserExist(s), "This username is already taken");
                    String password = getInputFromUser("Enter password", s -> isStringNullOrEmpty(s), "The password cannot be empty");
                    if (UserManager.addUser(userName, password, false)) {
                        writeln("User added");
                    } else {
                        writeln("Unable to add user");
                    }
                }
                case 3 -> {
                    displayTitle("Delete user");
                    if (!user.isAdmin()) {
                        writeln("Unable to delete users.");
                    }
                    else {
                        String userName = getInputFromUser("Enter is the username of the user you would like to delete", s -> isStringNullOrEmpty(s) && !UserManager.doesUserExist(s), "This user does not exist.");
                        if(UserManager.delete(userName)){
                            writeln("The user " + userName +" is deleted.");
                        }else{
                            writeln("Unable to delete " + userName);
                        }
                    }
                }
                case 4 -> {
                    displayTitle("Ban user");
                    if (!user.isAdmin()) {
                        writeln("Unable to ban users.");
                    }
                    else {
                        String userName = getInputFromUser("Enter is the username of the user you would like to ban", s -> isStringNullOrEmpty(s) && !UserManager.doesUserExist(s), "This user does not exist.");
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String dateString = getInputFromUser("Suspend until", s -> isValidDate(s, formatter), "This user does not exist.");
                        if(UserManager.ban(userName, formatter.parse(dateString))){
                            writeln("The user " + userName + " is suspended until " + formatter.parse(dateString));
                        }else{
                            writeln("Unable to suspend " + userName);
                        }
                    }
                }
                case 5 -> {
                    displayTitle("Unban user");
                    if (!user.isAdmin()) {
                        writeln("Unable to delete users.");
                    }
                    else {
                        String userName = getInputFromUser("Enter is the username of the user you would like to ban", s -> isStringNullOrEmpty(s) && !UserManager.doesUserExist(s), "This user does not exist.");
                        if(UserManager.unban(userName)){
                            writeln("The user " + userName + " has been unbanned.");
                        }else{
                            writeln("Unable to unban " + userName);
                        }
                    }
                }
                case 6 -> {
                    user = null;
                    writeln("You have been logged out");
                    writeln("========================");

                    getUserFromConsole(in);
                }
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
    private boolean isStringNullOrEmpty(String text){
        return text != null && text.length() != 0;
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
    private int getNumInRange(int min, int max){
        return getNumInRange("Please enter a number between " + min + " and " + max, min, max);
    }

    private String getInputFromUser(String prompt, Predicate<String> predicate, String errorMessage){
        while(true){
            writeln(prompt);
            write("Input: ");
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
    private void write(Object obj){
        System.out.print(obj);
    }

    private void displayTitle(String text){
        writeln("");
        writeln(text);
        writeSeparator();
    }

    private void getUserFromConsole(Scanner in) throws IOException {
        String username = "", password = "";
        int state = 0;
        while(user == null){
            switch (state){
                case 0 -> {
                    displayTitle("Welcome");
                    state = getNumInRange("Login (1) or signup (2)", 1, 2);
                }
                case 1 -> {
                    displayTitle("Login");
                    username = getInputFromUser("Enter username", s -> isStringNullOrEmpty(s), "Username cannot be empty");
                    password = getInputFromUser("Enter password", s -> isStringNullOrEmpty(s), "The password cannot be empty");
                    user = UserManager.login(username, password);

                    if(user == null){
                        writeln("Username or password incorrect");
                    }
                    state = 0;
                }
                case 2 -> {
                    displayTitle("Signup");
                    username = getInputFromUser("Enter username", s -> isStringNullOrEmpty(s) && !UserManager.doesUserExist(s), "This username is already taken");
                    password = getInputFromUser("Enter password", s -> isStringNullOrEmpty(s), "The password cannot be empty");
                    if (UserManager.addUser(username, password, false)) {
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
