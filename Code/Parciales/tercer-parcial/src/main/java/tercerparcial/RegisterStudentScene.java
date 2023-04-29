package tercerparcial;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RegisterStudentScene {

    private ArrayList <TextField> studentRegisterInputs;

    @FXML
    private Button MainMenu__BtnToCreateAccount;

    @FXML
    private Button RegisterStudents__BtnToFoward;

    @FXML
    private ToggleButton RegisterStudents__BtnToToggleInformation;

    @FXML
    private Button StudentRegister__BtnToClearInputs;

    @FXML
    private TextField StudentRegister__TextFieldForGender;

    @FXML
    private TextField StudentRegister__TextFieldForID;

    @FXML
    private TextField StudentRegister__TextFieldForName;

    @FXML
    private TextField StudentRegister__TextFieldForNotes__Fisica;

    @FXML
    private TextField StudentRegister__TextFieldForNotes__Informatica;

    @FXML
    private TextField StudentRegister__TextFieldForNotes__Quimica;

    @FXML
    private ListView <String> StudentRegister__ListView;

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method to clear all the inputs in the Scene 
     * EventListener > on action 
     */

    @FXML
    void MainMenu__BtnToCreateAccountOnAction(ActionEvent event) {
        try {
            App.setRoot("MainSceneRedesigned");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method to register a new Student
     * EventListener > on action
     */

    @FXML
    void RegisterStudents__BtnToFowardOnAction(ActionEvent event) {
        final Boolean[] dataReadyToSend = { true };

        // * this.ID (length) <= 3
        if (!verifyLength(this.studentRegisterInputs.get(0).getText(), 3)) {
            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El ID debe contener tres o menos caracteres");
            } catch (Exception e) { e.printStackTrace(); }
        }

        // * After all the cases are checked, if all of them are correct, them this block will execute
        if (dataReadyToSend[0]) {
            /*
             * 1) Connects to the database
             * 2) Creates an Student <Object> and the send it as Parameter of the .insertIntoStudents(Student student)
             * 3) Shows a notification
             */

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                
                // * .insertIntoStudents(Student student) > Returns Boolean -> So it can ve used to check if the data were successfully sent send
                if (
                    sqlConnection.insertIntoStudents(new Student(
                        this.studentRegisterInputs.get(0).getText(),
                        this.studentRegisterInputs.get(1).getText(),
                        this.studentRegisterInputs.get(2).getText(),
                        this.studentRegisterInputs.get(3).getText(),
                        this.studentRegisterInputs.get(4).getText(),
                        this.studentRegisterInputs.get(5).getText()
                    ))
                ) {
                    // * Just showing a notificacion && clearing the inputs for asthethics
                    this.showNotification("Datos ingresados correctamente");
                    this.clearInputs();
                }

            } catch (Exception e) { System.out.println(e.getLocalizedMessage()); }
        }
    }

    // * ------------------------------------------------------------------------|>

    // * Method that validates the length of a Given String [...]
    private Boolean verifyLength(String input, Integer maxLength) {
        return ((input.length() <= maxLength) ? true : false);
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Controller of the whole list that shows at the side of the <Form>
     * 
     */

    @FXML
    void RegisterStudents__BtnToToggleInformationOnAction(ActionEvent event) {

        // * All the Strings and Formatted ones will be saved here, so to be added later
        ArrayList <String> allReturnedStrings = new ArrayList <>();

        /*
         * this.ToggleButton has to states
         *      1) .isSelected() : true -> indicates that the Button is active (EventListener)
         *      2) .isSelected() : false -> indicates that the Button isn't active (EventListener)
         */

        if (this.RegisterStudents__BtnToToggleInformation.isSelected()) {

            // * In case of active, it will set the Notification__Container to true -> .setVisible(true)
            this.StudentRegister__ListView.setVisible(true);

            /*
             * Each try-catch block creates a SQLObject and performs a MethodCall
             * The method returns something (Most likely a ArrayList <String>)
             * Inside the try-catch block is done all the Formatting and stuff for the Strings and the Messages
             * Finnaly are added to this allReturnedStrings
             * 
             * Disclaimer: Essentially all the methods that perform the .percentajeByRange() are the same try-catch block
             *          But with some small changes into the MethodArguments (Integer minRange, Integer maxRange)
             * 
             *          It could be done with an ArrayList <Integer> -> Some breakpoints -> Iteration
             *              Maybe, but this way the code is more redeable :D
             * 
             */


            try {

                /*
                 * Object > .averagePerSubjectFormatted() > Iteration (ArrayList).forEach(() -> {}) > Adding to the ArrayList
                 * In this case is to get the averagePerSubject, pack'em into a String, and that's it
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.averagePerSubjectFormatted().forEach((value) -> {
                    allReturnedStrings.add(value);
                });
                
            } catch (Exception e) { e.printStackTrace(); }
            
            // * HorizontalLine in the ListView :D
            allReturnedStrings.add(this.returnString(60));

            try {

                /*
                 * Object > .percentajeByRange(Integer minRange, Integer maxRange) > Iteration (HashMap).forEach(() -> {}) > Adding to the ArrayList
                 * But before adding the element -> hashMap.getKeys().toUpperCase(), Just capitalizing the firstLetter of the String
                 * 
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(90, 100).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [EXCELENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            // * HorizontalLine in the ListView :D
            allReturnedStrings.add(this.returnString(60));

            try {

                /*
                 * Object > .percentajeByRange(Integer minRange, Integer maxRange) > Iteration (HashMap).forEach(() -> {}) > Adding to the ArrayList
                 * But before adding the element -> hashMap.getKeys().toUpperCase(), Just capitalizing the firstLetter of the String
                 * 
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(80, 90).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [SOBRESALIENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            // * HorizontalLine in the ListView :D
            allReturnedStrings.add(this.returnString(60));

            try {

                /*
                 * Object > .percentajeByRange(Integer minRange, Integer maxRange) > Iteration (HashMap).forEach(() -> {}) > Adding to the ArrayList
                 * But before adding the element -> hashMap.getKeys().toUpperCase(), Just capitalizing the firstLetter of the String
                 * 
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(60, 80).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [REGULAR]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            // * HorizontalLine in the ListView :D
            allReturnedStrings.add(this.returnString(60));

            try {

                /*
                 * Object > .percentajeByRange(Integer minRange, Integer maxRange) > Iteration (HashMap).forEach(() -> {}) > Adding to the ArrayList
                 * But before adding the element -> hashMap.getKeys().toUpperCase(), Just capitalizing the firstLetter of the String
                 * 
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(30, 60).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [INSUFICIENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            // * HorizontalLine in the ListView :D
            allReturnedStrings.add(this.returnString(60));

            try {
                /*
                 * Object > .percentajeByRange(Integer minRange, Integer maxRange) > Iteration (HashMap).forEach(() -> {}) > Adding to the ArrayList
                 * But before adding the element -> hashMap.getKeys().toUpperCase(), Just capitalizing the firstLetter of the String
                 * 
                 */

                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(0, 30).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [DEFICIENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            this.StudentRegister__ListView.setItems(FXCollections.observableArrayList(allReturnedStrings));

        } else { this.StudentRegister__ListView.setVisible(false); }
    }

    // * ------------------------------------------------------------------------|>

    // * MiniMethod that returns the HorizontalLine shown in the ListView
    private String returnString(Integer length) {
        String str = "";
        for (Integer i = 0; i < length; i++)
            str += "-";
        return str;
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Iterates all over a ArrayList <TextField> and calls the (TextField).clear() Method
     * This can be done thanks to the this.initialize() Method
     * 
     */

    private void clearInputs() {
        this.studentRegisterInputs.forEach((input) -> {
            input.clear();
        });
    }

    // * ------------------------------------------------------------------------|>

    // * Just calling a Method :S
    @FXML
    void StudentRegister__BtnToClearInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    private void showNotification(String message) {
        /*
         * Getting access to the elements in the Scene, like it would be in JS
         * It is important to make the (Cast) to the respective ObjectType
         * 
         * Disclaimer: All the Methods .showNotification(String message) are essentially the same
         *      This would be done better with an implementation of an interface, cuz the only thing that changes
         *      is the ID of the Element (Even that wasn't necessary, ended up this way to prevent errors)
         */ 

        StackPane notificationPane = (StackPane) App.getScene().lookup("#SignUpStudent__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#SignUpStudent__NotificationShade-Label");
        
        // * Setting the text of the Notification as the Parameter (String message)
        notificationLabel.setText(message);

        // * Changing the visibility of the Nofication__Container
        notificationPane.setVisible(true);

        /*
        * Here is what makes the notification disappear after a while
        * 1) Adds some delay to it 
        * 2) Creating something that will execute after that delay ends
        * 
        * That's what exactly does the new Timeline(new KeyFrame() -> {})
        */

        Duration delay = Duration.seconds(5);
        
        Timeline timeline = new Timeline(new KeyFrame(delay, event -> {
            notificationPane.setVisible(false);
        }));

        timeline.play();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method Called when this Scene shows
     * -> Without the .initialize() all the (TextField) would be null
     *      So, it won't be possible to iterate over them [...]
     * 
     */

    @FXML
    private void initialize() {
        this.studentRegisterInputs = new ArrayList<>(Arrays.asList(
            this.StudentRegister__TextFieldForID,
            this.StudentRegister__TextFieldForName,
            this.StudentRegister__TextFieldForGender,
            this.StudentRegister__TextFieldForNotes__Informatica,
            this.StudentRegister__TextFieldForNotes__Fisica,
            this.StudentRegister__TextFieldForNotes__Quimica
        ));
    }
}
