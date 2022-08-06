package console.entities;
import java.util.Date;

public class Log {
    private int userid;
    private Date loginDate;
    public Log (int userid, Date loginDate){
        this.userid = userid;
        this.loginDate = loginDate;
    }

    public int getUserid() {
        return userid;
    }

    public Date getLoginDate() {
        return loginDate;
    }
}
