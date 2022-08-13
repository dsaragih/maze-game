package console.entities;
import java.io.Serializable;

public class User implements Serializable {
    private final String userName;
    private final String password;
    private final int userid;
    private final boolean admin;
    private boolean banned;

    public User(final String userName, final String password, final boolean admin, final int userid){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.userid = userid;
        this.banned = false;
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

    public void setBanned(final boolean banned) {
        this.banned = banned;
    }

}
