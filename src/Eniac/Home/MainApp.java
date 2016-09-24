package Eniac.Home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import Eniac.Home.view.SceneNavigator;
import Eniac.Home.view.MainController;
import javafx.stage.StageStyle;

/**
 * Main application that manages the startup procedure of the application.
 * <p>
 * Created by nickd on 9/23/2016.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("EniacHome 2.0"); //Set the title of the stage.
        stage.initStyle(StageStyle.UNDECORATED); //Makes the standard top menu bar is disabled.
        stage.setScene(createScene(loadRootLayout())); //create a the start (main) scene.

        stage.show();
    }

    /*
    Loads the rootLayout fxml layout.
    Sets up the scene switching Eniac.Home.view.SceneNavigator.
    Loads the first scene into the fxml layout.
     */
    private Pane loadRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane rootLayout = (Pane) loader.load(getClass().getResourceAsStream(SceneNavigator.ROOT_LAYOUT));

        MainController mainController = loader.getController();

        SceneNavigator.setMainController(mainController);
        SceneNavigator.loadScene(SceneNavigator.SECURITY);

        return rootLayout;
    }

    //Creates the main application scene.
    private Scene createScene(Pane rootLayout){
        Scene scene = new Scene(rootLayout);

        //scene.getStylesheets().setAll(getClass().getResource("/Eniac/Home/view/Vista.css").toExternalForm());

        return scene;
    }

    public static void main(String[] args) { launch(args);}
}

