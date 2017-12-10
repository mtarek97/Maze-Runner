package mazeRunner.model.levels;

import java.util.List;

public interface ILevel {
	
	public void setSize(MapSize size);
	
	public MapSize getSize();
	
	public void setTheme(int theme);
	
	public int getTheme();
	
	public void setSupportedMapCells();	
	
	public List<Class<?>> getSupportedMapCells();
	
	public void setObstacleCount(int obstacleCount);
	
	public int getObstacleCount();

	public void setNonObstacleCount(int nonObstacleCount);

	public int getNonObstacleCount();
	
	public void setRunnerSpeed(int runnerSpeed);

	public int getRunnerSpeed();

}
