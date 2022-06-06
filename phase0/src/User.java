public class User {
    //variables
    private String userName;
    private String password;
    private final int userid = lastid;
    //Constructor
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
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
    public void setPassword(String newPassword){
        password = newPassword;
    }
    public void setUserName(String newUserName){
        userName = newUserName;
    }
}
