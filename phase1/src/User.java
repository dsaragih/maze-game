import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {
    private final String userName;
    private final String password;
    private final int userid;
    private final boolean admin;

    private final Date signUpDate;
    private final ArrayList<Date> loginDates;

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
    public boolean isAdmin(){
        return admin;
    }

}
