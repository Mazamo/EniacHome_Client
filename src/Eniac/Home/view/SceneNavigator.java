package Eniac.Home.view;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Utility class for controlling naviagtion between scenes
 *
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 *
 * Created by nickd on 9/24/2016.
 */
public class SceneNavigator {

    //Constants that contain the file location off the *.fxml files.
    public static final String ROOT_LAYOUT      = "/Eniac/Home/view/RootLayout.fxml";
    public static final String SECURITY         = "/Eniac/Home/view/SecurityScene.fxml";
    public static final String SENSORS          = "/Eniac/Home/view/SensorScene.fxml";
    public static final String USERS            = "/Eniac/Home/view/UserScene.fxml";

    //The main application layout controller.
    private static MainController mainController;

    //Stores the main controller for later use in navigation tasks.
    public static void setMainController(MainController mainController){
        SceneNavigator.mainController = mainController;
    }

    /*
    sceneHolder pane of the main application layout.

    Previously loaded scenes for the same fxml file are not cached.
    The fxml is loaded anew and a new scene node hierarchy generated
    every time this method is invoked.
     */
    public static void loadScene(String fxml){
        try{
            mainController.setScene(FXMLLoader.load(SceneNavigator.class.getResource(fxml)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
