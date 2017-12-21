package mazeRunner.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import mazeRunner.model.levels.ILevelFactory;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class PlayingController implements Runnable {
	private final static Logger LOGGER = Logger.getLogger(PlayingController.class.getName());
    private IMapBuilder mapBuilder;
    public static int collectedGift = 0;
    private ILevelFactory levelFactory;
    public static BuildingController buildingController;
    private MovingController movingController;
    public static int ramainingLifes = 3;
    public static int score = 0;
    public PlayingController(){
    	
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public  void run() {
    	LOGGER.setLevel(Level.INFO);
    	LOGGER.info("starting a game story");
        int i = 1;

        mapBuilder.setLevel(levelFactory.getLevel(i));
        try {
            buildingController = new BuildingController(mapBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int x = 0;
        movingController = new MovingController(buildingController);
        buildingController.updateSolidWallAndWaysLayerPane();
        updateView();
        ////
        long lStartTime = System.nanoTime();

        movingController.actionHandeling();
        //TODO

    }

    public void updateView(){
        buildingController.updateCellsLayerPane();
        buildingController.updatemovingObjectsLayerPane();
    }
    public void getSnapShot() {
        SettingController setting = new SettingController();
        //setting.gameSetting.getCurrentRunner() = (IRunner) (GetSnapShot.getRunner());
    }
}
