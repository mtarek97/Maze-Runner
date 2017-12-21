package mazeRunner.model.movingObjects.runners;

import java.util.List;

import mazeRunner.model.weapons.Weapon;
import mazeRunner.model.weapons.WeaponFactory;

public class WithCHGun2 extends RunnerDecorator {

	public WithCHGun2(IRunner runner, int ammo, int oneBulletDamage) {
		super(runner);
		Weapon newWeapon = new WeaponFactory().getWeapon("CHGun2", ammo, oneBulletDamage);
		List<Weapon> supportedWeapons = super.getSupportedWeapons();
		supportedWeapons.add(newWeapon);
		super.setSupportedWeapons(supportedWeapons);
		super.setCurrentWeapon(newWeapon);
	}

}
