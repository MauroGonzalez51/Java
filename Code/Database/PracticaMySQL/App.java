package Code.Database.PracticaMySQL;

public class App {
    public static void main(String[] args) {
        SQLConnection sqlConnection = new SQLConnection("javatesting", "root", "", "localhost", 3306);
        sqlConnection.insertUsers();
    }
}
