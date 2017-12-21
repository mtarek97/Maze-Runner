package mazeRunner.controller;

import java.awt.Point;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.MapSize;
import mazeRunner.model.mapBuilder.IMapBuilder;
import mazeRunner.model.mapBuilder.Iterator;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder._2DArrayIterator;
import mazeRunner.model.mapCells.Gate;
import mazeRunner.model.mapCells.Gifts;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.mapCells.Obstacle;
import mazeRunner.model.mapCells.Wall;
import mazeRunner.model.mapCells.Way;
import mazeRunner.model.movingObjects.monsters.IMonster;
import mazeRunner.model.movingObjects.runners.DefaultSpeedState;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.view.ViewBuilder;
import mazeRunner.view.mapCellsView.MapCellView;

/**
 * Created by Mustafa on 12/14/2017.
 */
public class BuildingController {

	private GameSetting gameSetting = GameSetting.getGameSetting();
	private IMapBuilder mapBuilder;
	private Map map;
	private ViewBuilder playingView;
	private MapCellViewFactory viewFactory;
	private MapCell[][] mapCellsArray;
	private MapCell[][] SolidWallAndWaysArray;
	private Object[][] movingObjectsLayerArray;
	private MapCellView[][] mapCellsLayer;
	private MapCellView[][] SolidWallAndWaysLayer;
	private MapCellView[][] movingObjectsLayer;
	private MapSize size;
	public BuildingController(IMapBuilder mapBuilder) throws Exception {
		viewFactory = new MapCellViewFactory();
		this.mapBuilder = mapBuilder;
		map = mapBuilder.getMap();
		gameSetting.getCurrentRunner().setPosition(new Point(3,3));
		map.setRunner(gameSetting.getCurrentRunner());
		DefaultSpeedState defaultSpeedState = new DefaultSpeedState(map.getLevel().getRunnerSpeed());
		defaultSpeedState.setRunnerSpeedState(map.getRunner());
		playingView = ViewBuilder.getViewBuilder();
		mapCellsArray = map.getCellsLayer();
		SolidWallAndWaysArray = map.getSolidWallAndWaysLayer();
		movingObjectsLayerArray = map.getMovingObjectsLayer();
		size = map.getLevel().getMapSize();
		mapCellsLayer = new MapCellView[size.getWidth()+1][size.getHeight()+1];
		SolidWallAndWaysLayer = new MapCellView[size.getWidth()+1][size.getHeight()+1];
		movingObjectsLayer = new MapCellView[(size.getWidth()+1)*3][(size.getHeight()+1)*3];
	}

	// cellsLayerPane
	// movingObjectsLayerPane
	// solidWallAndWaysLayerPane
	public void updateSolidWallAndWaysLayerPane() {
		Iterator iterator = new _2DArrayIterator(SolidWallAndWaysArray);
		while (iterator.hasNext()) {
			MapCell cell = (MapCell) iterator.next();
			if (cell != null) {
				MapCellView node = viewFactory.getMapCellView(getCellName(cell));
				SolidWallAndWaysLayer[iterator.rowIndex()][iterator.columnIndex()] = node;
				playingView.putCellInSolidWallAndWaysLayer(node,
						iterator.rowIndex(), iterator.columnIndex(), cell.getImageLink());
			}
		}
	}

	public void updateCellsLayerPane() {
		Iterator iterator = new _2DArrayIterator(mapCellsArray);
		while (iterator.hasNext()) {
			MapCell cell = (MapCell) iterator.next();
			if (cell != null) {
				MapCellView node = viewFactory.getMapCellView(getCellName(cell));
				mapCellsLayer[iterator.rowIndex()][iterator.columnIndex()] = node;
				playingView.putCellInCellsLayer(node, iterator.rowIndex(), iterator.columnIndex(),
						cell.getImageLink());
			}
		}
	}

	public void updatemovingObjectsLayerPane() {
		Iterator iterator = new _2DArrayIterator(movingObjectsLayerArray);
		while (iterator.hasNext()) {
			IRunner cell = (IRunner) iterator.next();
			if (cell != null) {
				MapCellView node = viewFactory.getMapCellView(getCellName(cell));
				movingObjectsLayer[iterator.rowIndex()][iterator.columnIndex()] = node;
				playingView.putCellInMovingObjectsLayer(node, iterator.rowIndex(), iterator.columnIndex(),
						cell.getImageLinks());
			}
			else {
				MapCellView node = viewFactory.getMapCellView(getCellName(cell));
				movingObjectsLayer[iterator.rowIndex()][iterator.columnIndex()] = node;
				playingView.putCellInMovingObjectsLayer(node, iterator.rowIndex(), iterator.columnIndex());
			}
		}
	}

	public void addToMovingLayer(int row,int column , MapCellView node){
		movingObjectsLayer[row][column] = node;
	}
	public void addToCellsLayer(int row,int column , MapCellView node){
		mapCellsLayer[row][column] = node;
	}

	public void addToSolidWallsLayer(int row,int column , MapCellView node){
		SolidWallAndWaysLayer[row][column] = node;
	}

	public void removeFromMovingLayer(int row, int column){
		MapCellView removedNode = movingObjectsLayer[row][column];
		playingView.removeFromMovingGrid(removedNode);
	}

	public void removeFromCellsLayer(int row, int column){
		MapCellView removedNode = mapCellsLayer[row][column];
		playingView.removeFromCellsGrid(removedNode);
	}

	public void removeFromSolidWallsLayer(int row, int column){
		MapCellView removedNode = SolidWallAndWaysLayer[row][column];
		playingView.removeFromSolidWallsGrid(removedNode);
	}

	private String getCellName(Object cell) {
		if (cell instanceof Gifts) {
			return "Gifts";
		} else if (cell instanceof Obstacle) {
			return "Obstacle";
		} else if (cell instanceof Wall) {
			return "wall";
		} else if (cell instanceof Way) {
			System.out.println("way");
			return "Way";
		} else if (cell instanceof IRunner) {
			return "Runner";
		} else if (cell instanceof IMonster) {
			return "Monster";
		} else if (cell instanceof Gate) {
			System.out.println("gate");
			return "Gate";
		}
		return "";
	}
}
