package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level12 extends Level{

	public Level12(){
		this.mapSize = new MapSize(32, 32);
		this.theme = 3;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 3;
	}
}
