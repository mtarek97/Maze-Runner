package mazeRunner.model.levels;

import java.util.List;
import java.util.Map;

public interface ILevel {
	
	public MapSize getMapSize();
	
	public int getTheme();

	public List<Class<?>> getSupportedMapCells();
	
	public Map<String, Integer> getSupportedMapCellsCounts();

	public int getRunnerSpeed();

}
