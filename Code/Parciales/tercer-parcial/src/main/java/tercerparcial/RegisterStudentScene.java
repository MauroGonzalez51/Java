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

    @FXML
    void MainMenu__BtnToCreateAccountOnAction(ActionEvent event) {
        try {
            App.setRoot("MainSceneRedesigned");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    @FXML
    void RegisterStudents__BtnToFowardOnAction(ActionEvent event) {
        final Boolean[] dataReadyToSend = { true };

        if (!verifyLength(this.studentRegisterInputs.get(0).getText(), 3)) {
            dataReadyToSend[0] = false;
            try {
                this.showNotification("Error: El ID debe contener tres o menos caracteres");
            } catch (Exception e) { e.printStackTrace(); }
        }

        if (dataReadyToSend[0]) {
            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
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
                    this.showNotification("Datos ingresados correctamente");
                    this.clearInputs();
                }

            } catch (Exception e) { System.out.println(e.getLocalizedMessage()); }
        }
    }

    // * ------------------------------------------------------------------------|>

    private Boolean verifyLength(String input, Integer maxLength) {
        return ((input.length() <= maxLength) ? true : false);
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    @FXML
    void RegisterStudents__BtnToToggleInformationOnAction(ActionEvent event) {
        ArrayList <String> allReturnedStrings = new ArrayList <>();

        if (this.RegisterStudents__BtnToToggleInformation.isSelected()) {
            this.StudentRegister__ListView.setVisible(true);

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.averagePerSubjectFormatted().forEach((value) -> {
                    allReturnedStrings.add(value);
                });
                
            } catch (Exception e) { e.printStackTrace(); }
            
            allReturnedStrings.add(this.returnString(60));

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(90, 100).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [EXCELENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            allReturnedStrings.add(this.returnString(60));

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(80, 90).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [SOBRESALIENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            allReturnedStrings.add(this.returnString(60));

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(60, 80).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [REGULAR]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            allReturnedStrings.add(this.returnString(60));

            try {
                SQLConnection sqlConnection = new SQLConnection("tercerparcial", "root", "", "localhost", "3306");
                sqlConnection.percentajeByRange(30, 60).forEach((subject, percentaje) -> {
                    allReturnedStrings.add(String.format("%s [INSUFICIENTE]: %s", 
                        subject.toUpperCase().charAt(0) + subject.substring(1, subject.length()), 
                        percentaje.toString() + "%"));
                });

            } catch (Exception e) { e.printStackTrace();}

            allReturnedStrings.add(this.returnString(60));

            try {
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

    private String returnString(Integer length) {
        String str = "";
        for (Integer i = 0; i < length; i++)
            str += "-";
        return str;
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    private void clearInputs() {
        this.studentRegisterInputs.forEach((input) -> {
            input.clear();
        });
    }

    // * ------------------------------------------------------------------------|>

    @FXML
    void StudentRegister__BtnToClearInputsOnAction(ActionEvent event) {
        this.clearInputs();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

    private void showNotification(String message) {
        StackPane notificationPane = (StackPane) App.getScene().lookup("#SignUpStudent__NotificationShade-Container");
        Label notificationLabel = (Label) App.getScene().lookup("#SignUpStudent__NotificationShade-Label");
        
        notificationLabel.setText(message);

        notificationPane.setVisible(true);

        Duration delay = Duration.seconds(5);

        Timeline timeline = new Timeline(new KeyFrame(delay, event -> {
            notificationPane.setVisible(false);
        }));

        timeline.play();
    }

    // ! -------------------------------------------------------------------------------------------------------------|>

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
