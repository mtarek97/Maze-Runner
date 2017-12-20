package mazeRunner.model.mapBuilder;

import java.util.HashMap;

import mazeRunner.model.levels.ILevel;
import mazeRunner.model.mapCells.MapCell;

public class MapBuilder implements IMapBuilder{
	
	ILevel level;
	Map map = new Map();
	HashMap<MapCell, Integer> mapElementsType;
	private static MapBuilder builder = new MapBuilder();
	public static MapBuilder createMapBuilder() {
		return builder;
	}
	
	@Override
	public Map getMap() throws Exception {
		MazeGenerator mazeGenerator = new MazeGenerator(level.getMapSize());
		boolean[][] maze = mazeGenerator.generateMaze();
		for(int i =0; i < maze.length; i++){
		    for (int j = 0; j < maze[0].length; j++){
		        System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
		GetEndPoint end = new GetEndPoint(maze);
		map.setLevel(level);
		map.setBooleanMaze(maze);
		map.setEndPoint(end.getEnd());
		map.setCorrectWay(end.getCorrectWay());
		MapGenerator mapGenerator = new MapGenerator( map);
		map = mapGenerator.generateMap();
		map.setRunnerInitalPosition();
		return map;
	}

	@Override
	public void setLevel(ILevel level) {
		this.level = level;
	}
	@Override
	public Map getGeneratedMap(){
		return map;
	}



}
