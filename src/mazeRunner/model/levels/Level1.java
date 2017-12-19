package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level1 extends Level{

	public Level1(){
		this.mapSize = new MapSize(10, 10);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 1;
	}
	
}
