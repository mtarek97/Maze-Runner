package mazeRunner.model.mapElement;

public abstract class Obstacle implements MapCell {

	private boolean isObstacle;
	private boolean isDestroyable;
	
	@Override
	public boolean isObstacle() {
		
		return isObstacle;
	}

	@Override
	public boolean isDestroyable() {
		
		return isDestroyable;
	}
	
	
}
