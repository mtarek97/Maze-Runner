package mazeRunner.controller;

import java.awt.Point;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import mazeRunner.StartGame;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.model.mapCells.CheckPoint;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;
import mazeRunner.model.movingObjects.projectiles.Bullet;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.utilities.GameContract;
import mazeRunner.view.ViewBuilder;
import mazeRunner.view.mapCellsView.MapCellView;
import mazeRunner.view.mapCellsView.Recources;

/**
 * Created by Mustafa on 12/12/2017.
 * modified by Shazly on 19/12/2017.
 */
public class MovingController implements Runnable {
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
            else if(event.getCode() == KeyCode.SPACE) {

                new Thread(this, "Buller Thread").start();
                new Thread(
                        new Runnable() {
                            @Override
							public void run() {

                                Bullet bullet = new Bullet();

                                bullet.setDirection(runner.getDirection());
                                bullet.setMappedPosition(runner.getMappedPosition());
                                bullet.setPosition(runner.getPosition());

                                Point currentPosition = bullet.getPosition();
                                Point currentMapedPosition = bullet.getMappedPosition();
                                Point newMapedPosition = changePosition(bullet.getDirection(), currentMapedPosition);

                                while (isCellAllowedForBullets(newMapedPosition)) {

                                    Point newPosition = changePosition(bullet.getDirection(), currentPosition);
                                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                                    movingObjectsLayerArray[newPosition.x][newPosition.y] = bullet;
                                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                                    MapCellView runnerView = viewFactory.getMapCellView("bullet");
                                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.UP));
                                    bullet.moveInTheSameDirection();
                                    newMapedPosition = changePosition(bullet.getDirection(), newMapedPosition);

                                }

                            }
                        }
                ).start();
            }

            event.consume();
        });
    }
    public Point changePosition(int direction, Point oldPoint) {
        Point newPosition ;
        if(direction == GameContract.Direction.UP) {

            newPosition = new Point(oldPoint.x - 1, oldPoint.y);
        }
        else if(direction == GameContract.Direction.DOWN) {

            newPosition = new Point(oldPoint.x + 1, oldPoint.y);
        }
        else if(direction == GameContract.Direction.LEFT) {

            newPosition = new Point(oldPoint.x, oldPoint.y + 1);
        }
        else if(direction == GameContract.Direction.RIGHT) {

            newPosition = new Point(oldPoint.x + 1, oldPoint.y - 1);
        }
        else {
            newPosition = new Point(oldPoint.x, oldPoint.y);
        }

        return newPosition;
    }
    public boolean isCellAllowedForBullets(Point newPosition ) {
        int row = newPosition.x;
        int column = newPosition.y;
        if((row >= 0&& column >= 0&& row < SolidWallAndWaysArray.length&& column < SolidWallAndWaysArray[0].length)) {

            if (SolidWallAndWaysArray[row][column] instanceof Way && mapCellsArray[row][column] instanceof CheckPoint) {
                return true;
            }

            if (SolidWallAndWaysArray[row][column] instanceof Way && mapCellsArray[row][column] instanceof Way) {
                return true;
            }
        }
        return false;
    }
    private ImageView getImageDirection(int newDirection){
        ImageView imageView = recources.getImage(runner.getImageLinks());
        for (int i = 1; i < newDirection; i++){
            imageView.setRotate(imageView.getRotate() + 90);
        }
        return imageView;
    }

    @Override
    public void run() {

    }
}
