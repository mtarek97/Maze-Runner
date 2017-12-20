package mazeRunner.controller;

import mazeRunner.model.levels.ILevelFactory;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class PlayingController implements Runnable {
    private IMapBuilder mapBuilder;
    private ILevelFactory levelFactory;
    public static BuildingController buildingController;
    private MovingController movingController;
    public static int score = 0;
    public PlayingController(){
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public void run() {
        int i = 6;
        mapBuilder.setLevel(levelFactory.getLevel(i));
        try {
            buildingController = new BuildingController(mapBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        movingController = new MovingController();
        buildingController.updateSolidWallAndWaysLayerPane();
        updateView();
        movingController.actionHandeling();
        //TODO

    }

    public void updateView(){
        buildingController.updateCellsLayerPane();
        buildingController.updatemovingObjectsLayerPane();
    }
}
