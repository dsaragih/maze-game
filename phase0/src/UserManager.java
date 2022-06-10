import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager {

    private static int lastId = 0;
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Date> suspendedUsers = new HashMap<>();
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

        if (users.get(userName) == null) return null;
        // If we try to log in an invalid user, program will crash as we will be calling
        // .getUserName() on null. So we check deal with the null case separately.

        if (users.get(userName).getUserName().equals(userName) && users.get(userName).getPassword().equals(password)
                && (!suspendedUsers.containsKey(userName) || today.after(suspendedUsers.get(userName)))){
            users.get(userName).recordLoginDate();
            return users.get(userName);
        }
        return null;
    }
    public static void delete(String userName){
        User toBeDeleted = users.get(userName);
        if (toBeDeleted != null && !toBeDeleted.isAdmin()){
            users.remove(userName);
            System.out.println("The user " + toBeDeleted.getUserName() +" is deleted.");
        }
        else System.out.println("Unable to delete " + userName);
    }
    public static void suspend(String userName, Date date){
        User toBeSuspended = users.get(userName);
        if (toBeSuspended != null && !toBeSuspended.isAdmin()) {
            suspendedUsers.put(userName, date);
            System.out.println("The user " + toBeSuspended.getUserName() + " is suspended until " + date);
        }
        else System.out.println("Unable to suspend " + userName);
    }

    public static void unban(String userName) {
        if (suspendedUsers.containsKey(userName)) {
            suspendedUsers.remove(userName);
            System.out.println("The user " + userName + " has been unbanned.");
        }
        else System.out.println("Unable to unban " + userName);
    }

    public static Map<String, User> getUsers() {
        return users;
    }
    public static Map<String, Date> getSuspendedUsers() {
        return suspendedUsers;
    }
}
