import org.w3c.dom.Text;

import java.util.Date;

public class InputController{
    public UserManager manager;
    private final TextFileLogger logger = new TextFileLogger("userManager.ser");
    public InputController() {
        UserManager storedManager = (UserManager)logger.readFromFile();
        this.manager = storedManager == null ? new UserManager() : storedManager;
    }

    public boolean addUser(String username, String password) {
        if(username.equalsIgnoreCase("cancel")){
            return false;
        }
        return manager.addUser(username, password, false);
    }
    public boolean addAdminUser(String username, String password, User user) {
        if(user.isAdmin()){
            return manager.addUser(username, password, true);
        }
        return false;
    }

    public boolean removeUser(String toDelete, User u){
        if(u.isAdmin()){
            return manager.delete(toDelete);
        }
        return false;
    }

    public boolean banUser(String toBan, User user){
        if(!user.isAdmin()){
            return false;
        }
        return manager.ban(toBan);
    }

    public boolean unbanUser(String toUnban, User user){
        if(!user.isAdmin()){
            return false;
        }
        return manager.unban(toUnban);
    }

    public boolean doesUserExist(String username){
        return manager.doesUserExist(username);
    }

    public User login(String username, String password){
        return manager.login(username,password);
    }

    public boolean saveUserManager(){
        return logger.logToFile(manager);
    }
}
