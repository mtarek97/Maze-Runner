package mazeRunner.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.MapCellViewFactory;
import mazeRunner.view.mapCellsView.Recources;

import javax.swing.text.html.ImageView;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class ViewBuilder extends Pane{
    private Recources recources = Recources.getRecources();
    private Pane map = new Pane();
    private GridPane cellsLayerPane = new GridPane();
    private GridPane movingObjectsLayerPane = new GridPane();
    private GridPane solidWallAndWaysLayerPane = new GridPane();
    private MapCellView nodeCell;
    private MapCellViewFactory factory = new MapCellViewFactory();
    private Scene scene;
    private static ViewBuilder viewBuilder = new ViewBuilder();

    private ViewBuilder() {
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        cellsLayerPane.setStyle("-fx-background-color: transparent");
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        map.getChildren().add(solidWallAndWaysLayerPane);
        map.getChildren().add(cellsLayerPane);
        map.getChildren().add(movingObjectsLayerPane);
        scene = new Scene(map);
    }

    public static ViewBuilder getViewBuilder(){
        return viewBuilder;
    }

    public void putCellInCellsLayer(String cell, int row, int column,String imageLink){
        nodeCell = factory.getMapCellView(cell);
        nodeCell.setImage(recources.getImage(imageLink));
        cellsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(String cell, int row, int column,String imageLink){
        nodeCell = factory.getMapCellView(cell);
        nodeCell.setImage(recources.getImage(imageLink));
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(String cell, int row, int column, javafx.scene.image.ImageView imageView){
        nodeCell = factory.getMapCellView(cell);
        nodeCell.setImage(imageView);
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInSolidWallAndWaysLayer(String cell, int row, int column,String imageLink){
        nodeCell = factory.getMapCellView(cell);
        nodeCell.getChildren().add(recources.getImage(imageLink));
        solidWallAndWaysLayerPane.add(nodeCell,column,row);
    }

    public Pane getPlayingPane(){
        return this.map;
    }
}

