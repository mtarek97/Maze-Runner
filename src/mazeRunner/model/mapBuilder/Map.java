package mazeRunner.model.mapBuilder;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapElement.MapCell;

public class Map {

	private MapCell[][] map;
	private ILevel level;
	
	public ILevel getLevel() {
		return level;
	}
	
	public void setLevel(ILevel level) {
		this.level = level;
	}
	
	public MapCell[][] getMapCellArray() {
		return map;
	}
	
	public void setMap(MapCell[][] map) {
		this.map = map;
	}
}
