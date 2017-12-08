package mazeRunner.model.mapElement;

public  abstract class Obstacle implements MapCell {


	
	@Override
	public boolean isObstacle() {
		return true;
	}

	@Override
	public boolean isWay() {
		return false;
	}

	@Override
	public boolean isDestroyable() {
		return true;
	}


	@Override
	public void addBombVisualEffects(int direction, int fullDamage) {
		this.Destroy();
	}

	@Override
	public void addBulletsVisualEffect(int num) {
		this.Destroy(); 		
	}

	
}
