package mazeRunner;

import org.omg.CORBA.portable.ApplicationException;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import mazeRunner.controller.MainController;
import mazeRunner.view.MainMenu;

import static javafx.application.Application.launch;

public class StartGame extends Application {
    private MainController mainController;
    private Scene scene;
    public StartGame() {
        mainController = MainController.getController();
        scene = new Scene(mainController.getMenu().createContent());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MAZE RUNNER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }
}