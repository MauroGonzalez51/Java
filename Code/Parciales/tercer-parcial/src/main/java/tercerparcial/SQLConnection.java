package tercerparcial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SQLConnection {

    // ! -----------------------------------------------------------------------------------------------------|>

    /*
     * ClassAttributes
     * 
     * In order to connect to the database
     * 
     */

    private String databaseName;

    private String userName;
    private String password;

    private String host;
    private String databasePort;

    private String driver = "com.mysql.cj.jdbc.Driver";

    private String url;

    Connection connection;

    // ! -----------------------------------------------------------------------------------------------------|>

    /*
     * Constructor
     * 
     * It is required the databaseName, userName, password, host and the port in order to connect
     * That's why all these fields are asked via constructor
     */

    public SQLConnection(String databaseName, String userName, String password, String host, String databasePort) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.databasePort = databasePort;

        /*
         * Formating the url to contain the host:port
         * URL to connecto to the database
         * 
         */

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
    
    public Boolean insertIntoTeachers(Teacher teacher) {
        final Boolean[] success = { false };
        
        String query = "INSERT INTO teacher (username, password) VALUES (?, ?)";

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * --------------------------------------------------------------------|>
            
            statement.setString(1, teacher.getUserName());
            statement.setString(2, teacher.getPassword());

            // * --------------------------------------------------------------------|>

            Integer rowsAfected = statement.executeUpdate();

            if (rowsAfected >= 1) success[0] = true;

            statement.close();
            connection.close();

        } catch (Exception e) { e.printStackTrace(); }

        return success[0];
    }

    public Boolean insertIntoStudents(Student student) {
        final Boolean[] success = { false };

        String query = "INSERT INTO student (ID, name, gender, grades_informatica, grades_fisica, grades_quimica) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * --------------------------------------------------------|> 
            
            statement.setInt(1, student.getID());

            // * --------------------------------------------------------|> 
            
            statement.setString(2, student.getName());
            statement.setString(3, student.getGender());

            // * --------------------------------------------------------|> 
            
            statement.setDouble(4, student.getGradesInformatica());
            statement.setDouble(5, student.getGradesFisica());
            statement.setDouble(6, student.getGradesQuimica());

            // * --------------------------------------------------------|> 

            Integer rowsAfected = statement.executeUpdate();

            if (rowsAfected >= 1) success[0] = true;

            statement.close();
            connection.close();

        } catch (Exception e) { e.printStackTrace(); }

        return success[0];
    }

    // ! -----------------------------------------------------------------------------------------------------|>
    
    public ArrayList <Teacher> searchByParam(String userName, String password) {
        ArrayList <Teacher> resultArrayList = new ArrayList <>();

        String query = "SELECT * FROM teacher WHERE username = ? AND password = ?";

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * ----------------------------------------|>

            statement.setString(1, userName);
            statement.setString(2, password);
            
            // * ----------------------------------------|>

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultArrayList.add(new Teacher(
                    resultSet.getString("username"),
                    resultSet.getString("password")
                ));
            }

            statement.close();
            connection.close();
        } catch (Exception e) { e.printStackTrace(); }

        return resultArrayList;
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    public ArrayList <Teacher> searchByParam(String userName) {
        ArrayList <Teacher> resultArrayList = new ArrayList <>();

        String query = "SELECT * FROM teacher WHERE username = ?";

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * ----------------------------------------|>

            statement.setString(1, userName);
            
            // * ----------------------------------------|>

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultArrayList.add(new Teacher(
                    resultSet.getString("username"),
                    resultSet.getString("password")
                ));
            }

            statement.close();
            connection.close();
        } catch (Exception e) { e.printStackTrace(); }

        return resultArrayList;
    }

    // ! -----------------------------------------------------------------------------------------------------|>
    
    public ArrayList <String> averagePerSubjectFormatted() {
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Informatica", "Fisica", "Quimica"));
        ArrayList<Double> resultAverages = this.averagePerSubject();

        ArrayList<String> formattedResults = new ArrayList<>();
        resultAverages.forEach((average) -> {
            String formattedString = String.format("Asignatura [%s] [PROMEDIO]: %f", subjects.get(resultAverages.indexOf(average)), average);
            formattedResults.add(formattedString);
        });

        return formattedResults;
    }

    // * ------------------------------------------------------------------------------------------|>

    private ArrayList <Double> averagePerSubject() {
        ArrayList <Student> resultArrayList = this.getAllStudentsByQuery("SELECT * FROM student");

        ArrayList <Double> arrayListToReturn = new ArrayList <>(Arrays.asList (0.0, 0.0, 0.0));

        resultArrayList.forEach((student) -> {
            arrayListToReturn.set(0, arrayListToReturn.get(0) + student.getGradesInformatica());
            arrayListToReturn.set(1, arrayListToReturn.get(1) + student.getGradesFisica());
            arrayListToReturn.set(2, arrayListToReturn.get(2) + student.getGradesQuimica());
        });

        arrayListToReturn.forEach((sumatory) -> {
            arrayListToReturn.set(arrayListToReturn.indexOf(sumatory), sumatory / (double) resultArrayList.size());
        });
        
        return arrayListToReturn;
    }
    
    // ! -----------------------------------------------------------------------------------------------------|>

    /*
     * Gets the percentaje of students in a given range of values
     * Takes to Arguments (Integer minRange, Integer maxRange)
     * 
     */

    public HashMap<String, Double> percentajeByRange(Integer minRange, Integer maxRange) {
        /*
         * Creates a new HashMap <String, Double> to store the name of the subject and the percentaje of it
         * 
         */

        HashMap<String, Double> percentajePerSubject = new HashMap<>() {{
            put("informatica", 0.0);
            put("fisica", 0.0);
            put("quimica", 0.0);
        }};
        
        // * Executes a query to get how many students are in the database
        Integer totalSixeOfStudents = this.getAllStudentsByQuery("SELECT * FROM student").size();

        /*
         * Small ternay operator to verify the query
         * If the minRange == 0 => then the lowerRange of the query changes, from '>' to '>='
         * 
         */

        String query = (minRange == 0) ? 
            "SELECT * FROM student WHERE grades_%s >= %d AND grades_%s <= %d":
            "SELECT * FROM student WHERE grades_%s > %d AND grades_%s <= %d";
        
        /*
         * Iterates over all the 'Keys' of (HashMap) percentajePerSubject
         * 
         */
        
        percentajePerSubject.keySet().forEach((subject) -> {
            /*
             * Executes a query forEach(() -> {}) subject in percentajePerSubject
             * Formats the string with the values in each position
             * Stores into a new ArrayList
             * 
             * With the .put() Method adds the value with his respective subject name
             * 
             * Disclaimer: The keys must be unique, when using the .put() Method, if the key already exists
             *      it will be replace with the new pair of value as well
             * 
             */
            ArrayList<Student> totalStudentsInRange = this.getAllStudentsByQuery(String.format(query, subject, minRange, subject, maxRange));
            percentajePerSubject.put(subject, (totalStudentsInRange.size() / (double) totalSixeOfStudents) * 100.0);
        });
    
        return percentajePerSubject;
    }
    
    // ! -----------------------------------------------------------------------------------------------------|>

    /*
     * Connects to the database and executes a query
     * Gets all the request, pack'em into an ArrayList,
     * And returns it
     * 
     */

    private ArrayList <Student> getAllStudentsByQuery(String query) {
        ArrayList <Student> resultArrayList = new ArrayList <>();

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                resultArrayList.add(new Student(
                    resultSet.getInt("ID"),
                    resultSet.getString("name"),
                    resultSet.getString("gender"),
                    resultSet.getDouble("grades_informatica"),
                    resultSet.getDouble("grades_fisica"),
                    resultSet.getDouble("grades_quimica")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return resultArrayList;
    }

    // ! -----------------------------------------------------------------------------------------------------|>
}
