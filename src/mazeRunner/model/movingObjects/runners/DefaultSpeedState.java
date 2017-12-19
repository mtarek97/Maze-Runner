package mazeRunner.model.movingObjects.runners;

public class DefaultSpeedState implements SpeedState{

	private final int speedValue;
	
	public DefaultSpeedState(int levelRunnerSpeed) {
		speedValue = levelRunnerSpeed;
	
	}
	
	@Override
	public void setRunnerSpeedState(IRunner runner) {
		runner.setSpeedState(this);
	}
	
	@Override
	public int getSpeedValue() {
		return speedValue;
	}


}
