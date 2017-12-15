package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithA4 extends RunnerDecorator {

	public WithA4(IRunner runner, int ammo) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("A4", ammo);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
	}

}
