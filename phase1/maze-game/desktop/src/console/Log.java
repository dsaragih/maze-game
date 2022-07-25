package console;
import java.util.Date;

public class Log {
    private int userid;
    private Date loginDate;
    Log (int userid, Date loginDate){
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
