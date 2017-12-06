package mazeRunner.model.runner;

public class Runner implements IRunner{

	private int speed;
	private int direction;
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
		
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
		
	}

	@Override
	public int getDirection() {
		return direction;
	}

}
