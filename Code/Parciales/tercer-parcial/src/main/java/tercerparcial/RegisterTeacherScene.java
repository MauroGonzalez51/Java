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

    @FXML
    void TeacherRegister__BtnToCleanInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    @FXML
    void TeacherRegister__BtnToFowardOnAction(ActionEvent event) {
        final Boolean[] dataReadyToSend = { true };

        if (!passwordsAreEqual()) {
            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: Las contraseñas deben de coincidir");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (!verifyLength(this.TeacherRegister__TextFieldUserName.getText(), 20)) {
            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El nombre de usuario debe contener 20 o menos caracteres");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (!userNameIsUnique(this.TeacherRegister__TextFieldUserName.getText())) {
            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El nombre de usuario ya existe");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (dataReadyToSend[0]) {
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
        return ((input.length() <= maxLength) ? true : false);
    }

    // * ------------------------------------------------------------------------|>

    private Boolean userNameIsUnique(String userName) {
        final Boolean[] isUnique = { true };

        try {
            SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");

            if (sqlConnection.searchByParam(userName).size() > 0) {
                isUnique[0] = false;
            }

        } catch (Exception e) { e.printStackTrace(); }

        return isUnique[0];
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    @FXML
    void TeacherRegister__BtnToRedirectToLoginOnAction(ActionEvent event) {
        try {
            App.setRoot("MainSceneRedesigned");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    private void showNotification(String message) {
        StackPane notificationPane = (StackPane) App.getScene().lookup("#SignUpTeacher__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#SignUpTeacher__NotificationShade-Label");
        
        notificationLabel.setText(message);

        notificationPane.setVisible(true);

        Duration delay = Duration.seconds(5);

        Timeline timeline = new Timeline(new KeyFrame(delay, event -> {
            notificationPane.setVisible(false);
        }));

        timeline.play();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>
}



