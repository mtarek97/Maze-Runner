package mazeRunner.model.movingObjects.runners;

import java.util.ArrayList;

import mazeRunner.model.weapons.Weapon;

public class Runner2 extends Runner {

	public Runner2(){
		setImageLinks(new String[]{"","","",""});
		setSupportedWeapons(new ArrayList<Class<? extends Weapon>>());
	}
}
