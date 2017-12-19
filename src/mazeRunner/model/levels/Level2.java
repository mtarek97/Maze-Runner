package mazeRunner.model.levels;

public class Level2 extends Level {

	public Level2(){
		this.mapSize = new MapSize(50, 50);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = 2;
		this.numberOfCheckPoints = 2;

	}
}
