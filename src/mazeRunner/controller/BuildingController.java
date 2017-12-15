package mazeRunner.controller;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Iterator;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder._2DArrayIterator;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class BuildingController {
    //TODO waiting for runner layer from El-Shazly
    private IMapBuilder mapBuilder;

    public BuildingController(IMapBuilder mapBuilder) throws Exception {
        this.mapBuilder = mapBuilder;
    }
    private GameSetting setting = new GameSetting();
    private IRunner runner = setting.getRunner();
    private ViewBuilder viewBuilder = new ViewBuilder();
    private Map map = mapBuilder.getMap();
    private MapSize mapSize = map.getLevel().getMapSize();
    private MapCell[][] mapCells = map.getCellsLayer();
    public void update(){
        Iterator iterator = new _2DArrayIterator(mapCells);
        while (iterator.hasNext()){
            MapCell cell = (MapCell) iterator.next();
            viewBuilder.putCellInView((MapCell) iterator.next(),iterator.rowIndex(),iterator.columnIndex(),cell.getImageLink());
        }
    }
    //TODO waiting for tarek method
    /*public void initiateRunner(){
        viewBuilder.putRunnerInStartPoint(runner,runner.getImageLink);
    }*/
}
