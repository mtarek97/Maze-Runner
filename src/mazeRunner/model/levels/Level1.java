package mazeRunner.model.levels;

public class Level1 extends Level{

	public Level1(){
		this.mapSize = new MapSize(30, 30);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = 10;
		
	}
	
}
