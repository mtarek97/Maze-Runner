package mazeRunner.model.mapBuilder;

import mazeRunner.model.difficulty.Difficulty;

public class MapBuilder implements IMapBuilder{
	
	Difficulty difficulty;
	Map map;
	
	private static MapBuilder builder = new MapBuilder();
	
	public static MapBuilder createMapBuilder(){
		return builder;
	}
	
	@Override
	public Map getMap() {
		//TODO: implement method logic
		MazeGenerator mazeGenerator = new MazeGenerator(difficulty.getSize());
		boolean[][] maze = mazeGenerator.generateMaze();
		MapGenerator mapGenerator = new MapGenerator(maze);
		return mapGenerator.generateMap();
	}
	
	@Override
	public void setDifficulty(Difficulty level) {
		this.difficulty = level;
	}
	
	
}
