import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager {

    private Logger logger = new Logger();
    private int lastId = 0;
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Date> suspendedUsers = new HashMap<>();

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
        Date today = new Date();
        User user = users.get(userName);
        if (user == null){
            return null;
        }
        // If we try to log in an invalid user, program will crash as we will be calling
        // .getUserName() on null. So we deal with the null case separately.

        if (user.getPassword().equals(password) && (!suspendedUsers.containsKey(userName) || today.after(suspendedUsers.get(userName)))){
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
    public boolean ban(String userName, Date date){
        User toBeSuspended = users.get(userName);
        if (toBeSuspended != null && !toBeSuspended.isAdmin()) {
            suspendedUsers.put(userName, date);
            return true;
        }
        return false;
    }

    public boolean unban(String userName) {
        if (suspendedUsers.containsKey(userName)) {
            suspendedUsers.remove(userName);
            return true;
        }
        return false;
    }

    public boolean doesUserExist(String username){
        return users.get(username) != null;
    }

    public Map<String, User> getUsers() {
        return users;
    }
    public Map<String, Date> getSuspendedUsers() {
        return suspendedUsers;
    }
}
