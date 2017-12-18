package mazeRunner.model;

import java.util.ArrayList;
import java.util.List;

import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner1;

/**
 * Created by Mustafa on 12/10/2017.
 */
public class GameSetting {
	
	// the current runner
	private IRunner currentRunner = new Runner1();
	
	private List<Class<? extends IRunner>> supportedRunners = new ArrayList<Class<? extends IRunner>>();
	
	//i comment it because i don't know how we will deal with it in the game logic
	//private List<Class<? extends IMonster>> supportedMonsters = new ArrayList<Class<? extends IMonster>>();
    
	public GameSetting(){
		setSupportedRunners();
		// the default runner
		try {
			setCurrentRunner(getSupportedRunners().get(0).newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
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

	private void setSupportedRunners() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		String packageBinName = "mazeRunner.model.movingObjects.runners.";
		try {
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner1")));
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner2")));
			supportedRunners.add((Class<? extends IRunner>) classLoader.loadClass(packageBinName.concat("Runner3")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// dynamic loading for runner
	public void addRunner(){
		// TODO : Dynamic Linkage
	}

}