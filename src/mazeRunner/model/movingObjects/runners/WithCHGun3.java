package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithCHGun3 extends RunnerDecorator {

	public WithCHGun3(IRunner runner, int ammo, int oneBulletDamage) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("CHGun3", ammo, oneBulletDamage);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
	}

}
