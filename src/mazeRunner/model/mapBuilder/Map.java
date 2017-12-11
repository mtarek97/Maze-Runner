package mazeRunner.model.mapBuilder;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.model.movingObjects.MovingObject;

public class Map {

	private MapCell[][] cellsLayer;
	private MovingObject[][] movingObjectsLayer;
	private ILevel level;
	
	public ILevel getLevel() {
		return level;
	}
	
	public void setLevel(ILevel level) {
		this.level = level;
	}
	
	public MapCell[][] getCellsLayer() {
		return cellsLayer;
	}
	
	public void setCellsLayer(MapCell[][] cellsLayer) {
		this.cellsLayer = cellsLayer;
	}
}
