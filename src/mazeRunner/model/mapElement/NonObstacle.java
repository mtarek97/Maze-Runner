package mazeRunner.model.mapElement;

public abstract class NonObstacle implements MapCell {


	
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
	
	@Override
	public void addBombVisualEffects(int direction, int fullDamage) {
		if(this.getHealth()<=fullDamage){
		this.Destroy();   // gifts are destroyable by bombs
		}else {
			this.setHealth(this.getHealth()-fullDamage);
		}
	}
	@Override
	public void addBulletsVisualEffect(int num) {
		if(this.getHealth()<= num){
			this.Destroy();   // gifts are destroyable by bombs
			}else {
				this.setHealth(this.getHealth()-num);
			}
	}
	
	@Override
	public int getDamage() {
		return 0;
	}
	
	@Override
	public boolean addObserver(IObserver observer, int ObservingDirection) {
		return false;
	}

	@Override
	public boolean removeObserver(IObserver observer) {
		return false;
	}

	@Override
	public boolean notifyChanges() {
		return false;
	}
	
	
	
}
