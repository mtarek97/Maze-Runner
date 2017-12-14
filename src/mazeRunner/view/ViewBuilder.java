package mazeRunner.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.*;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.MapCellViewFactory;
import mazeRunner.view.mapCellsView.Recources;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class ViewBuilder extends Pane{
    private Recources recources = Recources.getRecources();
    private Pane mapCellLayer = new Pane();
    private GridPane objectsPane = new GridPane();
    private GridPane runnerPane = new GridPane();
    private MapCellView nodeCell;
    private MapCellViewFactory factory;
    private Scene scene;

    public ViewBuilder() {
        runnerPane.setStyle("-fx-background-color: transparent");
        mapCellLayer.getChildren().add(objectsPane);
        mapCellLayer.getChildren().add(runnerPane);
        scene = new Scene(mapCellLayer);
    }

    public void putCellInView(MapCell cell, int row, int column,String imageLink){
        nodeCell = factory.getMapCellView(cell);
        nodeCell.setImage(recources.getImage(imageLink));
        objectsPane.add(nodeCell,column,row);
    }
    public void putRunnerInStartPoint(Character runner,String imageLink){
        MapCellView runnerView = factory.getMapCellView(runner);
        nodeCell.setImage(recources.getImage(imageLink));
        runnerPane.add(runnerView,1,1);
    }
    public Scene getPlayingViewScene(){
        return this.scene;
    }

}

