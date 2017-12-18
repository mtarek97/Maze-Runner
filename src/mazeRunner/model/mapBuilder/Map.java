package mazeRunner.model.mapBuilder;
import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.runners.IRunner;

import java.awt.*;
import java.util.ArrayList;

public class Map {

	private MapCell[][] cellsLayer;
	private Object[][] movingObjectsLayer;
	private MapCell[][] solidWallAndWaysLayer;
	private ILevel level;
	private Point endPoint;
	private GameSetting setting = new GameSetting();
	private IRunner runner = setting.getCurrentRunner();
	private ArrayList<Point> correctWay = new ArrayList<>();


	public ILevel getLevel() {
		return level;
	}
	public MapCell[][] getCellsLayer() {
		return cellsLayer;
	}

	public void setSetting(GameSetting setting) {
		this.setting = setting;
	}

	public void setMovingObjectsLayer(Object[][] movingObjectsLayer) {
		this.movingObjectsLayer = movingObjectsLayer;
	}

	public Point getEndPoint() {

		return endPoint;
	}

	public GameSetting getSetting() {

		return setting;
	}

	public MapCell[][] getSolidWallAndWaysLayer() {
		return solidWallAndWaysLayer;
	}
	public Object[][] getMovingObjectsLayer() {
		return movingObjectsLayer;
	}
	public ArrayList<Point> getCorrectWay() {return correctWay;}
	public IRunner getRunner() {
		return runner;
	}
	public void setCellsLayer(MapCell[][] cellsLayer) {
		this.cellsLayer = cellsLayer;
	}
	public void setSolidWallAndWaysLayer(MapCell[][] solidWallAndWaysLayer) {
		this.solidWallAndWaysLayer = solidWallAndWaysLayer;
		this.movingObjectsLayer = new Object[9*solidWallAndWaysLayer.length][9*solidWallAndWaysLayer[0].length];
	}
	public void setLevel(ILevel level) {
		this.level = level;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	public void setCorrectWay(ArrayList<Point> correctWay) {
		this.correctWay = correctWay;
	}
	public void setRunnerInitalPosition(){
		runner.SetPosition(new Point(1,1));
		this.movingObjectsLayer[1][1] = runner;
	}

	public void setRunner(IRunner runner) {
		this.runner = runner;
	}

	public void addCellAtRunTime(MapCell mapcell, int x,int y) {
		cellsLayer[x][y] = mapcell;
	}
}
