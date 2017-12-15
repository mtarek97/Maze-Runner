package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithAK extends RunnerDecorator {

	public WithAK(IRunner runner, int ammo) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("AK", ammo);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
	}

}
