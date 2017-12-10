package mazeRunner.model.levels;

public class Level3 extends Level{

	public Level3(){
		this.mapSize = new MapSize(70, 70);
		this.theme = 1;
		this.obstacleCount = 20;
		this.nonObstacleCount = 22;
		this.runnerSpeed = 30;
		addSupportedMapCells();
	}
}
