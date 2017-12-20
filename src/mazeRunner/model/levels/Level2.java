package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level2 extends Level {

	public Level2(){
		this.mapSize = new MapSize(12, 12);
		this.theme = 1;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.HIGH;
		this.numberOfCheckPoints = 1;

	}
}
