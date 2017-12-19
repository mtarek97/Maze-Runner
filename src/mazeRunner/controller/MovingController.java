package mazeRunner.controller;

import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import mazeRunner.StartGame;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.Recources;

import java.awt.*;

/**
 * Created by Mustafa on 12/12/2017.
 */
public class MovingController {
    private IMapBuilder mapBuilder = MapBuilder.createMapBuilder();
    private Map map;
    private Object[][] movingObjectsLayerArray;
    private MapCell[][] mapCellsArray;
    private MapCellViewFactory viewFactory;
    private MapCell[][] SolidWallAndWaysArray;
    private BuildingController buildingController = PlayingController.buildingController;
    private Recources recources = Recources.getRecources();
    private IRunner runner;
    public MovingController() {
        viewFactory = new MapCellViewFactory();
        this.mapBuilder = mapBuilder;
        map = mapBuilder.getGeneratedMap();
        movingObjectsLayerArray = map.getMovingObjectsLayer();
        mapCellsArray = map.getCellsLayer();
        SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
        runner = map.getRunner();
    }


  //TODO  private RunnerInteractions interactions = new RunnerInteractions(map);
    ViewBuilder playingView = ViewBuilder.getViewBuilder();
    Pane playingPane = playingView.getPlayingPane();//TODO abdelrahman 18/12
    private boolean isNestPositionAWall(Point newPosition){
        int row = newPosition.x;
        int column = newPosition.y;
        if(!(row < 0 || column < 0)) {
            if (SolidWallAndWaysArray[row][column] instanceof Wall || mapCellsArray[row][column] instanceof Wall) {
                return true;
            }
        }
        return false;
    }

    public void actionHandeling(){
        StartGame.rootPane.getChildren().setAll(playingPane);
        StartGame.scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newMapedPosition = new Point(currentMapedPosition.x-1,currentMapedPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    Point newPosition = new Point(currentPosition.x-1,currentPosition.y);
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.UP));
                    runner.moveUp();
                //TODO interactions.update();
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newMapedPosition = new Point(currentMapedPosition.x+1,currentMapedPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    Point newPosition = new Point(currentPosition.x+1,currentPosition.y);
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.DOWN));
                    runner.moveDown();
                //TODO interactions.update();
                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newMapedPosition = new Point(currentMapedPosition.x,currentMapedPosition.y+1);
                if(!isNestPositionAWall(newMapedPosition)) {
                    Point newPosition = new Point(currentPosition.x,currentPosition.y+1);
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.RIGHT));
                    runner.moveRight();
                //TODO interactions.update();
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newMapedPosition = new Point(currentMapedPosition.x,currentMapedPosition.y-1);
                if(!isNestPositionAWall(newMapedPosition)) {
                    Point newPosition = new Point(currentPosition.x,currentPosition.y-1);
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.UP));
                    runner.moveLeft();
                //TODO interactions.update();
                }
            }
            event.consume();
        });
    }
    private ImageView getImageDirection(int newDirection){
        ImageView imageView = recources.getImage(runner.getImageLink());
        for (int i = 1; i < newDirection; i++){
            imageView.setRotate(imageView.getRotate() + 90);
        }
        return imageView;
    }
}
