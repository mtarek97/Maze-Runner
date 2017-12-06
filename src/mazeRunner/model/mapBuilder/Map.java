package mazeRunner.model.mapBuilder;

import mazeRunner.model.difficulty.Difficulty;
import mazeRunner.model.mapElement.MapCell;

public class Map {

	private MapCell[][] map;
	private Difficulty difficulty;
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public MapCell[][] getMap() {
		return map;
	}
	
	public void setMap(MapCell[][] map) {
		this.map = map;
	}
}
