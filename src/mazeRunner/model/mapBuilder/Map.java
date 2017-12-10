package mazeRunner.model.mapBuilder;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapElement.IMapCell;

public class Map {

	private IMapCell[][] map;
	private ILevel level;
	
	public ILevel getLevel() {
		return level;
	}
	
	public void setLevel(ILevel level) {
		this.level = level;
	}
	
	public IMapCell[][] getMap() {
		return map;
	}
	
	public void setMap(IMapCell[][] map) {
		this.map = map;
	}
}
