package mazeRunner.model.mapElement;

public abstract  class Obstacle implements IMapCell {

IMapCell m  = null;
	
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

}
