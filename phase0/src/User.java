import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class User {
    private String userName;
    private String password;
    private final int userid;
    private final boolean admin;

    private final Date signUpDate;
    private ArrayList<Date> loginDates;


    public User(String userName, String password, boolean admin, int userid){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.userid = userid;
        signUpDate = new Date();
        loginDates = new ArrayList<>();
    }

    //getters and setters
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public void recordLoginDate(){
        loginDates.add(new Date());
    }

    public ArrayList<Date> getLoginDates(){
        return loginDates;
    }
    public int getUserid(){
        return userid;
    }
    public boolean isAdmin(){
        return admin;
    }
    public void setPassword(String newPassword){
        password = newPassword;
    }
    public void setUserName(String newUserName){
        userName = newUserName;
    }
    public void banUser(int id){
        if (admin){
            UserManager.delete(id);
        }
    }
    public void suspendUser(int id, Date date){
        if (admin){
            UserManager.suspend(id, date);
        }
    }
}
