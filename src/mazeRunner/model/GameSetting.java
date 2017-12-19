package mazeRunner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner1;
import mazeRunner.model.utilities.GameContract;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class GameSetting {

	/** shared setting (for all the game) **/
	private IRunner currentRunner = new Runner1();
	private List<Class<? extends IRunner>> supportedRunners = new ArrayList<Class<? extends IRunner>>(){
		{
			ClassLoader classLoader = this.getClass().getClassLoader();
			String packageBinName = "mazeRunner.model.movingObjects.runners.";
			try {
				add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner1")));
				add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner2")));
				add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner3")));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	};
	
	
	/** custom level setting **/
	private int customDifficulty = GameContract.Difficulty.EASY;
	private int customRunnerSpeed = GameContract.Speed.LOW;
	private Map<String, String> customMapCellsImageLinks = new HashMap<String, String>() {
		{
			put("CustomBomb", "images/Dynamite.png");
			put("CustomDestroyableWall", "images/box.png");
			put("CustomHealthGift", "images/medicine.png");
			put("CustomSolidWall", "images/wall.png");
			put("CustomWay", "images/land.jpg");
		}
	};

	private static GameSetting gameSetting = new GameSetting();

	public static GameSetting getGameSetting() {
		return gameSetting;
	}

	public IRunner getCurrentRunner() {
		return currentRunner;
	}

	public void setCurrentRunner(IRunner currentRunner) {
		this.currentRunner = currentRunner;
	}

	public List<Class<? extends IRunner>> getSupportedRunners() {
		return supportedRunners;
	}
	
	public int getCustomRunnerSpeed() {
		return customRunnerSpeed;
	}

	public void setCustomRunnerSpeed(int customRuunerSpeed) {
		this.customRunnerSpeed = customRuunerSpeed;
	}

	public String getCustomMapCellImageLink(String CustomMapCellName){
		return customMapCellsImageLinks.get(CustomMapCellName);
	}

	
	public void addCustomMapCellImageLink(String CustomMapCellName){
		// TODO : Dynamic Linkage
	}
	
	public void addRunner() {
		// TODO : Dynamic Linkage
	}

	public int getCustomDifficulty() {
		return customDifficulty;
	}

	public void setCustomDifficulty(int customDifficulty) {
		this.customDifficulty = customDifficulty;
	}

}