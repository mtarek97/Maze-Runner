package mazeRunner.model.mapBuilder;

import mazeRunner.model.mapElement.IElementsGenerator;
import mazeRunner.model.mapElement.IMapCell;
import mazeRunner.model.mapElement.Way;

import java.util.HashMap;

public class MapGenerator {

	private IMapCell[][] maze;
	private Map map;
	HashMap< IMapCell, Integer> mapElementType;
	public MapGenerator(boolean[][] maze, 	HashMap< IMapCell, Integer> getMapElementType) {
		this.mapElementType = getMapElementType;
		this.maze = new IMapCell[maze.length][maze[0].length];
		for(int  i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				if(maze[i][j]) {
				//	maze[i][j] = new Way();
				}
				//else
			//		fakeMaze[i][j] = 0;
			}
		}
	}
	
	public Map generateMap() {
		for ( java.util.Map.Entry<IMapCell, Integer> entry : this.mapElementType.entrySet()) {
			for(int i = 0; i < entry.getValue(); i++) {
				IElementsGenerator generator = (IElementsGenerator) entry.getKey();
				generator.generate(maze);
			}
		}
		return map;
	}
}
