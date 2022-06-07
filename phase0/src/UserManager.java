import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager {

    private static int lastId = 0;
    private static ArrayList<User> users = new ArrayList<>();
    private static Map<User, Date> suspendedUsers = new HashMap<>();
    public static boolean addUser(String userName, String password, boolean isAdmin){
        for (User oldUser : users){
            if (oldUser.getUserName().equals(userName)){
                return false;
            }
        }
        User newUser = new User(userName, password, isAdmin, lastId);
        users.add(newUser);
        ++lastId;
        return true;
    }

    public static User login(String userName, String password){
        for (User user : users){
            Date today = new Date();

            if (user.getUserName().equals(userName) && user.getPassword().equals(password)
                    && (!suspendedUsers.containsKey(user) || today.after(suspendedUsers.get(user)))){
                user.recordLoginDate();
                return user;
            }
        }
        return null;
    }
    public static void delete(int userid){
        User toBeDeleted = null;
        boolean findDeleted = false;
        for (User user: users){
            if (user.getUserid() == userid){
                toBeDeleted = user;
                findDeleted = true;
                break;
            }
        }
        if (findDeleted && !toBeDeleted.isAdmin()){
            users.remove(toBeDeleted);
            System.out.println("The user" + toBeDeleted.getUserName() +"is deleted.");
        }
    }
    public static void suspend(int userid, Date date){
        User toBeSuspended = null;
        boolean findSuspended = false;
        for (User user: users){
            if (user.getUserid() == userid){
                toBeSuspended = user;
                findSuspended = true;
                break;
            }
        }
        if (findSuspended && !toBeSuspended.isAdmin()){
            suspendedUsers.put(toBeSuspended, date);
            System.out.println("The user" + toBeSuspended.getUserName() + "is suspended until" + date);
        }
    }
}
