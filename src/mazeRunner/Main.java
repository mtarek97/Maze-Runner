package mazeRunner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mazeRunner.view.MainMenu;

public class Main extends Application {
    private MainMenu menu = new MainMenu();
    private Scene scene = new Scene(menu.createContent());
    public void setScene(Scene scene){
        this.scene = scene;
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
}