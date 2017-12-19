package mazeRunner.model.movingObjects.runners;

public class HalfHealthSpeedState implements SpeedState{

	private final int speedValue;
	
	public HalfHealthSpeedState(int levelRunnerSpeed) {
		speedValue = (int) Math.ceil(levelRunnerSpeed/2);
	
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
