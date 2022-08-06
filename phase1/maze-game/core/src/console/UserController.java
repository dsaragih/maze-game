package console;
import java.util.ArrayList;

public class UserController {
    private TextFileLogger logger = new TextFileLogger("userManager.ser");
    public UserManager manager;

    public UserController() {
        UserManager storedManager = (UserManager) logger.readFromFile();
        this.manager = storedManager == null ? new UserManager() : storedManager;
    }

    public String addUser(String username, String password, boolean admin) {
        //if (username.equalsIgnoreCase("cancel")) { return "Cancelling!"; }
        if (username.equalsIgnoreCase(password)) {
            return "Need better password, not same as username!";
        }
        if (manager.getUser(username) != null){
            return "User already exists with that name!";
        }
        User user = new User(username, password, false, 9000);
        manager.addUser(username, password, admin);
        return "User added!";
    }

    public String deleteUser(String username) {
        User user = manager.getUser(username);
        if (user == null){
            return "User " + username + " does not exist!";
        }
        if (user.isAdmin()) {
            return "Admins like " + username + " can't be deleted!";
        }
        manager.delete(username);
        return "Successfully deleted " + username + "!";
    }

    public String banUser(String username) {
        User user = manager.getUser(username);
        if (user == null){
            return "User " + username + " does not exist!";
        }
        if(user.isBanned()){
            return "User " + username + " is already banned!";
        }
        user.setBanned(true);
        return "Successfully banned " + username + "!";
    }

    public String unbanUser(String username) {
        User user = manager.getUser(username);
        if (user == null){
            return "User " + username + " does not exist!";
        }
        if(!user.isBanned()){
            return "User " + username + " is unbanned anyway!";
        }
        user.setBanned(false);
        return "Successfully unbanned " + username + "!";
    }


    public User login(String userName, String password) {
        User user = manager.getUser(userName);
        if (user == null || !user.getPassword().equals(password) || user.isBanned()) {
            return null;
        }

        manager.recordLoginDate(user.getUserid());

        return user;
    }
    public String getLogsOf(int userid){
        ArrayList<Log> logs = manager.getLogs();
        StringBuilder logOutput = new StringBuilder("Your logins in chronological order:");
        for (Log log : logs) {
            if(log.getUserid() == userid) logOutput.append("\n").append(log.getLoginDate());
        }
        return logOutput.toString();
    }
    public boolean saveUserManager() {
        return logger.logToFile(manager);
    }
}
