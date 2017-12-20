package mazeRunner.model.mapCells;

import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.movingObjects.runners.Runner;
import mazeRunner.model.movingObjects.runners.Runner1;

public class GetSnapShot {
    private  static Runner runner;
    private static Map map = new Map();
    private GetSnapShot() {

    }

    protected static void takeSnapShot(Runner snapOfrunner, Map snapOfmap) throws IllegalAccessException, InstantiationException {
        map.setCorrectWay(snapOfmap.getCorrectWay());
        map.setSolidWallAndWaysLayer(snapOfmap.getSolidWallAndWaysLayer());
        map.setCellsLayer(snapOfmap.getCellsLayer());
        map.setLevel(snapOfmap.getLevel());
        map.setEndPoint(snapOfmap.getEndPoint());
        map.setRunner(snapOfmap.getRunner());
        map.setMovingObjectsLayer(snapOfmap.getMovingObjectsLayer());
        map.setBooleanMaze(snapOfmap.getBooleanMaze());

        runner = runner.getClass().newInstance();
        runner.setImageLinks(snapOfrunner.getImageLinks());
        runner.setDirection(snapOfrunner.getDirection());
        runner.setHealth(snapOfrunner.getHealth());
        runner.setMappedPosition(snapOfrunner.getMappedPosition());
        runner.setSpeedState(snapOfrunner.getSpeedState());
        runner.setSupportedWeapons(snapOfrunner.getSupportedWeapons());
        runner.setPosition(snapOfrunner.getPosition());

    }

    public static Runner getRunner() {
        return runner;
    }

    public static Map GetMap() {
        return map;
    }
}
