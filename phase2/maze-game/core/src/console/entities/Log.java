package console.entities;
import java.util.Date;
import java.io.Serializable;

public class Log implements Serializable {
    private final int userid;
    private final Date loginDate;
    private final boolean launch; // false if simply logging in, true if a game is being launched.
    public Log (final int userid, final Date loginDate, final boolean launch){
        this.userid = userid;
        this.loginDate = loginDate;
        this.launch = launch;
    }

    public int getUserid() {
        return userid;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public boolean isLaunch() { return launch; }

}
