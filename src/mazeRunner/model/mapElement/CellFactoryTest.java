package mazeRunner.model.mapElement;

import java.util.ArrayList;
import java.util.HashMap;

public class CellFactoryTest {

	public static void main(String[] args) {
		CellFactory cf = new CellFactory();
		ArrayList< String> hm = new 		ArrayList< String>();
		hm.add("mazeRunner.themes.theme1.HugeBomb");
		hm.add("mazeRunner.themes.theme1.Bullets1");
		hm.add("mazeRunner.themes.theme1.Way1");
		hm.add("mazeRunner.themes.theme1.SolidWall");

		boolean x =cf.setClasses(hm);
		MapCell wall = null;
		MapCell way=null;
		try {
			wall = cf.getUndestroyableWall();
			 way = cf.getWay();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			MapCell Bomb = cf.getInstanceByClassName("mazeRunner.themes.theme1.Bullets1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(x);
		System.out.println(wall.isWall());
		System.out.println(way.isWay());
		System.out.println();

	}

}
