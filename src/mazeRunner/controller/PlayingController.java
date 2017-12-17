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
    public PlayingController(){
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public void run() {
        int i = 1;
        while (true) {
            //TODO
            mapBuilder.setLevel(levelFactory.getLevel(i));
            buildingController = new BuildingController(mapBuilder);
            buildingController.updateCellsLayerPane();
            buildingController.updatemovingObjectsLayerPane();
            buildingController.updateSolidWallAndWaysLayerPane();

        }
    }
    // building controller, MovingController and RunnerInteractions will be used here together
}
