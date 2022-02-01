public class User {
    String username;
    String password;
    String userType;

    public User(String uname, String pword, String utype)
    {
        String username = uname;
        String password = pword;
        String userType = utype;
    }
    public void setUsername(String uName){
        username = uName;
    }
    public void setPassword(String uPassword){
        password = uPassword;
    }

    public String getUName(){
        return username;
    }
    public String getUPassword(){
        return password;
    }
    public void printInfo(){
        System.out.println("UsserName =" + username +"\nPassWord =" + password + "\nUserType =" + userType);
    }
}
