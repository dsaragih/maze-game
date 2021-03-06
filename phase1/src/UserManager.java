import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
public class UserManager implements Serializable {
    private int lastId = 0;
    private final Map<String, User> users = new HashMap<>();
    private final ArrayList<Log> logHistory = new ArrayList<>();

    public UserManager(){
        if(users.isEmpty())
            addUser("admin", "123", true); //was "TestAdmin" before made "admin"
    }
    public void addUser(String userName, String password, boolean isAdmin) {
        //int lastId = users.values().stream().mapToInt(User::getUserid).max().orElse(0);
        User newUser = new User(userName, password, isAdmin, lastId);
        users.put(userName, newUser);
        ++lastId;
    }
    public User getUser(String username){
        return users.get(username);
    }
    public void delete(String userName){
        users.remove(userName);
    }

    public void recordLoginDate(int userid){
        Log log = new Log(userid, new Date());
        logHistory.add(log);
    }

    public ArrayList<Log> getLogs(){
        return logHistory;
    }
}
