package mazeRunner.controller;

import java.awt.Point;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import mazeRunner.StartGame;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder.MapBuilder;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.movingObjects.MovingObject;
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
    private BuildingController buildingController;
    private Recources recources = Recources.getRecources();
    private RunnerInteractions runnerInteractions;
    private BulletInteractions bulletInteractions;
    private IRunner runner;
    public MovingController(BuildingController buildingController) {
    	
    	this.buildingController = buildingController;
        viewFactory = new MapCellViewFactory();
        this.mapBuilder = mapBuilder;
        map = mapBuilder.getGeneratedMap();
        movingObjectsLayerArray = map.getMovingObjectsLayer();
        mapCellsArray = map.getCellsLayer();
        SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
        runner = map.getRunner();
        runnerInteractions = new RunnerInteractions(buildingController, map);
        playingPane = playingView.getPlayingPane(
        		this.runner.getCurrentWeapon().getBulletsCount(),
        		this.runner.getCurrentWeapon().getImageLink());
    }


    ViewBuilder playingView = ViewBuilder.getViewBuilder();
    BorderPane playingPane ;
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
    	 playingPane = playingView.getPlayingPane(
         		this.runner.getCurrentWeapon().getBulletsCount(),
         		this.runner.getCurrentWeapon().getImageLink());
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
            else if (event.getCode() == KeyCode.J) {
               runner.setCurrentWeapon(runner.getPrevWeapon());
                
            }else if (event.getCode() == KeyCode.K) {
                runner.setCurrentWeapon(runner.getNextWeapon());
                
             }
            else if(event.getCode() == KeyCode.SPACE) {
            	if(/*runner.getCurrentWeapon().getBulletsCount() > 0*/ true) {
            		runner.getCurrentWeapon().shoot();
											System.out.println("pressed space");
											System.out.println(this.map.getRunner().getPosition()+" M: "+this.map.getRunner().getMappedPosition());
												runner.getCurrentWeapon().shoot();
											
											    Point newMapedPosition = runner.getMappedPosition();
											    
											    while (isCellAllowedForBullets(newMapedPosition)) {
											        newMapedPosition = changePosition(runner.getDirection(), newMapedPosition);
											    }
											    MapCell[][] mc= this.map.getCellsLayer();
											    mc[newMapedPosition.x][newMapedPosition.y]=null;
											    this.map.setCellsLayer(mc);
												buildingController.removeFromCellsLayer(newMapedPosition.x, newMapedPosition.y);

            	}
										
                                 
         

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
        if((row > 0&& column > 0&& row < SolidWallAndWaysArray.length-1&& column < SolidWallAndWaysArray[0].length-1)) {

            if (SolidWallAndWaysArray[row][column].isWay()&&mapCellsArray[row][column]==null) {
                return true; 
            }

        }
        System.out.println("hit pos"+row + " "+ column);
        return false;
    }
    private ImageView getImageDirection(int newDirection,MovingObject movingObject ){
        ImageView imageView = recources.getImage(movingObject.getImageLinks());
        for (int i = 1; i < newDirection; i++){
            imageView.setRotate(imageView.getRotate() + 90);
        }
        return imageView;
    }
    public Point getMapedPosition(int x , int y) {
		Point smallpos = new Point(1,1);
		
		smallpos.setLocation(Math.floor(x/3),Math.floor(y/3));
		
		return smallpos;

}
}