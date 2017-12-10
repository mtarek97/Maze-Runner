package mazeRunner.model.mapElement;

public abstract class Wall implements MapCell {

	@Override
	public boolean isWall(){
		return true;
	}
	
	@Override

	public boolean isNonObstacle(){
		return false;
	}
	@Override
	public boolean isObstacle() {
		return false;
	}
	@Override
	public boolean isWay(){
		return false;
	}

	@Override
	public int getDamage() {
		return 0;
	}
	
	
}
