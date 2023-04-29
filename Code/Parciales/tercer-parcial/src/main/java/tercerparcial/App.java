package tercerparcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    // * StaticMethod Scene Scene -> Stores the main scene of the application
    private static Scene scene;

    // * StartMethod Overrided from Application > Is launched at the beginning of the program
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainSceneRedesigned"), 1301, 769);
        stage.setScene(scene);
        stage.show();
    }

    // * Method to change the Root of the Application -> Change through the Scenes
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // * Method that loads an FXML file > Changes it to Parent > So it can be added to the current scene
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // * Method that returns the current scene
    public static Scene getScene() {
        return scene;
    }

    // * MainMethod [ ... ]
    public static void main(String[] args) {
        launch();
    }
}