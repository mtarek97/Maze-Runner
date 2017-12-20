package mazeRunner.controller;

import java.awt.Point;
import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mazeRunner.StartGame;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;
import mazeRunner.model.movingObjects.MovingObject;
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
public class MovingController{
    private IMapBuilder mapBuilder = MapBuilder.createMapBuilder();
    private Map map;
    private Object[][] movingObjectsLayerArray;
    private MapCell[][] mapCellsArray;
    private MapCellViewFactory viewFactory;
    private MapCell[][] SolidWallAndWaysArray;
    private BuildingController buildingController = PlayingController.buildingController;
    private Recources recources = Recources.getRecources();
    private RunnerInteractions runnerInteractions;
    private BulletInteractions bulletInteractions;
    private IRunner runner;
    public MovingController() {
        viewFactory = new MapCellViewFactory();
        this.mapBuilder = mapBuilder;
        map = mapBuilder.getGeneratedMap();
        movingObjectsLayerArray = map.getMovingObjectsLayer();
        mapCellsArray = map.getCellsLayer();
        SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
        runner = map.getRunner();
        runnerInteractions = new RunnerInteractions(buildingController, map);
    }


    //TODO  private RunnerInteractions interactions = new RunnerInteractions(map);
    ViewBuilder playingView = ViewBuilder.getViewBuilder();
    ScrollPane playingPane = playingView.getPlayingPane();//TODO abdelrahman 18/12
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

    public  void actionHandeling(){
        StartGame.root.getChildren().setAll(playingPane);
        StartGame.scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.W) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newPosition = new Point(currentPosition.x-1,currentPosition.y);
                Point newMapedPosition = getMapedPosition(newPosition.x,newPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.UP,runner));
                    runner.moveUp();
                    try {
                    	runnerInteractions.update();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else if (event.getCode() == KeyCode.S) {

                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newPosition = new Point(currentPosition.x+1,currentPosition.y);
                Point newMapedPosition = getMapedPosition(newPosition.x,newPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.DOWN,runner));
                    runner.moveDown();
                    try {
                    	runnerInteractions.update();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else if (event.getCode() == KeyCode.D) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newPosition = new Point(currentPosition.x,currentPosition.y+1);
                Point newMapedPosition = getMapedPosition(newPosition.x,newPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.RIGHT,runner));
                    runner.moveRight();
                    try {
                    	runnerInteractions.update();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            } else if (event.getCode() == KeyCode.A) {
                Point currentMapedPosition = runner.getMappedPosition();
                Point currentPosition = runner.getPosition();
                Point newPosition = new Point(currentPosition.x,currentPosition.y-1);
                Point newMapedPosition = getMapedPosition(newPosition.x,newPosition.y);
                if(!isNestPositionAWall(newMapedPosition)) {
                    movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                    movingObjectsLayerArray[newPosition.x][newPosition.y] = runner;
                    buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                    MapCellView runnerView = viewFactory.getMapCellView("runner");
                    buildingController.addToMovingLayer(newPosition.x,newPosition.y,runnerView);
                    playingView.putCellInMovingObjectsLayer(runnerView,newPosition.x,newPosition.y,getImageDirection(GameContract.Direction.LEFT,runner));
                    runner.moveLeft();
                    try {
                    	runnerInteractions.update();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(event.getCode() == KeyCode.SPACE) {
                Service<Void> service = new Service<Void>() {
                    @Override
                    protected Task<Void> createTask() {
                        return new Task<Void>() {
                            @Override
                            protected Void call() throws Exception {
                                //Background work
                                final CountDownLatch latch = new CountDownLatch(1);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try{
                                            Bullet bullet = new Bullet();
                                            System.out.println("he is in");
                                            bullet.setDirection(runner.getDirection());
                                            bullet.setMappedPosition(runner.getMappedPosition());
                                            bullet.setPosition(runner.getPosition());

                                            Point currentPosition = bullet.getPosition();
                                            Point currentMapedPosition = bullet.getMappedPosition();
                                            Point newPosition = changePosition(bullet.getDirection(), currentPosition);
                                            Point newMapedPosition = getMapedPosition(newPosition.x, newPosition.y);
                                            while (isCellAllowedForBullets(newMapedPosition)) {
                                                System.out.println("he is in while");
                                                newPosition = changePosition(bullet.getDirection(), currentPosition);
                                                movingObjectsLayerArray[currentPosition.x][currentPosition.y] = null;
                                                movingObjectsLayerArray[newPosition.x][newPosition.y] = bullet;
                                                buildingController.removeFromMovingLayer(currentPosition.x,currentPosition.y);
                                                MapCellView bulletView = viewFactory.getMapCellView("bullet");
                                                buildingController.addToMovingLayer(newPosition.x,newPosition.y,bulletView);
                                                playingView.putCellInMovingObjectsLayer(bulletView,newPosition.x,newPosition.y,getImageDirection(bullet.getDirection(),bullet));
                                                bullet.moveInTheSameDirection();
                                                currentPosition = newPosition;
                                                newMapedPosition = getMapedPosition(newPosition.x, newPosition.y);
                                                System.out.println("count me");
                                            }
                                            bulletInteractions = new BulletInteractions(buildingController, map, bullet);
                                            bulletInteractions.update();

                                        }finally{
                                            latch.countDown();
                                        }
                                    }
                                });
                                latch.await();
                                //Keep with the background work
                                return null;
                            }
                        };
                    }
                };
                service.start();

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

            newPosition = new Point(oldPoint.x, oldPoint.y - 1);
        }
        else if(direction == GameContract.Direction.RIGHT) {

            newPosition = new Point(oldPoint.x , oldPoint.y + 1);
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

            if (SolidWallAndWaysArray[row][column] instanceof Way) {
                return true;
            }

        }
        return false;
    }
    private ImageView getImageDirection(int newDirection,MovingObject movingObject ){
        ImageView imageView = recources.getImage(movingObject.getImageLinks());
        for (int i = 1; i < newDirection; i++){
            imageView.setRotate(imageView.getRotate() + 90);
        }
        return imageView;
    }
    private Point getMapedPosition(int row, int column){
        int mapedRow = row / 3;
        int mapedColumn = column / 3;
        Point mapedPosition = new Point();
        mapedPosition.setLocation(mapedRow,mapedColumn);
        return mapedPosition;
    }
}