package mazeRunner.model.mapElement;

public  abstract class NonObstacle implements IMapCell {


	
	@Override
	public boolean isObstacle() {
		return false;
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
