package Code.RandomStuff.BankManagement;

public class App {
    public static void main(String[] args) throws Exception {
        User user = new User();
        BankAccount banckObj = new BankAccount(user.getUserName(), user.getUserID());
        try {
            banckObj.mainMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
