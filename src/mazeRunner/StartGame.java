package mazeRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mazeRunner.controller.MainController;

public class StartGame extends Application {
	private final static Logger LOGGER = Logger.getLogger(StartGame.class.getName());
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
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("starting game");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }
}