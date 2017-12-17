package mazeRunner.controller;

import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Iterator;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder._2DArrayIterator;
import mazeRunner.model.mapCells.*;
import mazeRunner.model.movingObjects.monsters.IMonster;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class BuildingController {

    private IMapBuilder mapBuilder;

    public BuildingController(IMapBuilder mapBuilder) throws Exception {
        this.mapBuilder = mapBuilder;
    }
    private ViewBuilder playingView = ViewBuilder.getViewBuilder();
    private Map map = mapBuilder.getMap();
    private MapCell[][] mapCellsArray = map.getCellsLayer();
    private MapCell[][] SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
    private Object[][] movingObjectsLayerArray = map.getMovingObjectsLayer();
    // cellsLayerPane
    // movingObjectsLayerPane
    // solidWallAndWaysLayerPane
    public void updateSolidWallAndWaysLayerPane(){
        Iterator iterator = new _2DArrayIterator(SolidWallAndWaysArray);
        while (iterator.hasNext()){
            MapCell cell = (MapCell) iterator.next();
            if(cell != null) {
                playingView.putCellInSolidWallAndWaysLayer(getCellName((MapCell) iterator.next()), iterator.rowIndex(),
                        iterator.columnIndex(), cell.getImageLink());
            }
        }
    }

    public void updateCellsLayerPane(){
        Iterator iterator = new _2DArrayIterator(mapCellsArray);
        while (iterator.hasNext()){
            MapCell cell = (MapCell) iterator.next();
            if(cell != null) {
                playingView.putCellInCellsLayer(getCellName((MapCell) iterator.next()), iterator.rowIndex(),
                        iterator.columnIndex(), cell.getImageLink());
            }
        }
    }

    public void updatemovingObjectsLayerPane(){
        Iterator iterator = new _2DArrayIterator(movingObjectsLayerArray);
        while (iterator.hasNext()){
            MapCell cell = (MapCell) iterator.next();
            if(cell != null) {
                playingView.putCellInMovingObjectsLayer(getCellName((MapCell) iterator.next()), iterator.rowIndex(),
                        iterator.columnIndex(), cell.getImageLink());
            }
        }
    }

    private String getCellName(MapCell cell){
        if(cell instanceof Gifts){
            return "Gifts";
        }
        else if(cell instanceof Obstacle){
            return "Obstacle";
        }
        else if(cell instanceof Wall){
            return "wall";
        }
        else if(cell instanceof Way){
            return "Way";
        }
        else if (cell instanceof IRunner){
            return "Runner";
        }
        else if (cell instanceof IMonster){
            return "Monster";
        }
        return null;
    }
}
