package mazeRunner.model.mapBuilder;


import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.CellFactory;
import mazeRunner.model.mapCells.MapCell;
import mazeRunner.themes.theme1.Way1;

import java.util.HashMap;
import java.util.logging.Level;

public class MapGenerator {

	private MapCell[][] maze;
	private int[][] fakeMaze;
	private Map map;
	ILevel level;
	java.util.Map<String, Integer> mapElementType;

	public MapGenerator(boolean[][] maze, java.util.Map<String, Integer> map2,ILevel level) {
		this.level = level;
		this.mapElementType = map2;
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
		for (java.util.Map.Entry<String, Integer> entry : this.mapElementType.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				CellFactory factory = new CellFactory();
		//		factory.setClasses(level.getClass());
	//			IElementsGenerator generator = (IElementsGenerator) entry.getKey();
	//TODO			generator.generate(maze, fakeMaze);
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