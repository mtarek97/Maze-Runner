package mazeRunner.model.levels;

public class Level2 extends Level {

	public Level2(){
		this.mapSize = new MapSize(50, 50);
		this.theme = 1;
		this.obstacleCount = 15;
		this.nonObstacleCount = 17;
		this.runnerSpeed = 20;
		addSupportedMapCells();
	}
}
