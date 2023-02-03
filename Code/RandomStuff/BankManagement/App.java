package Code.RandomStuff.BankManagement;

import java.util.Scanner;

import Code.RandomStuff.BankManagement.BankAccount;

import Code.RandomStuff.BankManagement.User;

public class App {
    public static void main(String[] args) throws Exception {
        User user = new User();
        BankAccount banckObj = new BankAccount(user.getUserName(), user.getUserID());
        banckObj.mainMenu();
    }
}
