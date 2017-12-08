package mazeRunner.model.mapElement;

public abstract class Way implements MapCell {

	@Override
	public boolean isObstacle() {
		return false;
	}

	@Override
	public boolean isWay() {
		return true;
	}
	
/*in case we want to make ways destroyable*/
//	@Override
//	public boolean isDestroyable() {
//		return false;
//	}

//	@Override
//	public String getDestroyingSound() {
//		return null;
//	}
	
//	@Override
//	public int getDamage() {
//		return 0;
//	}
	@Override
	public int getHealth() {
		return 0;
	}

	@Override
	public void setHealth(int health) {
		
	}
	@Override
	public void addBulletsVisualEffect(int num) {		
	}

	@Override
	public String getHittingSound() {
		return null;
	}

	

}
