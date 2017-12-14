package mazeRunner.model.mapBuilder;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;

import java.awt.*;

public class Map {

	private MapCell[][] cellsLayer;
	private Object[][] movingObjectsLayer;
	private MapCell[][] solidWallAndWaysLayer;
	private ILevel level;
	private Point endPoint;
	
	public ILevel getLevel() {
		return level;
	}
	public MapCell[][] getCellsLayer() {
		return cellsLayer;
	}
	public MapCell[][] getSolidWallAndWaysLayer() {
		return solidWallAndWaysLayer;
	}
	public Object[][] getMovingObjectsLayer() {
		return movingObjectsLayer;
	}

	public void setCellsLayer(MapCell[][] cellsLayer) {
		this.cellsLayer = cellsLayer;
	}
	public void setSolidWallAndWaysLayer(MapCell[][] solidWallAndWaysLayer) {
		this.solidWallAndWaysLayer = solidWallAndWaysLayer;
		this.movingObjectsLayer = new Object[solidWallAndWaysLayer.length][solidWallAndWaysLayer[0].length];
	}
	public void setLevel(ILevel level) {
		this.level = level;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}


	public void addCellAtRunTime(MapCell mapcell, int x,int y) {
		cellsLayer[x][y] = mapcell;
	}
}
