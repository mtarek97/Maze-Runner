package mazeRunner.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.Recources;

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
    private Scene scene;
    private static ViewBuilder viewBuilder = new ViewBuilder();

    private ViewBuilder() {
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        cellsLayerPane.setStyle("-fx-background-color: transparent");
        movingObjectsLayerPane.setStyle("-fx-background-color: transparent");
        movingObjectsLayerPane.setGridLinesVisible(true);
        map.getChildren().add(solidWallAndWaysLayerPane);
        map.getChildren().add(cellsLayerPane);
        map.getChildren().add(movingObjectsLayerPane);
        scene = new Scene(map);
    }

    public static ViewBuilder getViewBuilder(){
        return viewBuilder;
    }

    public void putCellInCellsLayer(MapCellView nodeCell, int row, int column,String imageLink){
        nodeCell.setImage(recources.getImage(imageLink));
        cellsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column,String imageLink){ // TODO
        nodeCell.setImage(recources.getImage(imageLink));
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void moveObject(MapCellView nodeCell, int row, int column,String imageLink){ // TODO
        nodeCell.setImage(recources.getImage(imageLink));
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column, javafx.scene.image.ImageView imageView){ // TODO
        nodeCell.setImage(imageView);
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInMovingObjectsLayer(MapCellView nodeCell, int row, int column){ //TODO
        movingObjectsLayerPane.add(nodeCell,column,row);
    }

    public void putCellInSolidWallAndWaysLayer(MapCellView nodeCell, int row, int column,String imageLink){
        nodeCell.getChildren().add(recources.getImage(imageLink));
        solidWallAndWaysLayerPane.add(nodeCell,column,row);
    }

    public void removeFromMovingGrid(MapCellView node){
        movingObjectsLayerPane.getChildren().remove(node);
    }
    public void removeFromCellsGrid(MapCellView node){
        cellsLayerPane.getChildren().remove(node);
    }
    public void removeFromSolidWallsGrid(MapCellView node){
        solidWallAndWaysLayerPane.getChildren().remove(node);
    }

    public Pane getPlayingPane(){
        return this.map;
    }
}

