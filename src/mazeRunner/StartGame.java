package mazeRunner;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.omg.CORBA.portable.ApplicationException;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import mazeRunner.controller.MainController;
import mazeRunner.view.MainMenu;

import static javafx.application.Application.launch;

public class StartGame extends Application {
    private MainController mainController;
    public static Scene scene;
    private Stage window;
    public static VBox root = new VBox();
    public static Pane rootPane;
    public static Pane startMenuePane;
    public StartGame() {
        mainController = MainController.getController();
        rootPane = (Pane) mainController.getMenu().createContent();
        startMenuePane = rootPane;
        root.getChildren().addAll(rootPane);
        scene = new Scene(root);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("MAZE RUNNER");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }
}