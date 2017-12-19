package mazeRunner.controller;

import mazeRunner.model.GameSetting;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Iterator;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder._2DArrayIterator;
import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;
import mazeRunner.model.movingObjects.monsters.IMonster;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class BuildingController {

	private GameSetting gameSetting = GameSetting.getGameSetting();
	private IMapBuilder mapBuilder;
	private Map map;
	private ViewBuilder playingView;
	private MapCell[][] mapCellsArray;
	private MapCell[][] SolidWallAndWaysArray;
	private Object[][] movingObjectsLayerArray;

	public BuildingController(IMapBuilder mapBuilder) throws Exception {
		this.mapBuilder = mapBuilder;
		map = mapBuilder.getMap();
		map.setRunner(gameSetting.getCurrentRunner());
		map.getRunner().setSpeed(map.getLevel().getRunnerSpeed());
		playingView = ViewBuilder.getViewBuilder();
		mapCellsArray = map.getCellsLayer();
		SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
		movingObjectsLayerArray = map.getMovingObjectsLayer();
	}

	// cellsLayerPane
	// movingObjectsLayerPane
	// solidWallAndWaysLayerPane
	public void updateSolidWallAndWaysLayerPane() {
		Iterator iterator = new _2DArrayIterator(SolidWallAndWaysArray);
		while (iterator.hasNext()) {
			MapCell cell = (MapCell) iterator.next();
			if (cell != null) {
				playingView.putCellInSolidWallAndWaysLayer(getCellName(cell),
						iterator.rowIndex(), iterator.columnIndex(), cell.getImageLink());
			}
		}
	}

	public void updateCellsLayerPane() {
		Iterator iterator = new _2DArrayIterator(mapCellsArray);
		while (iterator.hasNext()) {
			MapCell cell = (MapCell) iterator.next();
			if (cell != null) {
				playingView.putCellInCellsLayer(getCellName(cell), iterator.rowIndex(), iterator.columnIndex(),
						cell.getImageLink());
			}
		}
	}

	public void updatemovingObjectsLayerPane() {
		Iterator iterator = new _2DArrayIterator(movingObjectsLayerArray);
		while (iterator.hasNext()) {
			IRunner cell = (IRunner) iterator.next();
			if (cell != null) {
				playingView.putCellInMovingObjectsLayer(getCellName(cell), iterator.rowIndex(), iterator.columnIndex(),
						cell.getImageLink());
			}
			else {
				playingView.putCellInMovingObjectsLayer(getCellName(cell), iterator.rowIndex(), iterator.columnIndex());
			}
		}
	}

	private String getCellName(Object cell) {
		if (cell instanceof Gifts) {
			return "Gifts";
		} else if (cell instanceof Obstacle) {
			return "Obstacle";
		} else if (cell instanceof Wall) {
			return "wall";
		} else if (cell instanceof Way) {
			return "Way";
		} else if (cell instanceof IRunner) {
			return "Runner";
		} else if (cell instanceof IMonster) {
			return "Monster";
		}
		return "";
	}
}
