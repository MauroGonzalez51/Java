package Code.Database.WorkersManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

    public ArrayList <Worker> searchByParam(Integer IDToSearch) {
        ArrayList <Worker> resultArrayList = new ArrayList <>();

        String query = "SELECT * FROM workers WHERE ID = ?";

        try {
            Connection connection = this.setConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, IDToSearch);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultArrayList.add(new Worker(
                    // * -----------------------------------------------------|>

                    resultSet.getString("companyName"),
                    resultSet.getString("NIT"),
                    resultSet.getString("workerName"),
                    
                    // * -----------------------------------------------------|>

                    resultSet.getInt("hoursOfWork"),
                    resultSet.getInt("workerAge"),
                    
                    // * -----------------------------------------------------|>

                    resultSet.getDouble("baseSalary"),
                    resultSet.getDouble("totalSalary"),
                    
                    // * -----------------------------------------------------|>
                    
                    resultSet.getInt("ID")

                    // * -----------------------------------------------------|>
                ));
            }

        } catch (SQLException e) { System.out.format("Error during getting the Info: %s%n", e.getMessage()); }

        return resultArrayList;
    }

    public HashMap <Boolean, Integer> updateInDatabase(Integer IDToModify, Worker worker) {
        HashMap <Boolean, Integer> resultHashMap = new HashMap <>();

        String query = "UPDATE workers SET companyName = ?, NIT = ?, workerName = ?, hoursOfWork = ?, workerAge = ?, baseSalary = ?, totalSalary = ? WHERE ID = ?";

        try {
            Connection connection = this.setConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            // * -----------------------------------------------------|>
            
            statement.setString(1, worker.getCompanyName());
            statement.setString(2, worker.getNIT());
            statement.setString(3, worker.getWorkerName());
            
            // * -----------------------------------------------------|>
            
            statement.setInt(4, worker.getHoursOfWork());
            statement.setInt(5, worker.getWorkerAge());
            
            // * -----------------------------------------------------|>
            
            statement.setDouble(6, worker.getBaseSalary());
            statement.setDouble(7, worker.getTotalSalary());

            // * -----------------------------------------------------|>
            
            statement.setInt(8, IDToModify);
            
            // * -----------------------------------------------------|>
            
            Integer rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0)
                resultHashMap.put(true, rowsUpdated);
            
            // * -----------------------------------------------------|>
            
            App.logFile(String.format("Updating values in database [ ROWS: %d ]", rowsUpdated));

            // * -----------------------------------------------------|>
        } catch (SQLException e) { System.out.format("Error during updating values: %s%n"); }
        
        return resultHashMap;
    }
    
    public Boolean deleteInDatabase(Integer idToDelete) {
        final Boolean[] toReturn = { false };
        
        String query = "DELETE FROM workers WHERE ID = ?";
        
        try {
            // * -----------------------------------------------------|>

            Connection connection = this.setConnection();
            
            PreparedStatement statement = connection.prepareStatement(query);

            // * -----------------------------------------------------|>
            
            statement.setInt(1, idToDelete);
            
            Integer rowsUpdated = statement.executeUpdate();
            
            if (rowsUpdated > 0)
            toReturn[0] = true;
            
            // * -----------------------------------------------------|>

        } catch (SQLException e) { System.out.format("Error during deleting values: %s%n", e.getMessage()); }

        return toReturn[0];
    }
}
