package mazeRunner.model;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner1;
import mazeRunner.model.utilities.GameContract;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class GameSetting {

	/** shared setting (for all the game) **/
	private IRunner currentRunner = new Runner1();
	private List<Class<? extends IRunner>> supportedRunners = new ArrayList<Class<? extends IRunner>>() {
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

	public String getCustomMapCellImageLink(String CustomMapCellName) {
		return customMapCellsImageLinks.get(CustomMapCellName);
	}

	public void addCustomMapCellImageLink(String CustomMapCellName, String path) {
		// TODO : Dynamic Linkage
		customMapCellsImageLinks.put(CustomMapCellName, path);
	}

	public void addRunner(String selectedFilePath) {
		// TODO : Dynamic Linkage
		try {
			JarInputStream jarFile = new JarInputStream(new FileInputStream(selectedFilePath));
			JarEntry jarEntry;
			ArrayList<String> names = new ArrayList<>();
			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if (jarEntry.getName().endsWith(".class")) {
					String classBinName = jarEntry.getName().replaceAll("/", "\\.");
					classBinName = classBinName.substring(0, classBinName.length() - 6);
					names.add(classBinName);
				}
			}
			ClassLoader mainLoader = getClass().getClassLoader();
			ClassLoader loader = URLClassLoader.newInstance(new URL[] { new File(selectedFilePath).toURI().toURL() },
					mainLoader);
			Class<? extends IRunner> runner = (Class<? extends IRunner>) loader.getClass().forName(names.get(0), true,
					loader);
			if (runner.newInstance() instanceof IRunner) {
				System.out.println(runner.getSimpleName());
				supportedRunners.add(runner);
			}
			jarFile.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public int getCustomDifficulty() {
		return customDifficulty;
	}

	public void setCustomDifficulty(int customDifficulty) {
		this.customDifficulty = customDifficulty;
	}

}