package mazeRunner.model.levels;

import mazeRunner.model.utilities.GameContract;

public class Level15 extends Level{

	public Level15(){
		this.mapSize = new MapSize(40, 40);
		this.theme = 3;
		addSupportedMapCells();
		setSupportedMapCellsCount();
		this.runnerSpeed = GameContract.Speed.LOW;
		this.numberOfCheckPoints = 3;
	}
}
