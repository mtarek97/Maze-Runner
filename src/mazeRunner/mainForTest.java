package mazeRunner;

import mazeRunner.model.difficulty.Difficulty;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.mapBuilder.MapBuilder;

public class mainForTest {

    public static void main(String[] args) {

        MapBuilder builder = MapBuilder.createMapBuilder();
        builder.setDifficulty(new Difficulty());
        Map map = builder.getMap();

    }

}
