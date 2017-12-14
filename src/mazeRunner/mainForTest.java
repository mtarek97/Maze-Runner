package mazeRunner;

import java.util.ArrayList;

import javafx.util.Pair;
import mazeRunner.model.levels.ILevel;
import mazeRunner.model.levels.Level1;
import mazeRunner.model.mapCells.CellFactory;
import mazeRunner.model.mapCells.MapCell;

public class mainForTest {

	public static void main(String[] args) {
		/*
		 * MapBuilder builder = MapBuilder.createMapBuilder();
		 * builder.setLevel(new Level1());
		 * Map map = builder.getMap();
		 */

		
		 //------------------------- Level ---------------------------//
		/* ILevel level1 = new Level1();
		 System.out.println();
		 System.out.println(level1.getSupportedMapCells());
		 System.out.println(level1.getSupportedMapCells().get(0).getSimpleName()); 
		 System.out.println(level1.getSupportedMapCellsCounts());
		 //-------------------------------map cells------------------------//
		 CellFactory cf = new CellFactory();
			ArrayList< String> hm = new ArrayList< String>();
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
			System.out.println();*/
		//-------------------------------------------------------------------------//


	}

}
