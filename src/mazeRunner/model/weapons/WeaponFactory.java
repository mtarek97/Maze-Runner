package mazeRunner.model.weapons;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WeaponFactory {

	public Weapon getWeapon(String weaponName, int ammo) {
		ClassLoader classLoader = this.getClass().getClassLoader();
		String packageBinName = "mazeRunner.model.weapons.";
		Class weapon = null;
		try {
			weapon = classLoader.loadClass(packageBinName.concat(weaponName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Constructor<?> constuctor = null;
		try {
			Class cls[] = new Class[] { int.class };
			constuctor = weapon.getConstructor(cls);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			return (Weapon) constuctor.newInstance(ammo);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;

	}

}
