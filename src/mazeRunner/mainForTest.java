package mazeRunner;

import mazeRunner.model.levels.ILevel;
import mazeRunner.model.levels.Level1;

public class mainForTest {

    public static void main(String[] args) {

       /* MapBuilder builder = MapBuilder.createMapBuilder();
        builder.setLevel(new Level1());
        Map map = builder.getMap();*/
    	
    	
    	
    	//------------------------- Level ---------------------------//
    	ILevel level1 = new Level1();
    	System.out.println(level1.getMapSize());
    	System.out.println(level1.getSupportedMapCells());
    	System.out.println(level1.getSupportedMapCells().get(0).getSimpleName());
    	System.out.println(level1.getSupportedMapCellsCounts());
    }

}
