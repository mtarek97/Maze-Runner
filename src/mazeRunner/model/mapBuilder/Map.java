package mazeRunner.model.mapBuilder;
import java.awt.Point;
import java.util.ArrayList;

import mazeRunner.model.GameSetting;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.runners.IRunner;

public class Map {

	private MapCell[][] cellsLayer;
	private Object[][] movingObjectsLayer;
	private MapCell[][] solidWallAndWaysLayer;
	private ILevel level;
	private Point endPoint;
	private IRunner runner = GameSetting.getGameSetting().getCurrentRunner();
	private ArrayList<Point> correctWay = new ArrayList<>();


	public ILevel getLevel() {
		return level;
	}
	public MapCell[][] getCellsLayer() {
		return cellsLayer;
	}

	public void setMovingObjectsLayer(Object[][] movingObjectsLayer) {
		this.movingObjectsLayer = movingObjectsLayer;
	}

	public Point getEndPoint() {

		return endPoint;
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
		this.movingObjectsLayer = new Object[3*solidWallAndWaysLayer.length][3*solidWallAndWaysLayer[0].length];
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
		runner.setPosition(new Point(1,1));
		this.movingObjectsLayer[3][3] = runner;
	}

	public void setRunner(IRunner runner) {
		this.runner = runner;
	}

	public void addCellAtRunTime(MapCell mapcell, int x,int y) {
		cellsLayer[x][y] = mapcell;
	}
}
