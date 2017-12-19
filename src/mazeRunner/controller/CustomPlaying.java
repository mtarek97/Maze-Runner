package mazeRunner.controller;

import mazeRunner.model.levels.ILevelFactory;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.MapBuilder;

/**
 * Created by Mustafa on 12/19/2017.
 */
public class CustomPlaying implements Runnable{
    private IMapBuilder mapBuilder;
    private ILevelFactory levelFactory;
    public static BuildingController buildingController;
    private MovingController movingController;
    public CustomPlaying(){
        mapBuilder = MapBuilder.createMapBuilder();
        levelFactory = new ILevelFactory();
    }
    @Override
    public void run() {
        while (true) {
            mapBuilder.setLevel(levelFactory.getLevel(0));
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

    }

    public void updateView(){
        buildingController.updateCellsLayerPane();
        buildingController.updatemovingObjectsLayerPane();
    }
}
