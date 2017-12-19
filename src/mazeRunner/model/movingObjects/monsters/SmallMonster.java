package mazeRunner.model.movingObjects.monsters;

import mazeRunner.model.mapBuilder.Map;

public class SmallMonster extends Monster{
    public SmallMonster(Map map) {
        this.setMap(map);
    }

    @Override
    public int getHealth() {
        return 5;
    }

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public void setBehaviour() {
        behavior = new StupidMonster(map);
    }

}
