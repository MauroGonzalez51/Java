/*
 * Note: In order to connect to the Database hosted in MySQL
 * > MySQL Connector will be required
 * 
 * So ... Maven Repository > SQL-Connector > .jar
 * 
 * Check lib/
 * 
 * 
 * 
 */

package Code.Database.PracticaMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLConnection {
    private String dataBaseName;
    private String userName;
    private String password;
    private String host;
    private Integer dataBasePort;
    
    private String url;

    String driver = "com.mysql.cj.jdbc.Driver";

    Connection connection;

    public SQLConnection(String dataBaseName, String userName, String password, String host, Integer dataBasePort) {
        this.dataBaseName = dataBaseName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.dataBasePort = dataBasePort;

        this.url = String.format("jdbc:mysql://%s:%s/", this.host, this.dataBasePort.toString());
    }

    public Connection setConnection() {
        try {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(this.url + this.dataBaseName, this.userName, this.password);
            System.out.println("Connection successfully");
        } catch (ClassNotFoundException | SQLException e) { 
            System.out.format("Error during connection: %s%n", e.getMessage());
        }

        return this.connection;
    }

    public void insertUsers() {
        String query = "INSERT INTO workers (companyName, NIT, workerName, hoursOfWork, workerAge, baseSalary, totalSalary) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            /*
             * .setString()
             * .setInt()
             * .setDouble()
             * .setBoolean() 
             * 
             */

            statement.setString(1, "CompanyName");
            statement.setString(2, "328975235");
            statement.setString(3, "MauroGonzalez");
            statement.setInt(4, 40);
            statement.setInt(5, 17);
            statement.setDouble(6, 100000.0);
            statement.setDouble(7, 600000.0);

            statement.executeUpdate();

            statement.close();
            
            connection.close();
        } catch (SQLException e) {
            System.out.format("Error during Insertion: %s%n", e.getMessage());
        }
    }
}