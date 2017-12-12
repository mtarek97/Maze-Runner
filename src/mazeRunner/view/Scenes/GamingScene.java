package mazeRunner.view.Scenes;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Mustafa on 12/11/2017.
 */
public class GamingScene extends BorderPane{

    GridPane pane = new GridPane();
    BorderPane boarderBane = new BorderPane();

    Scene scene = new Scene(boarderBane);

    public GamingScene(Parent root) {
        super(root);
    }
    public GridPane getPan(){
        return  this.pane;
    }
}
