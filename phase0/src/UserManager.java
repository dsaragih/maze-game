import java.util.ArrayList;

public class UserManager {

    private static int lastId = 0;
    private static ArrayList<User> users = new ArrayList<User>();
    public static boolean addUser(String userName, String password, boolean isAdmin){
        for (User oldUser : users){
            if (oldUser.getUserName() == userName){
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
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                user.recordLoginDate();
                return user;
            }
        }
        return null;
    }
}
