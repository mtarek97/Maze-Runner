package mazeRunner.model.levels;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ILevelFactory {

	public ILevel getLevel(int levelID) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		String packageBinName = "mazeRunner.model.levels.Level";
		Class level = null;
		try {
			level = classLoader.loadClass(packageBinName.concat(String.valueOf(levelID)));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Constructor<?> constuctor = null;
		try {
			constuctor = level.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			return (ILevel) constuctor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;

	}
}
