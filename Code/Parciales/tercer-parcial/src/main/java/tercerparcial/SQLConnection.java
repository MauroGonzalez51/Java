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

    /*
     * Method to setup the connection to the database
     * 
     * Using the DriverManager.getConnection();
     */

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
    
    /*
     * Method to insert a new Register into teacher
     * 
     * Takes a @param <Object> Teacher
     * 
     */

    public Boolean insertIntoTeachers(Teacher teacher) {
        final Boolean[] success = { false };
        
        String query = "INSERT INTO teacher (username, password) VALUES (?, ?)";

        try {
            /*
             * Setting the connection, and preparing the statement
             * 
             */
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * --------------------------------------------------------------------|>
            
            statement.setString(1, teacher.getUserName());
            statement.setString(2, teacher.getPassword());

            // * --------------------------------------------------------------------|>

            Integer rowsAfected = statement.executeUpdate();

            /*
             * If rowsAffected >= 1 means that the insert query was successful
             * 
             */

            if (rowsAfected >= 1) success[0] = true;

            statement.close();
            connection.close();

        } catch (Exception e) { e.printStackTrace(); }

        return success[0];
    }

    /*
     * Method to insert a new Register into student
     * 
     * Takes a @param <Object> Student
     * 
     */

    public Boolean insertIntoStudents(Student student) {
        final Boolean[] success = { false };

        String query = "INSERT INTO student (ID, name, gender, grades_informatica, grades_fisica, grades_quimica) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            /*
             * Setting the connection, and preparing the statement
             * 
             */

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

            /*
             * If rowsAffected >= 1 means that the insert query was successful
             * 
             */

            if (rowsAfected >= 1) success[0] = true;

            statement.close();
            connection.close();

        } catch (Exception e) { e.printStackTrace(); }

        return success[0];
    }

    // ! -----------------------------------------------------------------------------------------------------|>
    
    /*
     * Method to validate the Login <Teacher>
     * 
     * Connects to the database and searchs based on two params
     * @param userName <String>, @param password <String>
     * 
     * -> The password in the database are encrypted so before getting the password here, must go to
     * -> Class.PasswordEncrypter.encryptHashSHA256(String password)
     * 
     */

    public ArrayList <Teacher> searchByParam(String userName, String password) {
        ArrayList <Teacher> resultArrayList = new ArrayList <>();

        String query = "SELECT * FROM teacher WHERE username = ? AND password = ?";

        try {
            /*
             * Setting the connection, and preparing the statement
             * 
             */

            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // * ----------------------------------------|>

            statement.setString(1, userName);
            statement.setString(2, password);
            
            // * ----------------------------------------|>

            ResultSet resultSet = statement.executeQuery();

            /*
             * Adding all the coincidences to an arrayList 
             * 
             * 
             */

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

    /*
     * Method to validate the username <Teacher>
     * 
     * OverrittenMethod -> Does the same as this.searchByParam(String username, String password)
     * 
     * Instead this one only searchs based on the username
     * 
     */

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
    
    /*
     * Method to get the AveragesPerSubject with a String.format
     * 
     * Return: "Asignatura [%subject%] [PROMEDIO]: %float%"
     * 
     */

    public ArrayList <String> averagePerSubjectFormatted() {
        /*
         * Creates two template arrayList
         * 
         * 1) Saving all the subject's name
         * 2) Storing the average of that subject (Initialized as empty)
         * 
         */
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Informatica", "Fisica", "Quimica"));
        ArrayList <String> arrayListToReturn = new ArrayList <> ();

        /*
         * forEach(() -> {}) subject it will call the method this.getAverageOfSubject(String query)
         * To get the value ...
         * 
         * Then adding it to the arrayList, just after formatting it
         * 
         */

        subjects.forEach((subject) -> {
            String query = String.format("SELECT AVG(grades_%s) from student", subject.toLowerCase());

            arrayListToReturn.add(String.format("Asignatura [%s] [PROMEDIO]: %.3f", 
                subject,
                this.getAverageOfSubject(query)    
            ));
        });


        return arrayListToReturn;
    }

    // * ------------------------------------------------------------------------------------------|>
    
    /*
     * Method to get the Average (Grades) per subject
     * 
     * Takes a @param query <String>
     * 
     * 
     * -> The query must contain the SQL.AVG(field) in-build function
     */

    private Double getAverageOfSubject(String query) {
        Double averageToReturn = 0.0;

        try {
            Connection connection = this.setConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                averageToReturn = resultSet.getDouble(1);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return averageToReturn;
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
