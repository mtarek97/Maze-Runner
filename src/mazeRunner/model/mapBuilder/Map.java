package mazeRunner.model.mapBuilder;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.MovingObject;

import java.awt.*;

public class Map {

	private MapCell[][] cellsLayer;
	private MovingObject[][] movingObjectsLayer;
	private ILevel level;
	private Point endPoint;
	
	public ILevel getLevel() {
		return level;
	}
	
	public void setLevel(ILevel level) {
		this.level = level;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public MapCell[][] getCellsLayer() {
		return cellsLayer;
	}
	
	public void setCellsLayer(MapCell[][] cellsLayer) {
		this.cellsLayer = cellsLayer;
	}
}
