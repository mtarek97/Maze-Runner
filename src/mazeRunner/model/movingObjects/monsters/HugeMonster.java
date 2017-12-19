package mazeRunner.model.movingObjects.monsters;

import mazeRunner.model.mapBuilder.Map;

public class HugeMonster extends Monster{
    public HugeMonster(Map map) {
        this.setMap(map);
    }

    @Override
    public int getHealth() {
        return 10;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public void setBehaviour() {
        behavior = new SmartMonster(map, this.getMappedPosition());
    }

}
