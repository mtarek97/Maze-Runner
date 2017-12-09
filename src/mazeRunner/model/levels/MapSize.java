package mazeRunner.model.levels;

public class MapSize {
	private int height;
	private int width;
	
	public MapSize(int height, int width){
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}
	public int getWidth() {
		return this.width;
	}

	public MapSize getMapSize(){
		 MapSize mapSize = new MapSize(height, width);
		return mapSize;
	}
}
