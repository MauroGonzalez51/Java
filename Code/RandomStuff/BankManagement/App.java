package Code.RandomStuff.BankManagement;

import Code.RandomStuff.BankManagement.BankAccount;
import Code.RandomStuff.BankManagement.User;

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
