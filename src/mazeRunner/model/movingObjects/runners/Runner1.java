package mazeRunner.model.movingObjects.runners;

import java.util.ArrayList;

import mazeRunner.model.weapons.Weapon;

public class Runner1 extends Runner{

	public Runner1(){
		setImageLinks(new String("images/mainRunner.gif"));
		setSupportedWeapons(new ArrayList<Weapon>());
	}
}
