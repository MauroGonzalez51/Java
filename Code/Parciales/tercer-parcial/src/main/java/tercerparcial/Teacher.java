package tercerparcial;

public class Teacher {
    private String userName;
    private String password;

    public Teacher(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() { return this.userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

}
