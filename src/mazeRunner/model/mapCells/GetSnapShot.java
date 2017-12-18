package mazeRunner.model.mapCells;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.movingObjects.runners.Runner;

public class GetSnapShot {
    private  static Runner runner;
    private static Map map;
    private GetSnapShot() {

    }

    protected static void takeSnapShot(Runner snapOfrunner, Map snapOfmap) {
        map.setCorrectWay(snapOfmap.getCorrectWay());
        map.setSolidWallAndWaysLayer(snapOfmap.getSolidWallAndWaysLayer());
        map.setCellsLayer(snapOfmap.getCellsLayer());
        map.setLevel(snapOfmap.getLevel());
        map.setEndPoint(snapOfmap.getEndPoint());
        map.setRunner(snapOfmap.getRunner());
        map.setMovingObjectsLayer(snapOfmap.getMovingObjectsLayer());


        runner.setImageLinks(snapOfrunner.getImageLinks());
        runner.setDirection(snapOfrunner.getDirection());
        runner.setHealth(snapOfrunner.getHealth());
        runner.setMappedPosition(snapOfrunner.getMappedPosition());
        runner.setSpeed(snapOfrunner.getSpeed());
        runner.setSupportedWeapons(snapOfrunner.getSupportedWeapons());
        runner.setPosition(snapOfrunner.getPosition());

    }

    public static Runner GetRunner() {
        return runner;
    }

    public static Map GetMap() {
        return map;
    }
}
