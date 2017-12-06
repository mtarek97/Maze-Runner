package mazeRunner.model.mapBuilder;

import mazeRunner.model.difficulty.MapSize;

public class MazeGenerator {

	private boolean[][] maze;
	MapSize size;
	
	public MazeGenerator(MapSize size){
		this.size = size;
	}
	
	public boolean[][] generateMaze() {
		
		return maze;
	}
	
	
}
