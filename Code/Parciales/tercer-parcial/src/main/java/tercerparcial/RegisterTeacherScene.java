package tercerparcial;

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


public class RegisterTeacherScene {

    @FXML
    private Button TeacherRegister__BtnToCleanInputs;

    @FXML
    private Button TeacherRegister__BtnToFoward;

    @FXML
    private Button TeacherRegister__BtnToRedirectToLogin;

    @FXML
    private PasswordField TeacherRegister__PasswordFieldForPassword;

    @FXML
    private PasswordField TeacherRegister__PasswordFieldToConfirmPassword;

    @FXML
    private TextField TeacherRegister__TextFieldUserName;

    private void clearInputs() {
        this.TeacherRegister__TextFieldUserName.clear();
        this.TeacherRegister__PasswordFieldForPassword.clear();
        this.TeacherRegister__PasswordFieldToConfirmPassword.clear();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method to clear all the inputs in the Scene
     * EventListener > on action
     */

    @FXML
    void TeacherRegister__BtnToCleanInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * This button is the one that will be pressed in order to 'Register' the Teacher
     * 1) Extracts the info of the (TextField)
     * 2) Checks each case (Validation) 
     * 3) If there's no problem while checking then the info will be send to the database
     * 
     * 
     */

    @FXML
    void TeacherRegister__BtnToFowardOnAction(ActionEvent event) {
        final Boolean[] dataReadyToSend = { true };

        if (!passwordsAreEqual()) {

            /*
             * The field (TextField) for Password and (TextField) for ConfirmPassword
             * must be the same
             * 
             * The method this.passwordsAreEqual() > Returns Boolean
             * Verify this case
             * 
             */

            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: Las contraseñas deben de coincidir");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (!verifyLength(this.TeacherRegister__TextFieldUserName.getText(), 20)) {

            /*
             * The field (TextField) for Username can't be longer than '20' characters
             * 
             * The method this.verifyLength(String string, Integer maxLength) > Returns Boolean
             * Verify this case
             * 
             */

            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El nombre de usuario debe contener 20 o menos caracteres");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (!userNameIsUnique(this.TeacherRegister__TextFieldUserName.getText())) {

            /*
             * The field (TextField) for Username must be unique, it can't already exist in the database
             * 
             * The method this.userNameIsUniqe(String username) > Returns Boolean
             * Verify this case => Executes a query and verifies it
             * 
             */

            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El nombre de usuario ya existe");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (dataReadyToSend[0]) {
            /*
             * In case that the data is ready to send, this block will be executed
             * 
             * 1) Connect to the database
             * 2) Call the method (SQLConnection).insertIntoTeachers(Teacher teacher)
             *      Method in order to insert the info
             *          2.1) Before that the password is Encrypted and after that is send
             * 
             */

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                if (
                    sqlConnection.insertIntoTeachers(new Teacher(
                    this.TeacherRegister__TextFieldUserName.getText(),
                    PasswordEncrypter.encryptHashSHA256(this.TeacherRegister__PasswordFieldForPassword.getText())
                ))) {
                    this.showNotification("Nuevo usuario creado correctamente");
                    this.clearInputs();
                }

            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    // * ------------------------------------------------------------------------|>

    private Boolean passwordsAreEqual() {
        final Boolean[] areEqual = { false };

        /*
         * Gets the text from each (TextField) and compares it with .equals()
         * 
         */

        if (
            PasswordEncrypter.encryptHashSHA256(this.TeacherRegister__PasswordFieldForPassword.getText())
            .equals(
                PasswordEncrypter.encryptHashSHA256(this.TeacherRegister__PasswordFieldToConfirmPassword.getText())
        )) {
            areEqual[0] = true;
        }

        return areEqual[0];
    }

    // * ------------------------------------------------------------------------|>

    private Boolean verifyLength(String input, Integer maxLength) {
        /*
         * Ternary operator to verify the length of a given input
         * 
         */

        return ((input.length() <= maxLength) ? true : false);
    }

    // * ------------------------------------------------------------------------|>

    private Boolean userNameIsUnique(String userName) {
        final Boolean[] isUnique = { true };

        /*
         * 1) Creating a SQLObject
         * 2) Calling the (SQLObject).searchByParam(String username)
         *      If the coindicences are greater than 0 it means that the username
         *      already exists in the database
         * 
         */

        try {
            SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");

            if (sqlConnection.searchByParam(userName).size() > 0) {
                isUnique[0] = false;
            }

        } catch (Exception e) { e.printStackTrace(); }

        return isUnique[0];
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    /*
     * Method that redirects the user to a new scene
     * 
     */

    @FXML
    void TeacherRegister__BtnToRedirectToLoginOnAction(ActionEvent event) {
        try {
            App.setRoot("MainSceneRedesigned");
        } catch (Exception e) { e.printStackTrace(); }
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
        StackPane notificationPane = (StackPane) App.getScene().lookup("#SignUpTeacher__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#SignUpTeacher__NotificationShade-Label");
        
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
}



