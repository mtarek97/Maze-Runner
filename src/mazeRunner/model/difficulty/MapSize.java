package mazeRunner.model.difficulty;

public class MapSize {
	private int height;
	private int width;
	
	public MapSize(int height, int width){
		this.height = height;
		this.width = width;
	}
	
	private MapSize mapSize = new MapSize(height, width);
	
	public MapSize getMapSize(){
		return mapSize;
	}
}
