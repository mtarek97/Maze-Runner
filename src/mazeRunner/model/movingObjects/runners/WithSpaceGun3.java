package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithSpaceGun3 extends RunnerDecorator {

	public WithSpaceGun3(IRunner runner, int ammo, int oneBulletDamage) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("spaceGun3", ammo, oneBulletDamage);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
		super.setCurrentWeapon(newWeapon);
	}

}
