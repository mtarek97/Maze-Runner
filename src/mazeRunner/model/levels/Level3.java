package mazeRunner.model.levels;

public class Level3 extends Level{

	public Level3(){
		this.mapSize = new MapSize(70, 70);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = 3;
		this.numberOfCheckPoints = 3;
	}
}
