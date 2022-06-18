import java.util.Date;

public class InputController{
    public UserManager manager;

    public InputController(){
        this.manager = new UserManager();
    }

    public boolean addUser(String username, String password) {
        return manager.addUser(username, password, false);
    }
    public boolean addAdminUser(String username, String password, User u) {
        if(u.isAdmin()){
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

    public boolean banUser(String toBan, Date date, User u){
        if(u.isAdmin()){
            return manager.ban(toBan, date);
        }
        return false;

    }

    public boolean unbanUser(String toUnban, User u){
        if(u.isAdmin()){
            return manager.unban(toUnban);
        }
        return false;
    }

    public boolean doesUserExist(String username){
        return manager.doesUserExist(username);
    }

    public User login(String username, String password){
        return manager.login(username,password);

    }
}
