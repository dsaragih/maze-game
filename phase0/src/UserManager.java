import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager {

    private static int lastId = 0;
    private static final Map<String, User> users = new HashMap<>();
    private static final Map<String, Date> suspendedUsers = new HashMap<>();
    public static boolean addUser(String userName, String password, boolean isAdmin) throws IOException {
        if (users.get(userName) != null){
            return false;
        }
        User newUser = new User(userName, password, isAdmin, lastId);
        users.put(userName, newUser);
        ++lastId;
        Logger.addToLog(newUser);
        return true;
    }

    public static User login(String userName, String password){
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
    public static boolean delete(String userName){
        User toBeDeleted = users.get(userName);
        if (toBeDeleted != null && !toBeDeleted.isAdmin()){
            users.remove(userName);
            return true;
        }
        return false;
    }
    public static boolean ban(String userName, Date date){
        User toBeSuspended = users.get(userName);
        if (toBeSuspended != null && !toBeSuspended.isAdmin()) {
            suspendedUsers.put(userName, date);
            return true;
        }
        return false;
    }

    public static boolean unban(String userName) {
        if (suspendedUsers.containsKey(userName)) {
            suspendedUsers.remove(userName);
            return true;
        }
        return false;
    }

    public static boolean doesUserExist(String username){
        return users.get(username) != null;
    }

    public static Map<String, User> getUsers() {
        return users;
    }
    public static Map<String, Date> getSuspendedUsers() {
        return suspendedUsers;
    }
}
