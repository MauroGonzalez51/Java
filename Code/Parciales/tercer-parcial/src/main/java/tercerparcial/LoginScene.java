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

    @FXML
    void MainMenu__BtnToCleanInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

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
    */
    
    @FXML
    void MainMenu__BtnToFowardOnAction(ActionEvent event) {
        Teacher teacher = new Teacher(
            this.MainMenu__TextFieldUserName.getText(),
            PasswordEncrypter.encryptHashSHA256(this.MainMenu__PasswordFieldForPassword.getText())
        );
            
        this.clearInputs();

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

    private Boolean tryLogin(Teacher teacher) {
        final Boolean[] isValid = { false };

        try {
            // * The port HERE might be change ----------------------------------------------------|>
            SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");

            ArrayList <Teacher> coincidences = sqlConnection.searchByParam(teacher.getUserName(), teacher.getPassword());

            if (coincidences.size() >= 1) isValid[0] = true;

        } catch (Exception e) { e.printStackTrace(); }

        return isValid[0];
    }
        
    // ! -------------------------------------------------------------------------------------------------------------|>

    private void showNotification(String message) {
        StackPane notificationPane = (StackPane) App.getScene().lookup("#Login__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#Logn__NotificationShade-Label");
        
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
