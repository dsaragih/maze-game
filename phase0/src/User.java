public class User {
    //variables
    private String userName;
    private String password;
    private int userid;
    private boolean admin;
    //Constructor
    public User(String userName, String password, boolean admin){
        this.userName = userName;
        this.password = password;
        this.admin = admin;
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
