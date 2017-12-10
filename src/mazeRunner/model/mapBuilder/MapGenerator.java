package mazeRunner.model.mapBuilder;

import mazeRunner.model.mapElement.IElementsGenerator;
import mazeRunner.model.mapElement.MapCell;
import mazeRunner.themes.theme1.Way1;

import java.util.HashMap;

public class MapGenerator {

	private MapCell[][] maze;
	private int[][] fakeMaze;
	private Map map;
	HashMap<MapCell, Integer> mapElementType;

	public MapGenerator(boolean[][] maze, HashMap<MapCell, Integer> getMapElementType) {
		this.mapElementType = getMapElementType;
		this.maze = new MapCell[maze.length][maze[0].length];
		fakeMaze = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j]) {
					this.fakeMaze[i][j] = 1;
				} else
					fakeMaze[i][j] = 0;
			}
		}
	}

	public Map generateMap() {
		for (java.util.Map.Entry<MapCell, Integer> entry : this.mapElementType.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				IElementsGenerator generator = (IElementsGenerator) entry.getKey();
				generator.generate(maze, fakeMaze);
			}
		}
		for (int i = 0; i < fakeMaze.length; i++) {
			for (int j = 0; j < fakeMaze[0].length; j++) {
				if (fakeMaze[i][j] == 0) {
					this.maze[i][j] = new Way1();
				}

			}
		}
		return map;
	}
}