package tercerparcial;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginScene {

    @FXML
    private Button MainMenu__BtnToCleanInputs;

    @FXML
    private Button MainMenu__BtnToCreateAccount;

    @FXML
    private Button MainMenu__BtnToFoward;

    @FXML
    private PasswordField MainMenu__PasswordFieldForPassword;

    @FXML
    private TextField MainMenu__TextFieldUserName;

    private void clearInputs() {
        this.MainMenu__TextFieldUserName.clear();
        this.MainMenu__PasswordFieldForPassword.clear();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method to clear all the inputs in the Scene 
     * EventListener > on action 
     */

    @FXML
    void MainMenu__BtnToCleanInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method that changes the current scene (Redirects the user)
     * EventListener > on action
     */

    @FXML
    void MainMenu__BtnToCreateAccountOnAction(ActionEvent event) {
        try {
            App.setRoot("RegisterTeachers");
        } catch (Exception e) { System.out.format("%s%n", e.getMessage()); }
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
    * This button is the one that will be pressed in order to Login
    * 1) Extract the inputs and compare it with the ones stored in the database
    * 2) If they match [ ... ]
    *
    *   2.1) Before sending and comparing the Passwords, they are Encrypted
    *       using the PasswordEncrypted.encryptHasSHA256(String password)
    */
    
    @FXML
    void MainMenu__BtnToFowardOnAction(ActionEvent event) {
        Teacher teacher = new Teacher(
            this.MainMenu__TextFieldUserName.getText(),
            PasswordEncrypter.encryptHashSHA256(this.MainMenu__PasswordFieldForPassword.getText())
        );
            
        this.clearInputs();

        /*
         * In case of successfully Login, the Scene changes to "RegisterStudents"
         * App.setRoot() Method
         * 
         * In case of failure, it will show a notification
         */

        if (this.tryLogin(teacher)) {
            try {
                App.setRoot("RegisterStudents");
            } catch (Exception e) { e.printStackTrace(); }
        } else {
            try {
                this.showNotification("Error: Nombre de usuario o contraseña incorrecto");
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    // * ------------------------------------------------------------------------|>

    /*
     * TryLogin Method > Return Boolean
     * Connects to the Database, executes a query and compares
     */

    private Boolean tryLogin(Teacher teacher) {
        final Boolean[] isValid = { false };

        // * try-catch method to connects to the database

        try {
            // * SQLOBject with all the parameters
            SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");

            // * Calls a method to execute the search
            ArrayList <Teacher> coincidences = sqlConnection.searchByParam(teacher.getUserName(), teacher.getPassword());

            // * In case of the coincidences are greater than one, it means that the user and password are stored in the database
            if (coincidences.size() >= 1) isValid[0] = true;

        } catch (Exception e) { e.printStackTrace(); }

        return isValid[0];
    }
        
    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method that ShowNotification > Returns void
     * 
     */

    private void showNotification(String message) {
        /*
         * Getting access to the elements in the Scene, like it would be in JS
         * It is important to make the (Cast) to the respective ObjectType
         * 
         * Disclaimer: All the Methods .showNotification(String message) are essentially the same
         *      This would be done better with an implementation of an interface, cuz the only thing that changes
         *      is the ID of the Element (Even that wasn't necessary, ended up this way to prevent errors)
         */ 

        StackPane notificationPane = (StackPane) App.getScene().lookup("#Login__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#Logn__NotificationShade-Label");
        
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

        // * Executes the event
        timeline.play();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>
}
