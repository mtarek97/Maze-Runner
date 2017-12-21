package mazeRunner.model.mapCells;

import mazeRunner.model.GameSetting;
import mazeRunner.model.mapBuilder.Map;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.IRunnerFactory;

public class GetSnapShot {
    private static IRunner runner;
    private static Map map = new Map();
    private GetSnapShot() {

    }

    protected static void takeSnapShot(Map snapOfmap) throws IllegalAccessException, InstantiationException {
        map.setCorrectWay(snapOfmap.getCorrectWay());
        map.setSolidWallAndWaysLayer(snapOfmap.getSolidWallAndWaysLayer());
        map.setCellsLayer(snapOfmap.getCellsLayer());
        map.setLevel(snapOfmap.getLevel());
        map.setEndPoint(snapOfmap.getEndPoint());
        map.setRunner(snapOfmap.getRunner());
        map.setMovingObjectsLayer(snapOfmap.getMovingObjectsLayer());
        map.setBooleanMaze(snapOfmap.getBooleanMaze());

        runner = new IRunnerFactory(GameSetting.getGameSetting()).getRunner(map.getRunner());
        runner.setImageLinks(map.getRunner().getImageLinks());
        runner.setDirection(map.getRunner().getDirection());
        runner.setHealth(map.getRunner().getHealth());
        runner.setMappedPosition(map.getRunner().getMappedPosition());
        runner.setSpeedState(map.getRunner().getSpeedState());
        runner.setSupportedWeapons(map.getRunner().getSupportedWeapons());
        runner.setPosition(map.getRunner().getPosition());

    }

    public static IRunner getRunner() {
        return runner;
    }

    public static Map GetMap() {
        return map;
    }
}
