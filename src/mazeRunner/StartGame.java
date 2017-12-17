package mazeRunner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mazeRunner.controller.MainController;
import mazeRunner.view.MainMenu;

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