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
    private BuildingController buildingController;
    private MovingController movingController;
    public PlayingController(){
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public void run() {
        int i = 3;

            //TODO
            mapBuilder.setLevel(levelFactory.getLevel(i));
            try {
                buildingController = new BuildingController(mapBuilder);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            movingController = new MovingController();
            buildingController.updateSolidWallAndWaysLayerPane();
                updateView();
                movingController.actionHandeling();

    }

    public void updateView(){
        buildingController.updateCellsLayerPane();
        buildingController.updatemovingObjectsLayerPane();
    }
}
