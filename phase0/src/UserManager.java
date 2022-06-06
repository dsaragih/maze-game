import java.util.ArrayList;

public class UserManager {
    //variables
    //constructors
    //getters and setters
    //methods
    private int lastId = 0;
    private ArrayList<User> users = new ArrayList<User>();

    public boolean addUser(String userName, String password, boolean isAdmin){
        for (User oldUser : users){
            if (oldUser.getUserName() == userName){
                return false;
            }
        }
        User newUser = new User(userName, password, isAdmin, lastId);
        ++lastId;
        return true;
    }

    public User login(String userName, String password){
        for (User user : users){
            if (user.getUserName() == userName && user.getPassword() == password){
                return user;
            }
        }
        return null;
    }
}
