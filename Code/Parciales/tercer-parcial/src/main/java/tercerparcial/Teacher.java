package tercerparcial;

/*
 * SkeletonClass for all the Teacher(s)
 * 
 */

public class Teacher {
    /*
     * ClassAttributes ---------------------------------------------------------------|>
     */

    private String userName;
    private String password;

    /*
     * Constructor > Used when creating a new Teacher from the GUI
     * 
     */

    public Teacher(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /*
     * Getters and Setters for the ClassAttributes -------------------------------------------------------------|>
     * 
     */

    public String getUserName() { return this.userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

}
