import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class User implements Serializable {
    private String userName;
    private String password;
    private int userid;
    private boolean admin;
    private boolean banned;

    private Date signUpDate; //saved but never accessed.
    public User(String userName, String password, boolean admin, int userid){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.userid = userid;
        this.banned = false;
        signUpDate = new Date();
    }

    //getters and setters
    public int getUserid() { return userid; }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public boolean isAdmin(){
        return admin;
    }
    public boolean isBanned() { return banned; }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

}
