package mazeRunner.model.mapElement;

public abstract class Wall implements IMapCell {

	@Override
	public boolean isObstacle() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isWay() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public int getDamage() {
		return 0;
	}
	
	
}
