import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager implements Serializable {
    private int lastId = 0;
    private final Map<String, User> users = new HashMap<>();
    private final ArrayList<String> bannedUsers = new ArrayList<>();

    public boolean addUser(String userName, String password, boolean isAdmin) {
        if (users.get(userName) != null){
            return false;
        }
        User newUser = new User(userName, password, isAdmin, lastId);
        users.put(userName, newUser);
        ++lastId;
        return true;
    }

    public User login(String userName, String password){
        User user = users.get(userName);
        if (user == null){
            return null;
        }

        if (user.getPassword().equals(password) && !bannedUsers.contains(userName)){
            user.recordLoginDate();
            return user;
        }
        return null;
    }
    public boolean delete(String userName){
        User toBeDeleted = users.get(userName);
        if (toBeDeleted != null && !toBeDeleted.isAdmin()){
            users.remove(userName);
            return true;
        }
        return false;
    }
    public boolean ban(String userName){
        if(!doesUserExist(userName) || bannedUsers.contains(userName)){
            return false;
        }

        User toBeSuspended = users.get(userName);
        if(toBeSuspended.isAdmin()){
            return false;
        }

        bannedUsers.add(userName);
        return true;
    }

    public boolean unban(String userName) {
        if(!doesUserExist(userName) || !bannedUsers.contains(userName)){
            return false;
        }
        bannedUsers.remove(userName);
        return true;
    }

    public boolean doesUserExist(String username){
        return users.get(username) != null;
    }

    public Map<String, User> getUsers() {
        return users;
    }
    public ArrayList<String> getBannedUsers() {
        return bannedUsers;
    }
}
