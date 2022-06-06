public class User {
    //variables
    private String userName;
    private String password;
    private final int userid;
    private boolean admin;
    private boolean temporarySuspended = false;
    //Constructor
    public User(String userName, String password, boolean admin, int userid){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.userid = userid;
    }

    //getters and setters
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
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
}
