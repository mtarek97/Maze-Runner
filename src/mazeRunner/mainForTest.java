package mazeRunner;

import mazeRunner.model.GameSetting;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.IRunnerFactory;
import mazeRunner.model.movingObjects.runners.WithA4;
import mazeRunner.model.movingObjects.runners.WithAK;
import mazeRunner.model.movingObjects.runners.WithPistol;

public class mainForTest {

	public static void main(String[] args) {
		/*
		 * MapBuilder builder = MapBuilder.createMapBuilder();
		 * builder.setLevel(new Level1());
		 * Map map = builder.getMap();
		 */

		
		 //------------------------- Level ---------------------------//
		 /*ILevelFactory levelFactory = new ILevelFactory();
		 ILevel level1 = levelFactory.getLevel(1);
		 System.out.println();
		 System.out.println(level1.getSupportedMapCells());
		 System.out.println(level1.getSupportedMapCells().get(0).getSimpleName()); 
		 System.out.println(level1.getSupportedMapCellsCounts());
		 //-------------------------------map cells------------------------//
		/* CellFactory cf = new CellFactory();
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
		//--------------------------------decorator---------------------------------//

		 GameSetting setting = GameSetting.getGameSetting();
		 IRunnerFactory runnerFactory = new IRunnerFactory(setting);
		 IRunner runner = runnerFactory.getRunner("Runner1");
		 System.out.println(runner.getSupportedWeapons());
		 runner = new WithPistol(runner, 6,3);
		 System.out.println(runner.getSupportedWeapons());
		 System.out.println(runner.getCurrentWeapon());
		 runner = new WithA4(runner, 6,3);
		 System.out.println(runner.getSupportedWeapons());
		 System.out.println(runner.getCurrentWeapon());
		 runner = new WithAK(runner, 6,3);
		 System.out.println(runner.getSupportedWeapons());
		 System.out.println(runner.getCurrentWeapon());
		// --------------------state design pattern ------------------- //
	/*	GameSetting setting = GameSetting.getGameSetting();
		 IRunnerFactory runnerFactory = new IRunnerFactory(setting);
		 ILevelFactory levelFactory = new ILevelFactory();
		 IRunner runner = runnerFactory.getRunner("Runner1");
		 System.out.println(runner);
		 ILevel level = levelFactory.getLevel(3);
		 
		 DefaultSpeedState defaultSpeedState = new DefaultSpeedState(level.getRunnerSpeed());
		 defaultSpeedState.setRunnerSpeedState(runner);
		 System.out.println(runner.getSpeedState());
		 System.out.println(runner.getSpeedState().getSpeedValue());
	
		 HalfHealthSpeedState HalfHealthSpeedState = new HalfHealthSpeedState(level.getRunnerSpeed());
		 HalfHealthSpeedState.setRunnerSpeedState(runner);
		 System.out.println(runner.getSpeedState());
		 System.out.println(runner.getSpeedState().getSpeedValue());*/
	}

}
