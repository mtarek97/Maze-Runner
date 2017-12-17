package mazeRunner.model.movingObjects.runners;

import java.util.ArrayList;

import mazeRunner.model.weapons.Weapon;

public class Runner1 extends Runner{

	public Runner1(){
		setImageLinks(new String("C/Users/Mustafa/IdeaProjects/Maze-Runner/src/mazeRunner/themes/theme1/media/images/mainRunner.gif"));
		setSupportedWeapons(new ArrayList<Weapon>());
	}
}
