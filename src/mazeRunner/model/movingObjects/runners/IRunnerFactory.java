package mazeRunner.model.movingObjects.runners;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import mazeRunner.model.GameSetting;

public class IRunnerFactory {

	private GameSetting setting;

	public IRunnerFactory(GameSetting setting) {
		this.setting = setting;
	}

	// get instance by name
	public IRunner getRunner(String runnerName) {

		for (Class<? extends IRunner> runner : setting.getSupportedRunners()) {
			if (runnerName.equals(runner.getSimpleName())) {
				Constructor<?> constuctor = null;
				try {
					constuctor = runner.getConstructor();
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				try {
					return (IRunner) constuctor.newInstance();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	// get instance by reference
	public IRunner getRunner(IRunner runner) {
		String runnerName = runner.getClass().getSimpleName();
		return getRunner(runnerName);
	}

	
}
