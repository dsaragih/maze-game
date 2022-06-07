import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager {

    private static int lastId = 0;
    private static Map<String, User> users = new HashMap<>();
    private static Map<User, Date> suspendedUsers = new HashMap<>();
    public static boolean addUser(String userName, String password, boolean isAdmin){
            if (users.get(userName) != null){
                return false;
            }
        User newUser = new User(userName, password, isAdmin, lastId);
        users.put(userName, newUser);
        ++lastId;
        return true;
    }

    public static User login(String userName, String password){
        Date today = new Date();

        if (users.get(userName).getUserName().equals(userName) && users.get(userName).getPassword().equals(password)
                && (!suspendedUsers.containsKey(users.get(userName)) || today.after(suspendedUsers.get(users.get(userName))))){
            users.get(userName).recordLoginDate();
            return users.get(userName);
        }
        return null;
    }
    public static void delete(String userName){
        User toBeDeleted = users.get(userName);
        if (toBeDeleted != null && !toBeDeleted.isAdmin()){
            users.remove(userName);
            System.out.println("The user" + toBeDeleted.getUserName() +"is deleted.");
        }
    }
    public static void suspend(String userName, Date date){
        User toBeSuspended = users.get(userName);
        if (toBeSuspended != null && !toBeSuspended.isAdmin()){
            suspendedUsers.put(toBeSuspended, date);
            System.out.println("The user" + toBeSuspended.getUserName() + "is suspended until" + date);
        }
    }
}
