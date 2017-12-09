package mazeRunner.model.levels;

import java.util.List;

public interface ILevel {
	
	public void setSize(MapSize size);
	
	public MapSize getSize();
	
	public void setTheme(int theme);
	
	public int getTheme();
	
	public List<Class<?>> getSupportedMapCells();
	
	public void setSupportedMapCells();	
	
	public int getObstacleCount();

	public void setObstacleCount(int obstacleCount) ;

	public int getNonObstacleCount();

	public void setNonObstacleCount(int nonObstacleCount);
	
}
