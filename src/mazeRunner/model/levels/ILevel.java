package mazeRunner.model.levels;

import java.util.List;
import java.util.Map;

public interface ILevel {

	/**
	 * get 2D map size of the level.
	 * @return MapSize object
	 */
	public MapSize getMapSize();

	/**
	 * get level theme.
	 * @return number of the theme
	 */
	public int getTheme();

	/**
	 * get all supported map cells of the level theme to be created in the map builder.
	 * @return list of supported map cells
	 */
	public List<Class<?>> getSupportedMapCells();

	/**
	 * get counts of all supported map cells of the level theme to be generated in the map.
	 * @return map of supported map cell name and its count
	 */
	public Map<String, Integer> getSupportedMapCellsCounts();

	/**
	 * get runner speed in this level.
	 * @return speed value
	 */
	public int getRunnerSpeed();

}
