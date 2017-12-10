package mazeRunner.model.mapElement;

public abstract  class Obstacle implements MapCell {


	@Override
	public boolean isWall(){
		return false;
	}
	
	@Override

	public boolean isNonObstacle(){
		return false;
	}
	@Override
	public boolean isObstacle() {
		return true;
	}
	@Override
	public boolean isWay(){
		return false;
	}
	@Override
	public boolean isDestroyable() {
		return true;
	}


	
}
