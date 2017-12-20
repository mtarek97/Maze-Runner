package mazeRunner.model.mapCells;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.movingObjects.runners.Runner;

public class CheckPoint implements MapCell {
    @Override
    public boolean isCauseDamage() {
        return false;
    }

    @Override
    public boolean isWay() {
        return true;
    }

    @Override
    public boolean isWall() {
        return false;
    }

    @Override
    public boolean isNonObstacle() {
        return false;
    }

    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public boolean isDestroyable() {
        return false;
    }

    @Override
    public MapCell getUpdateResult() {


        return null;
    }
    public void takeSnapShot(Map map, Runner runner) throws InstantiationException, IllegalAccessException {

        GetSnapShot.takeSnapShot(runner, map);
    }

    @Override
    public boolean update(int fullDamage) {
        return false;
    }

    @Override
    public String getDestroyingSound() {
        return null;
    }

    @Override
    public String getHittingSound() {
        return null;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public String getImageLink() {
        return "images/CheckPoint.png";
    }

    @Override
    public String getLayer() {
        return "cellsLayerPane";
    }
}
