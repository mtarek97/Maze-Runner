package mazeRunner.model.movingObjects.monsters;

import mazeRunner.model.mapBuilder.Map;

public class StupidMonster implements IMonsterBehavior , Runnable  {

    Map map;

    public StupidMonster(Map map) {
        this.map = map;
    }

    @Override
    public void run() {

    }


}
