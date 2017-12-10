package mazeRunner.model.levels;

import java.util.List;

public interface ILevel {
	
	public MapSize getMapSize();
	
	public int getTheme();
	
	public void addSupportedMapCells();	
	
	public List<Class<?>> getSupportedMapCells();

	public int getObstacleCount();

	public int getNonObstacleCount();

	public int getRunnerSpeed();

}
