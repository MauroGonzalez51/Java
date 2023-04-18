package Code.Database.WorkersManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLConnection {
    // ! ClassAttributes ----------|>
    private String databaseName;

    private String userName;
    private String password;

    private String host;
    private String databasePort;

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url;

    Connection connection;

    // ! -----------------------------------------------------------------------------------------------------|>

    public SQLConnection(String databaseName, String userName, String password, String host, String databasePort) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.databasePort = databasePort;

        // * Formating the url to contain the host:port
        this.url = String.format("jdbc:mysql://%s:%s/", this.host, this.databasePort);
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    public Connection setConnection() {
        try {
            Class.forName(this.driver);
            this.connection = DriverManager.getConnection(this.url + this.databaseName, this.userName, this.password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.format("Error during connection: %s%n", e.getMessage());
        }

        return this.connection;
    }
    
    // ! -----------------------------------------------------------------------------------------------------|>
    
    public Boolean insertUsers(ArrayList <Worker> workersToInsert) {
        Boolean toReturn[] = { false };
        String query = "INSERT INTO workers (companyName, NIT, workerName, hoursOfWork, workerAge, baseSalary, totalSalary) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            
            workersToInsert.forEach((worker) -> {
                try {
                    // * --------------------------------------------------------------------|>
                    
                    statement.setString(1, worker.getCompanyName());
                    statement.setString(2, worker.getNIT());
                    statement.setString(3, worker.getWorkerName());

                    // * --------------------------------------------------------------------|>
                    
                    statement.setInt(4, worker.getHoursOfWork());
                    statement.setInt(5, worker.getWorkerAge());
                    
                    // * --------------------------------------------------------------------|>

                    statement.setDouble(6, worker.getBaseSalary());
                    statement.setDouble(7, worker.getTotalSalary());

                    // * --------------------------------------------------------------------|>
                    
                    statement.executeUpdate();
                    statement.close();
                    connection.close();

                    // * --------------------------------------------------------------------|>

                    toReturn[0] = true;

                } catch (SQLException e) { System.out.format("Error during inserting into database: %s%n", e.getMessage()); }
            });
            
        } catch (SQLException e) { System.out.format("Error during inserting into database: %s%n", e.getMessage()); }

        return toReturn[0];
    }

    // ! -----------------------------------------------------------------------------------------------------|>
}
