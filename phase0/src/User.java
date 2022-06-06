public class User {
    //variables
    private String userName;
    private String password;
    private final int userid = lastid;
    private boolean admin;
    private boolean temporarySuspended;

    //Constructor
    public User(String userName, String password, boolean admin){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.temporarySuspended = false;
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
    public void banUser(String name) {
        if (this.admin){
            UserManager.banUser(name);
        }
    }
    public void temporarybanUser(String name, int time) {
        if (this.admin){
            UserManager.temporaryBanUser(name, time);
        }
    }
}
